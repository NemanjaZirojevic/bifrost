package com.bifrost.poc;

import static org.junit.Assert.assertEquals;

import com.bifrost.poc.messages.PatronProfile;
import com.google.flatbuffers.FlatBufferBuilder;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
public class FlatbuffersDeserilizationTest {

  @Test
  public void testDeserilization() {

    FlatBufferBuilder fbb = new FlatBufferBuilder(0);
    int homeLibraryCode = fbb.createString("cd");
    int name = fbb.createString("John Doe");
    PatronProfile.startPatronProfile(fbb);
    PatronProfile.addHomeLibraryCode(fbb, homeLibraryCode);
    PatronProfile.addName(fbb, name);
    int patronProfile = PatronProfile.endPatronProfile(fbb);
    fbb.finish(patronProfile);

    PatronProfile profile = PatronProfile.getRootAsPatronProfile(fbb.dataBuffer());

    log.debug("home library code:{}, name:{}",
      profile.homeLibraryCode(), profile.name());
    assertEquals("cd", profile.homeLibraryCode());
    assertEquals("John Doe", profile.name());
  }

}
