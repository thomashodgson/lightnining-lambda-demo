package com.comp;

public class UserIdParser {
  public String execute(final String fileName) {

    String userId = fileName.split(":")[0];
    return userId;
  }
}
