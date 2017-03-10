package com.hal.entity;

import java.lang.String;

public class Tax {
  private long id;

  private String legacyTaxid;

  private String brand;

  private String country;

  private String orderTaxcode;

  public void setId(long id) {
    this.id = id;
  }

  public void setLegacyTaxId(String legacyTaxid) {
    this.legacyTaxid = legacyTaxid;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public void setOrderTaxCode(String orderTaxcode) {
    this.orderTaxcode = orderTaxcode;
  }

  public long getId() {
    return id;
  }

  public String getLegacyTaxId() {
    return legacyTaxid;
  }

  public String getBrand() {
    return brand;
  }

  public String getCountry() {
    return country;
  }

  public String getOrderTaxCode() {
    return orderTaxcode;
  }
}
