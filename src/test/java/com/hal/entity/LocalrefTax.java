package com.hal.entity;

import java.lang.String;

public class LocalrefTax {
  private long id;

  private long localReferenceid;

  private long taxId;

  private String country;

  private String brand;

  public void setId(long id) {
    this.id = id;
  }

  public void setLocalReferenceId(long localReferenceid) {
    this.localReferenceid = localReferenceid;
  }

  public void setTaxId(long taxId) {
    this.taxId = taxId;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public long getId() {
    return id;
  }

  public long getLocalReferenceId() {
    return localReferenceid;
  }

  public long getTaxId() {
    return taxId;
  }

  public String getCountry() {
    return country;
  }

  public String getBrand() {
    return brand;
  }
}
