package com.bifrost.poc.controller;


import com.bifrost.poc.messages.PatronProfile;
import java.util.Base64;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Slf4j
public class APIController {


  @RequestMapping(value = "/api/profileUpdate", method = RequestMethod.POST)
  public String profileUpdate(@RequestBody Integer[] request) {
    byte message[] = new byte[request.length];
    for (int i = 0; i < request.length; i++) {
      message[i] = request[i].byteValue();
    }
    java.nio.ByteBuffer buf = java.nio.ByteBuffer.wrap(message);
    PatronProfile patronProfile = PatronProfile.getRootAsPatronProfile(buf);
    log.warn("PatronProfile homeLibraryCode : ,{}",patronProfile.homeLibraryCode());
    return "test";
  }


  @RequestMapping(value = "/api/profileUpdateBase64", method = RequestMethod.POST)
  public String profileUpdateBase64(@RequestBody String base64) {
    byte[] decodedString = Base64.getDecoder().decode(base64.getBytes());
    java.nio.ByteBuffer buf = java.nio.ByteBuffer.wrap(decodedString);
    PatronProfile patronProfile = PatronProfile.getRootAsPatronProfile(buf);
    log.warn("PatronProfile homeLibraryCode : ,{}",patronProfile.homeLibraryCode());
    log.warn("PatronProfile name : ,{}",patronProfile.name());
    return "test";
  }


  @RequestMapping(value = "/api/profileUpdateRawByteArray", method = RequestMethod.POST, consumes = MediaType.APPLICATION_OCTET_STREAM_VALUE)
  public String profileUpdateRawByteArray(@RequestBody byte[] bytes) {
    java.nio.ByteBuffer buf = java.nio.ByteBuffer.wrap(bytes);
    PatronProfile patronProfile = PatronProfile.getRootAsPatronProfile(buf);
    log.warn("PatronProfile homeLibraryCode : ,{}",patronProfile.homeLibraryCode());
    log.warn("PatronProfile name : ,{}",patronProfile.name());
    return "test";
  }


}
