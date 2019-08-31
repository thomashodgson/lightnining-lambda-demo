package com.lightning.lambdas;

import com.lightning.lambdas.aws.dynamo.DynamoTable;
import com.lightning.lambdas.config.Config;

public class DynamoTableProvider {
  public DynamoTable execute(final Config config) {

    return config.usersTable;
  }
}
