package com.hal.entity;

import java.lang.String;

public class LocalModelOverwrite {
  private long id;

  private String country;

  private String brand;

  private String modelNumberlocal;

  private boolean visible;

  private boolean availableForsale;

  public void setId(long id) {
    this.id = id;
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

  public void setVisible(boolean visible) {
    this.visible = visible;
  }

  public void setAvailableForSale(boolean availableForsale) {
    this.availableForsale = availableForsale;
  }

  public long getId() {
    return id;
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

  public boolean isVisible() {
    return visible;
  }

  public boolean isAvailableForSale() {
    return availableForsale;
  }
}
