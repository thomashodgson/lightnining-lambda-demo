package com.lightning.lambdas;

import com.amazonaws.services.lambda.runtime.events.S3Event;

public class S3FileNameGetter {
  public String execute(final S3Event s3Event) {

    String userId = s3Event.getRecords().get(0).getS3().getObject().getKey();
    return userId;
  }
}
