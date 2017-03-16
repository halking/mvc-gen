package com.hal.entity;

import java.lang.String;
import java.util.Date;

public class ReferenceInformation {
  private long id;

  private long referenceId;

  private String characteristic;

  private String characteristicValue;

  private String description;

  private Date updateDate;

  public void setId(long id) {
    this.id = id;
  }

  public void setReferenceId(long referenceId) {
    this.referenceId = referenceId;
  }

  public void setCharacteristic(String characteristic) {
    this.characteristic = characteristic;
  }

  public void setCharacteristicValue(String characteristicValue) {
    this.characteristicValue = characteristicValue;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setUpdateDate(Date updateDate) {
    this.updateDate = updateDate;
  }

  public long getId() {
    return id;
  }

  public long getReferenceId() {
    return referenceId;
  }

  public String getCharacteristic() {
    return characteristic;
  }

  public String getCharacteristicValue() {
    return characteristicValue;
  }

  public String getDescription() {
    return description;
  }

  public Date getUpdateDate() {
    return updateDate;
  }
}
