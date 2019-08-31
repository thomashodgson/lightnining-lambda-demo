package com.lightning.lambdas.config;

public class EnvironmentProvider {
  public String execute() {
    return System.getenv("Environment");
  }
}
