package com.lightning.lambdas;

public class UserExporter {
  private final UserIdParser userIdParser;

  private final DynamoUserReader dynamoUserReader;

  private final S3UserWriter s3UserWriter;

  public UserExporter(
      final UserIdParser userIdParser,
      final DynamoUserReader dynamoUserReader,
      final S3UserWriter s3UserWriter) {
    this.userIdParser = userIdParser;
    this.dynamoUserReader = dynamoUserReader;
    this.s3UserWriter = s3UserWriter;
  }

  public void execute(final String fileName) {
    final String string = userIdParser.execute(fileName);
    final String string = dynamoUserReader.execute(string);
    s3UserWriter.execute(string, string);
  }
}
