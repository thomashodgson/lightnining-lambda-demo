package com.comp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.amazonaws.services.dynamodbv2.document.Item;
import com.comp.aws.dynamo.DynamoItemReader;
import com.comp.aws.dynamo.DynamoTable;
import com.comp.config.Config;
import com.comp.config.ConfigProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DynamoUserReaderTest {
  /** Variables */
  private static final String userId;

  private static final String json;

  private static final DynamoTable table;

  private static final Config config;

  private static final Item item;

  /** Mocked dependencies */
  private ConfigProvider configProvider;

  private DynamoItemReader dynamoReader;

  /** Test fixture */
  private DynamoUserReader dynamoUserReader;

  static {
    userId = "userId";
    json = "{\"name\":\"tom\"}";
    table = new DynamoTable("region", "tableName", "idField");
    config = new Config(null, table);
    item = new Item().withString("name", "tom");
  }

  @BeforeEach
  public void setupTestFixture() {
    configProvider = mock(ConfigProvider.class);
    dynamoReader = mock(DynamoItemReader.class);

    dynamoUserReader =
        new DynamoUserReader(
            configProvider, new Unit_tioih_root_1_1(), dynamoReader, new Unit_tioih_root_1_3());
  }

  @Test
  public void test1() {
    when(configProvider.execute()).thenReturn(config);
    when(dynamoReader.execute(table, userId)).thenReturn(item);

    assertEquals(json, dynamoUserReader.execute(userId), "");
  }
}
