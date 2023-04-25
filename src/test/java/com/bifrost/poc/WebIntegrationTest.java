package com.bifrost.poc;

import com.bifrost.poc.messages.PatronProfile;
import com.google.flatbuffers.FlatBufferBuilder;
import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.AsyncHttpClientConfig;
import com.ning.http.client.Response;
import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = BifrostPocApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, properties = "server_port=18080")
public class WebIntegrationTest {

  @LocalServerPort
  int randomPort;

  @Autowired
  WebApplicationContext wac;

  private MockMvc mockMvc;

  @Before
  public void setUp() {
    mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
  }

  @Autowired
  FlatBuffersHttpMessageConverter flatBuffersHttpMessageConverter;

  @After
  public void tearDown() {
  }


  @Test
  public void test_flatbuffers_patron() throws Exception {

    AsyncHttpClient httpclient = new AsyncHttpClient(
      new AsyncHttpClientConfig.Builder().setRequestTimeout(3000).build());

    final Response res = httpclient.preparePost("http://localhost:" + randomPort + "/api/profileUpdateRawByteArray")
      .addHeader("Content-Type", "application/octet-stream")
      .setBody(patron().array())
      .execute()
      .get(3000, TimeUnit.MILLISECONDS);

    log.info("res.contentType:{}", res.getContentType());
    log.info("res.status: {}", res.getStatusCode());

    httpclient.close();

  }

  private static ByteBuffer patron() {
    FlatBufferBuilder fbb = new FlatBufferBuilder(0);
    int homeLibraryCodeBifrost = fbb.createString("ca");
    int address = fbb.createString("address");
    PatronProfile.startPatronProfile(fbb);
    PatronProfile.addAddresses(fbb, address);
    PatronProfile.addHomeLibraryCode(fbb, homeLibraryCodeBifrost);
    int offset = PatronProfile.endPatronProfile(fbb);
    fbb.finish(offset);
    return ByteBuffer.wrap(fbb.sizedByteArray());
  }


}
