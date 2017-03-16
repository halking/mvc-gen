package com.hal.entity;

import java.lang.String;

public class ServiceInformation {
  private long id;

  private long localModelId;

  private String serviceCode;

  private String serviceValue1;

  private String serviceValue2;

  private String description;

  public void setId(long id) {
    this.id = id;
  }

  public void setLocalModelId(long localModelId) {
    this.localModelId = localModelId;
  }

  public void setServiceCode(String serviceCode) {
    this.serviceCode = serviceCode;
  }

  public void setServiceValue1(String serviceValue1) {
    this.serviceValue1 = serviceValue1;
  }

  public void setServiceValue2(String serviceValue2) {
    this.serviceValue2 = serviceValue2;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public long getId() {
    return id;
  }

  public long getLocalModelId() {
    return localModelId;
  }

  public String getServiceCode() {
    return serviceCode;
  }

  public String getServiceValue1() {
    return serviceValue1;
  }

  public String getServiceValue2() {
    return serviceValue2;
  }

  public String getDescription() {
    return description;
  }
}
