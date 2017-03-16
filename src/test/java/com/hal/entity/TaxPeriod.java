package com.hal.entity;

import java.lang.String;
import java.math.BigDecimal;
import java.util.Date;

public class TaxPeriod {
  private long id;

  private long taxId;

  private BigDecimal rate;

  private Date fromDate;

  private String taxingCode;

  public void setId(long id) {
    this.id = id;
  }

  public void setTaxId(long taxId) {
    this.taxId = taxId;
  }

  public void setRate(BigDecimal rate) {
    this.rate = rate;
  }

  public void setFromDate(Date fromDate) {
    this.fromDate = fromDate;
  }

  public void setTaxingCode(String taxingCode) {
    this.taxingCode = taxingCode;
  }

  public long getId() {
    return id;
  }

  public long getTaxId() {
    return taxId;
  }

  public BigDecimal getRate() {
    return rate;
  }

  public Date getFromDate() {
    return fromDate;
  }

  public String getTaxingCode() {
    return taxingCode;
  }
}
