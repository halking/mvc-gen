package com.hal.entity;

import java.lang.String;
import java.util.Date;

public class Reference {
  private long id;

  private long modelId;

  private String brand;

  private String referenceWorld;

  private String serialNumber;

  private boolean availableForsale;

  private boolean visible;

  private Date updateDate;

  private Date selfUpdatedate;

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

  public void setAvailableForSale(boolean availableForsale) {
    this.availableForsale = availableForsale;
  }

  public void setVisible(boolean visible) {
    this.visible = visible;
  }

  public void setUpdateDate(Date updateDate) {
    this.updateDate = updateDate;
  }

  public void setSelfUpdateDate(Date selfUpdatedate) {
    this.selfUpdatedate = selfUpdatedate;
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
    return availableForsale;
  }

  public boolean isVisible() {
    return visible;
  }

  public Date getUpdateDate() {
    return updateDate;
  }

  public Date getSelfUpdateDate() {
    return selfUpdatedate;
  }
}
