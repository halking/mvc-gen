package com.hal.entity;

import java.lang.String;

public class ServiceInformationOption {
  private long id;

  private long serviceInformationId;

  private String characteristic;

  private String characteristicValue;

  public void setId(long id) {
    this.id = id;
  }

  public void setServiceInformationId(long serviceInformationId) {
    this.serviceInformationId = serviceInformationId;
  }

  public void setCharacteristic(String characteristic) {
    this.characteristic = characteristic;
  }

  public void setCharacteristicValue(String characteristicValue) {
    this.characteristicValue = characteristicValue;
  }

  public long getId() {
    return id;
  }

  public long getServiceInformationId() {
    return serviceInformationId;
  }

  public String getCharacteristic() {
    return characteristic;
  }

  public String getCharacteristicValue() {
    return characteristicValue;
  }
}
