package com.comp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserIdParserTest {
  /** Variables */
  private static final String fileName;

  private static final String userId;

  /** Test fixture */
  private UserIdParser userIdParser;

  static {
    fileName = "userId:eventId";
    userId = "userId";
  }

  @BeforeEach
  public void setupTestFixture() {

    userIdParser = new UserIdParser();
  }

  @Test
  public void test1() {

    assertEquals(userId, userIdParser.execute(fileName), "should");
  }
}
