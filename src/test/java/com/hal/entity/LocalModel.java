package com.hal.entity;

import java.lang.String;
import java.util.Date;

public class LocalModel {
  private long id;

  private long modelId;

  private String country;

  private String brand;

  private String modelNumberlocal;

  private boolean individual;

  private boolean multipleSize;

  private boolean visible;

  private boolean availableForsale;

  private Date legacyDate;

  private String imageUrl;

  private Date updateDate;

  private boolean visibleLastvalue;

  private boolean sellableLastvalue;

  private String modelNumber;

  public void setId(long id) {
    this.id = id;
  }

  public void setModelId(long modelId) {
    this.modelId = modelId;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public void setModelNumberLocal(String modelNumberlocal) {
    this.modelNumberlocal = modelNumberlocal;
  }

  public void setIndividual(boolean individual) {
    this.individual = individual;
  }

  public void setMultipleSize(boolean multipleSize) {
    this.multipleSize = multipleSize;
  }

  public void setVisible(boolean visible) {
    this.visible = visible;
  }

  public void setAvailableForSale(boolean availableForsale) {
    this.availableForsale = availableForsale;
  }

  public void setLegacyDate(Date legacyDate) {
    this.legacyDate = legacyDate;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }

  public void setUpdateDate(Date updateDate) {
    this.updateDate = updateDate;
  }

  public void setVisibleLastValue(boolean visibleLastvalue) {
    this.visibleLastvalue = visibleLastvalue;
  }

  public void setSellableLastValue(boolean sellableLastvalue) {
    this.sellableLastvalue = sellableLastvalue;
  }

  public void setModelNumber(String modelNumber) {
    this.modelNumber = modelNumber;
  }

  public long getId() {
    return id;
  }

  public long getModelId() {
    return modelId;
  }

  public String getCountry() {
    return country;
  }

  public String getBrand() {
    return brand;
  }

  public String getModelNumberLocal() {
    return modelNumberlocal;
  }

  public boolean isIndividual() {
    return individual;
  }

  public boolean isMultipleSize() {
    return multipleSize;
  }

  public boolean isVisible() {
    return visible;
  }

  public boolean isAvailableForSale() {
    return availableForsale;
  }

  public Date getLegacyDate() {
    return legacyDate;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public Date getUpdateDate() {
    return updateDate;
  }

  public boolean isVisibleLastValue() {
    return visibleLastvalue;
  }

  public boolean isSellableLastValue() {
    return sellableLastvalue;
  }

  public String getModelNumber() {
    return modelNumber;
  }
}
