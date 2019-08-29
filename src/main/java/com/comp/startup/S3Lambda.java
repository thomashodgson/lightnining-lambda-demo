package com.comp.startup;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.S3Event;
import com.comp.DynamoUserReader;
import com.comp.Unit_756owa_root_0;
import com.comp.Unit_756owa_root_0_0;
import com.comp.Unit_tioih_root_1_1;
import com.comp.Unit_tioih_root_1_3;
import com.comp.Unit_tioih_root_2;
import com.comp.Unit_tioih_root_2_1;
import com.comp.UserExporter;
import com.comp.UserIdParser;
import com.comp.aws.dynamo.DynamoClientProvider;
import com.comp.aws.dynamo.DynamoItemReader;
import com.comp.aws.s3.S3EventHandler;
import com.comp.aws.s3.S3FileWriter;
import com.comp.config.ConfigProvider;
import com.comp.config.EnvironmentProvider;

public class S3Lambda implements RequestHandler<S3Event, Void> {
  private final S3EventHandler s3EventHandler;

  public S3Lambda() {
    this.s3EventHandler =
        new S3EventHandler() {
          private final Unit_756owa_root_0 unit_756owa_root_0 =
              new Unit_756owa_root_0(
                  new Unit_756owa_root_0_0(),
                  new UserExporter(
                      new UserIdParser(),
                      new DynamoUserReader(
                          new ConfigProvider(new EnvironmentProvider()),
                          new Unit_tioih_root_1_1(),
                          new DynamoItemReader(new DynamoClientProvider()),
                          new Unit_tioih_root_1_3()),
                      new Unit_tioih_root_2(
                          new ConfigProvider(new EnvironmentProvider()),
                          new Unit_tioih_root_2_1(),
                          new S3FileWriter())));

          public void execute(final S3Event s3Event, final Context context) {
            unit_756owa_root_0.execute(s3Event);
          }
        };
  }

  @Override
  public Void handleRequest(final S3Event s3Event, final Context context) {
    s3EventHandler.execute(s3Event, context);
    return null;
  }
}
