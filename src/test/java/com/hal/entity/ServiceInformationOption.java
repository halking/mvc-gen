package com.hal.entity;

import java.lang.String;

public class ServiceInformationOption {
  private long id;

  private long serviceInformationid;

  private String characteristic;

  private String characteristicValue;

  public void setId(long id) {
    this.id = id;
  }

  public void setServiceInformationId(long serviceInformationid) {
    this.serviceInformationid = serviceInformationid;
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
    return serviceInformationid;
  }

  public String getCharacteristic() {
    return characteristic;
  }

  public String getCharacteristicValue() {
    return characteristicValue;
  }
}
