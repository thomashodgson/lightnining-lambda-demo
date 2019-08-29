package com.comp;

public class UserExporter {
  private final UserIdParser userIdParser;

  private final DynamoUserReader dynamoUserReader;

  private final Unit_tioih_root_2 unit_tioih_root_2;

  public UserExporter(
      final UserIdParser userIdParser,
      final DynamoUserReader dynamoUserReader,
      final Unit_tioih_root_2 unit_tioih_root_2) {
    this.userIdParser = userIdParser;
    this.dynamoUserReader = dynamoUserReader;
    this.unit_tioih_root_2 = unit_tioih_root_2;
  }

  public void execute(final String fileName) {
    final String userId = userIdParser.execute(fileName);
    final String userJson = dynamoUserReader.execute(userId);
    unit_tioih_root_2.execute(userJson, userId);
  }
}
