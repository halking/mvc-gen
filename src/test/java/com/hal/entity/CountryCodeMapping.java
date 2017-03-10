package com.hal.entity;

import java.lang.String;

public class CountryCodeMapping {
  private long id;

  private String brand;

  private String websiteCountry;

  private String pricingCode;

  private String taxingCode;

  private String catalogCountry;

  private String nsiCountry;

  private String timezone;

  private boolean isSapmanaged;

  private boolean toBecws;

  private boolean taxIncluded;

  private String refTaxbrand;

  private boolean localSavingmgt;

  private boolean channelScopeextended;

  public void setId(long id) {
    this.id = id;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public void setWebsiteCountry(String websiteCountry) {
    this.websiteCountry = websiteCountry;
  }

  public void setPricingCode(String pricingCode) {
    this.pricingCode = pricingCode;
  }

  public void setTaxingCode(String taxingCode) {
    this.taxingCode = taxingCode;
  }

  public void setCatalogCountry(String catalogCountry) {
    this.catalogCountry = catalogCountry;
  }

  public void setNsiCountry(String nsiCountry) {
    this.nsiCountry = nsiCountry;
  }

  public void setTimezone(String timezone) {
    this.timezone = timezone;
  }

  public void setIsSapManaged(boolean isSapmanaged) {
    this.isSapmanaged = isSapmanaged;
  }

  public void setToBecws(boolean toBecws) {
    this.toBecws = toBecws;
  }

  public void setTaxIncluded(boolean taxIncluded) {
    this.taxIncluded = taxIncluded;
  }

  public void setRefTaxBrand(String refTaxbrand) {
    this.refTaxbrand = refTaxbrand;
  }

  public void setLocalSavingMgt(boolean localSavingmgt) {
    this.localSavingmgt = localSavingmgt;
  }

  public void setChannelScopeExtended(boolean channelScopeextended) {
    this.channelScopeextended = channelScopeextended;
  }

  public long getId() {
    return id;
  }

  public String getBrand() {
    return brand;
  }

  public String getWebsiteCountry() {
    return websiteCountry;
  }

  public String getPricingCode() {
    return pricingCode;
  }

  public String getTaxingCode() {
    return taxingCode;
  }

  public String getCatalogCountry() {
    return catalogCountry;
  }

  public String getNsiCountry() {
    return nsiCountry;
  }

  public String getTimezone() {
    return timezone;
  }

  public boolean isIsSapManaged() {
    return isSapmanaged;
  }

  public boolean isToBecws() {
    return toBecws;
  }

  public boolean isTaxIncluded() {
    return taxIncluded;
  }

  public String getRefTaxBrand() {
    return refTaxbrand;
  }

  public boolean isLocalSavingMgt() {
    return localSavingmgt;
  }

  public boolean isChannelScopeExtended() {
    return channelScopeextended;
  }
}
