package com.hal.entity;

import java.lang.String;
import java.util.Date;

public class LocalReference {
  private long id;

  private long referenceId;

  private String country;

  private String brand;

  private String referenceLocal;

  private boolean availableForSale;

  private boolean visible;

  private boolean modelStock;

  private long taxId;

  private Date updateDate;

  private Date modelStockupdateDate;

  private Date selfUpdateDate;

  private boolean visibleLastValue;

  private boolean sellableLastValue;

  private String visibleSellableProperty;

  private String reference;

  private long localModelId;

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

  public void setAvailableForSale(boolean availableForSale) {
    this.availableForSale = availableForSale;
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

  public void setModelStockupdateDate(Date modelStockupdateDate) {
    this.modelStockupdateDate = modelStockupdateDate;
  }

  public void setSelfUpdateDate(Date selfUpdateDate) {
    this.selfUpdateDate = selfUpdateDate;
  }

  public void setVisibleLastValue(boolean visibleLastValue) {
    this.visibleLastValue = visibleLastValue;
  }

  public void setSellableLastValue(boolean sellableLastValue) {
    this.sellableLastValue = sellableLastValue;
  }

  public void setVisibleSellableProperty(String visibleSellableProperty) {
    this.visibleSellableProperty = visibleSellableProperty;
  }

  public void setReference(String reference) {
    this.reference = reference;
  }

  public void setLocalModelId(long localModelId) {
    this.localModelId = localModelId;
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
    return availableForSale;
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
    return modelStockupdateDate;
  }

  public Date getSelfUpdateDate() {
    return selfUpdateDate;
  }

  public boolean isVisibleLastValue() {
    return visibleLastValue;
  }

  public boolean isSellableLastValue() {
    return sellableLastValue;
  }

  public String getVisibleSellableProperty() {
    return visibleSellableProperty;
  }

  public String getReference() {
    return reference;
  }

  public long getLocalModelId() {
    return localModelId;
  }
}
