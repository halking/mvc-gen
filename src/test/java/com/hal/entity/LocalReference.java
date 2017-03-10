package com.hal.entity;

import java.lang.String;
import java.util.Date;

public class LocalReference {
  private long id;

  private long referenceId;

  private String country;

  private String brand;

  private String referenceLocal;

  private boolean availableForsale;

  private boolean visible;

  private boolean modelStock;

  private long taxId;

  private Date updateDate;

  private Date modelStockupdatedate;

  private Date selfUpdatedate;

  private boolean visibleLastvalue;

  private boolean sellableLastvalue;

  private String visibleSellableproperty;

  private String reference;

  private long localModelid;

  public void setId(long id) {
    this.id = id;
  }

  public void setReferenceId(long referenceId) {
    this.referenceId = referenceId;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public void setReferenceLocal(String referenceLocal) {
    this.referenceLocal = referenceLocal;
  }

  public void setAvailableForSale(boolean availableForsale) {
    this.availableForsale = availableForsale;
  }

  public void setVisible(boolean visible) {
    this.visible = visible;
  }

  public void setModelStock(boolean modelStock) {
    this.modelStock = modelStock;
  }

  public void setTaxId(long taxId) {
    this.taxId = taxId;
  }

  public void setUpdateDate(Date updateDate) {
    this.updateDate = updateDate;
  }

  public void setModelStockupdateDate(Date modelStockupdatedate) {
    this.modelStockupdatedate = modelStockupdatedate;
  }

  public void setSelfUpdateDate(Date selfUpdatedate) {
    this.selfUpdatedate = selfUpdatedate;
  }

  public void setVisibleLastValue(boolean visibleLastvalue) {
    this.visibleLastvalue = visibleLastvalue;
  }

  public void setSellableLastValue(boolean sellableLastvalue) {
    this.sellableLastvalue = sellableLastvalue;
  }

  public void setVisibleSellableProperty(String visibleSellableproperty) {
    this.visibleSellableproperty = visibleSellableproperty;
  }

  public void setReference(String reference) {
    this.reference = reference;
  }

  public void setLocalModelId(long localModelid) {
    this.localModelid = localModelid;
  }

  public long getId() {
    return id;
  }

  public long getReferenceId() {
    return referenceId;
  }

  public String getCountry() {
    return country;
  }

  public String getBrand() {
    return brand;
  }

  public String getReferenceLocal() {
    return referenceLocal;
  }

  public boolean isAvailableForSale() {
    return availableForsale;
  }

  public boolean isVisible() {
    return visible;
  }

  public boolean isModelStock() {
    return modelStock;
  }

  public long getTaxId() {
    return taxId;
  }

  public Date getUpdateDate() {
    return updateDate;
  }

  public Date getModelStockupdateDate() {
    return modelStockupdatedate;
  }

  public Date getSelfUpdateDate() {
    return selfUpdatedate;
  }

  public boolean isVisibleLastValue() {
    return visibleLastvalue;
  }

  public boolean isSellableLastValue() {
    return sellableLastvalue;
  }

  public String getVisibleSellableProperty() {
    return visibleSellableproperty;
  }

  public String getReference() {
    return reference;
  }

  public long getLocalModelId() {
    return localModelid;
  }
}
