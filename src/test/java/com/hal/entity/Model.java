package com.hal.entity;

import java.lang.String;
import java.util.Date;

public class Model {
  private long id;

  private String brand;

  private String modelNumber;

  private String description;

  private boolean individual;

  private boolean multipleSize;

  private boolean visible;

  private boolean availableForsale;

  private Date legacyDate;

  private Date updateDate;

  private long masterModelid;

  private String size;

  private Date selfUpdatedate;

  public void setId(long id) {
    this.id = id;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public void setModelNumber(String modelNumber) {
    this.modelNumber = modelNumber;
  }

  public void setDescription(String description) {
    this.description = description;
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

  public void setUpdateDate(Date updateDate) {
    this.updateDate = updateDate;
  }

  public void setMasterModelId(long masterModelid) {
    this.masterModelid = masterModelid;
  }

  public void setSize(String size) {
    this.size = size;
  }

  public void setSelfUpdateDate(Date selfUpdatedate) {
    this.selfUpdatedate = selfUpdatedate;
  }

  public long getId() {
    return id;
  }

  public String getBrand() {
    return brand;
  }

  public String getModelNumber() {
    return modelNumber;
  }

  public String getDescription() {
    return description;
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

  public Date getUpdateDate() {
    return updateDate;
  }

  public long getMasterModelId() {
    return masterModelid;
  }

  public String getSize() {
    return size;
  }

  public Date getSelfUpdateDate() {
    return selfUpdatedate;
  }
}
