package com.hal.entity;

import java.lang.String;

public class Tax {
  private long id;

  private String legacyTaxId;

  private String brand;

  private String country;

  private String orderTaxCode;

  public void setId(long id) {
    this.id = id;
  }

  public void setLegacyTaxId(String legacyTaxId) {
    this.legacyTaxId = legacyTaxId;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public void setOrderTaxCode(String orderTaxCode) {
    this.orderTaxCode = orderTaxCode;
  }

  public long getId() {
    return id;
  }

  public String getLegacyTaxId() {
    return legacyTaxId;
  }

  public String getBrand() {
    return brand;
  }

  public String getCountry() {
    return country;
  }

  public String getOrderTaxCode() {
    return orderTaxCode;
  }
}
