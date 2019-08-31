package com.lightning.lambdas.startup;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.S3Event;
import com.lightning.lambdas.DynamoTableProvider;
import com.lightning.lambdas.DynamoUserReader;
import com.lightning.lambdas.S3BucketProvider;
import com.lightning.lambdas.S3FileNameGetter;
import com.lightning.lambdas.S3UserWriter;
import com.lightning.lambdas.Unit_bmptm_root_0;
import com.lightning.lambdas.Unit_zvqpjr_root_1_3;
import com.lightning.lambdas.UserExporter;
import com.lightning.lambdas.UserIdParser;
import com.lightning.lambdas.aws.dynamo.DynamoClientProvider;
import com.lightning.lambdas.aws.dynamo.DynamoItemReader;
import com.lightning.lambdas.aws.s3.S3ClientProvider;
import com.lightning.lambdas.aws.s3.S3EventHandler;
import com.lightning.lambdas.aws.s3.S3FileWriter;
import com.lightning.lambdas.config.ConfigProvider;
import com.lightning.lambdas.config.EnvironmentProvider;

public class S3Lambda implements RequestHandler<S3Event, Void> {
  private final S3EventHandler s3EventHandler;

  public S3Lambda() {
    this.s3EventHandler =
        new S3EventHandler() {
          private final Unit_bmptm_root_0 unit_bmptm_root_0 =
              new Unit_bmptm_root_0(
                  new S3FileNameGetter(),
                  new UserExporter(
                      new UserIdParser(),
                      new DynamoUserReader(
                          new ConfigProvider(new EnvironmentProvider()),
                          new DynamoTableProvider(),
                          new DynamoItemReader(new DynamoClientProvider()),
                          new Unit_zvqpjr_root_1_3()),
                      new S3UserWriter(
                          new ConfigProvider(new EnvironmentProvider()),
                          new S3BucketProvider(),
                          new S3FileWriter(new S3ClientProvider()))));

          public void execute(final S3Event s3Event, final Context context) {
            unit_bmptm_root_0.execute(s3Event);
          }
        };
  }

  @Override
  public Void handleRequest(final S3Event s3Event, final Context context) {
    s3EventHandler.execute(s3Event, context);
    return null;
  }
}
