package com.lightning.lambdas;

import com.amazonaws.services.dynamodbv2.document.Item;

public class Unit_zvqpjr_root_1_3 {
  public String execute(final Item item) {

    String userJson = item.toJSON();
    return userJson;
  }
}
