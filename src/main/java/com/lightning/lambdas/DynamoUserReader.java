package com.lightning.lambdas;

import com.amazonaws.services.dynamodbv2.document.Item;
import com.lightning.lambdas.aws.dynamo.DynamoItemReader;
import com.lightning.lambdas.aws.dynamo.DynamoTable;
import com.lightning.lambdas.config.Config;
import com.lightning.lambdas.config.ConfigProvider;

public class DynamoUserReader {
  private final ConfigProvider configProvider;

  private final DynamoTableProvider dynamoTableProvider;

  private final DynamoItemReader dynamoReader;

  private final Unit_zvqpjr_root_1_3 unit_zvqpjr_root_1_3;

  public DynamoUserReader(
      final ConfigProvider configProvider,
      final DynamoTableProvider dynamoTableProvider,
      final DynamoItemReader dynamoReader,
      final Unit_zvqpjr_root_1_3 unit_zvqpjr_root_1_3) {
    this.configProvider = configProvider;
    this.dynamoTableProvider = dynamoTableProvider;
    this.dynamoReader = dynamoReader;
    this.unit_zvqpjr_root_1_3 = unit_zvqpjr_root_1_3;
  }

  public String execute(final String id) {
    final Config config = configProvider.execute();
    final DynamoTable dynamoTable = dynamoTableProvider.execute(config);
    final Item item = dynamoReader.execute(dynamoTable, id);
    final String string = unit_zvqpjr_root_1_3.execute(item);
    return string;
  }
}
