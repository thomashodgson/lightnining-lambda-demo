package com.lightning.lambdas;

import com.amazonaws.services.lambda.runtime.events.S3Event;

public class Unit_bmptm_root_0 {
  private final S3FileNameGetter s3FileNameGetter;

  private final UserExporter userExporter;

  public Unit_bmptm_root_0(
      final S3FileNameGetter s3FileNameGetter, final UserExporter userExporter) {
    this.s3FileNameGetter = s3FileNameGetter;
    this.userExporter = userExporter;
  }

  public void execute(final S3Event s3Event) {
    final String string = s3FileNameGetter.execute(s3Event);
    userExporter.execute(string);
  }
}
