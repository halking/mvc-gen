package com.hal.entity;

import java.lang.String;
import java.util.Date;

public class Reference {
  private long id;

  private long modelId;

  private String brand;

  private String referenceWorld;

  private String serialNumber;

  private boolean availableForSale;

  private boolean visible;

  private Date updateDate;

  private Date selfUpdateDate;

  public void setId(long id) {
    this.id = id;
  }

  public void setModelId(long modelId) {
    this.modelId = modelId;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public void setReferenceWorld(String referenceWorld) {
    this.referenceWorld = referenceWorld;
  }

  public void setSerialNumber(String serialNumber) {
    this.serialNumber = serialNumber;
  }

  public void setAvailableForSale(boolean availableForSale) {
    this.availableForSale = availableForSale;
  }

  public void setVisible(boolean visible) {
    this.visible = visible;
  }

  public void setUpdateDate(Date updateDate) {
    this.updateDate = updateDate;
  }

  public void setSelfUpdateDate(Date selfUpdateDate) {
    this.selfUpdateDate = selfUpdateDate;
  }

  public long getId() {
    return id;
  }

  public long getModelId() {
    return modelId;
  }

  public String getBrand() {
    return brand;
  }

  public String getReferenceWorld() {
    return referenceWorld;
  }

  public String getSerialNumber() {
    return serialNumber;
  }

  public boolean isAvailableForSale() {
    return availableForSale;
  }

  public boolean isVisible() {
    return visible;
  }

  public Date getUpdateDate() {
    return updateDate;
  }

  public Date getSelfUpdateDate() {
    return selfUpdateDate;
  }
}
