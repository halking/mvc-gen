package com.hal.entity;

import java.lang.String;

public class LocalModelOverwrite {
  private long id;

  private String country;

  private String brand;

  private String modelNumberLocal;

  private boolean visible;

  private boolean availableForSale;

  public void setId(long id) {
    this.id = id;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public void setModelNumberLocal(String modelNumberLocal) {
    this.modelNumberLocal = modelNumberLocal;
  }

  public void setVisible(boolean visible) {
    this.visible = visible;
  }

  public void setAvailableForSale(boolean availableForSale) {
    this.availableForSale = availableForSale;
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
    return modelNumberLocal;
  }

  public boolean isVisible() {
    return visible;
  }

  public boolean isAvailableForSale() {
    return availableForSale;
  }
}
