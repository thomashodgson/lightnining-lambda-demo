package com.comp;

import com.comp.aws.s3.S3Bucket;
import com.comp.aws.s3.S3FileWriter;
import com.comp.config.Config;
import com.comp.config.ConfigProvider;

public class Unit_tioih_root_2 {
  private final ConfigProvider configProvider;

  private final Unit_tioih_root_2_1 unit_tioih_root_2_1;

  private final S3FileWriter s3Writer;

  public Unit_tioih_root_2(
      final ConfigProvider configProvider,
      final Unit_tioih_root_2_1 unit_tioih_root_2_1,
      final S3FileWriter s3Writer) {
    this.configProvider = configProvider;
    this.unit_tioih_root_2_1 = unit_tioih_root_2_1;
    this.s3Writer = s3Writer;
  }

  public void execute(final String content, final String path) {
    final Config config = configProvider.execute();
    final S3Bucket s3Bucket = unit_tioih_root_2_1.execute(config);
    s3Writer.execute(s3Bucket, path, content);
  }
}
