package com.comp;

import com.amazonaws.services.lambda.runtime.events.S3Event;

public class Unit_756owa_root_0_0 {
  public String execute(final S3Event s3Event) {

    String fileName = s3Event.getRecords().get(0).getS3().getObject().getKey();
    return fileName;
  }
}
