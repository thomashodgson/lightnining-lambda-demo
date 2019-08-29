package com.comp;

import com.amazonaws.services.dynamodbv2.document.Item;
import com.comp.aws.dynamo.DynamoItemReader;
import com.comp.aws.dynamo.DynamoTable;
import com.comp.config.Config;
import com.comp.config.ConfigProvider;

public class DynamoUserReader {
  private final ConfigProvider configProvider;

  private final Unit_tioih_root_1_1 unit_tioih_root_1_1;

  private final DynamoItemReader dynamoReader;

  private final Unit_tioih_root_1_3 unit_tioih_root_1_3;

  public DynamoUserReader(
      final ConfigProvider configProvider,
      final Unit_tioih_root_1_1 unit_tioih_root_1_1,
      final DynamoItemReader dynamoReader,
      final Unit_tioih_root_1_3 unit_tioih_root_1_3) {
    this.configProvider = configProvider;
    this.unit_tioih_root_1_1 = unit_tioih_root_1_1;
    this.dynamoReader = dynamoReader;
    this.unit_tioih_root_1_3 = unit_tioih_root_1_3;
  }

  public String execute(final String id) {
    final Config config = configProvider.execute();
    final DynamoTable dynamoTable = unit_tioih_root_1_1.execute(config);
    final Item item = dynamoReader.execute(dynamoTable, id);
    final String userJson = unit_tioih_root_1_3.execute(item);
    return userJson;
  }
}
