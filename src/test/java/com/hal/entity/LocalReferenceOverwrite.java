package com.hal.entity;

import java.lang.String;

public class LocalReferenceOverwrite {
  private long id;

  private String brand;

  private String country;

  private String referenceLocal;

  private boolean visible;

  private boolean availableForSale;

  private String visibleSellableProperty;

  public void setId(long id) {
    this.id = id;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public void setReferenceLocal(String referenceLocal) {
    this.referenceLocal = referenceLocal;
  }

  public void setVisible(boolean visible) {
    this.visible = visible;
  }

  public void setAvailableForSale(boolean availableForSale) {
    this.availableForSale = availableForSale;
  }

  public void setVisibleSellableProperty(String visibleSellableProperty) {
    this.visibleSellableProperty = visibleSellableProperty;
  }

  public long getId() {
    return id;
  }

  public String getBrand() {
    return brand;
  }

  public String getCountry() {
    return country;
  }

  public String getReferenceLocal() {
    return referenceLocal;
  }

  public boolean isVisible() {
    return visible;
  }

  public boolean isAvailableForSale() {
    return availableForSale;
  }

  public String getVisibleSellableProperty() {
    return visibleSellableProperty;
  }
}
