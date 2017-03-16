package com.hal.entity;

import java.lang.String;
import java.math.BigDecimal;
import java.util.Date;

public class ReferencePrice {
  private long id;

  private long localReferenceId;

  private BigDecimal price;

  private String currency;

  private Date fromDate;

  private String pricingCode;

  private Date creationDate;

  private String serialNumber;

  public void setId(long id) {
    this.id = id;
  }

  public void setLocalReferenceId(long localReferenceId) {
    this.localReferenceId = localReferenceId;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public void setFromDate(Date fromDate) {
    this.fromDate = fromDate;
  }

  public void setPricingCode(String pricingCode) {
    this.pricingCode = pricingCode;
  }

  public void setCreationDate(Date creationDate) {
    this.creationDate = creationDate;
  }

  public void setSerialNumber(String serialNumber) {
    this.serialNumber = serialNumber;
  }

  public long getId() {
    return id;
  }

  public long getLocalReferenceId() {
    return localReferenceId;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public String getCurrency() {
    return currency;
  }

  public Date getFromDate() {
    return fromDate;
  }

  public String getPricingCode() {
    return pricingCode;
  }

  public Date getCreationDate() {
    return creationDate;
  }

  public String getSerialNumber() {
    return serialNumber;
  }
}
