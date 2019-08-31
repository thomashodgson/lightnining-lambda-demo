package com.lightning.lambdas;

import com.lightning.lambdas.aws.s3.S3Bucket;
import com.lightning.lambdas.config.Config;

public class S3BucketProvider {
  public S3Bucket execute(final Config config) {

    return config.usersBucket;
  }
}
