package com.bifrost.poc;

import com.bifrost.poc.messages.PatronProfile;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JSR310Module;
import com.fasterxml.jackson.module.afterburner.AfterburnerModule;
import com.google.common.collect.Maps;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.jetty.server.HttpConnectionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.jetty.JettyEmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.jetty.JettyServerCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
@Slf4j
public class BifrostPocApplication extends WebMvcConfigurerAdapter {

  public static void main(String[] args) {
    SpringApplication.run(BifrostPocApplication.class, args);
  }

  @Bean
  ObjectMapper objectMapper() {
    ObjectMapper mapper = new ObjectMapper();
    mapper.registerModules(new AfterburnerModule(), new JSR310Module());
    mapper.enable(SerializationFeature.INDENT_OUTPUT);
    mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
    mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
    mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    return mapper;
  }


  @Bean
  FlatBuffersHttpMessageConverter flatBuffersHttpMessageConverter() {
    try {
      Map<String, FlatBuffersMessage> repo = Maps.newHashMap();
      repo.put("1", new FlatBuffersMessage("1", PatronProfile.class));
      repo.put("2", new FlatBuffersMessage("2", PatronProfile.class));

      return new FlatBuffersHttpMessageConverter(repo);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }


  @Override
  public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
    converters.add(flatBuffersHttpMessageConverter());
  }

  @Override
  public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
    configurer.defaultContentType(FlatBuffersHttpMessageConverter.X_FLATBUFFERS);
  }

  // Withdraw Server header directives.
  @Bean
  JettyServerCustomizer jettyServerCustomizer() {
    return server -> {
      Stream.of(server.getConnectors())
        .flatMap(conn -> conn.getConnectionFactories().stream())
        .flatMap(f -> (f instanceof HttpConnectionFactory) ?
          Stream.of((HttpConnectionFactory) f) : Stream.empty())
        .forEach(f -> f.getHttpConfiguration().setSendServerVersion(false));
    };
  }

  @Bean
  JettyEmbeddedServletContainerFactory jettyEmbeddedServletContainerFactory(
    JettyServerCustomizer[] customizer
  ) {
    JettyEmbeddedServletContainerFactory factory = new JettyEmbeddedServletContainerFactory();
    factory.addServerCustomizers(customizer);
    return factory;
  }
}
