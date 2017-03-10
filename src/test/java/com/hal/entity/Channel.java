package com.hal.entity;

import java.lang.String;

public class Channel {
  private long id;

  private String brand;

  private String reference;

  private long localReferenceid;

  private String localReference;

  private long refChannelid;

  private String code;

  private boolean visible;

  private boolean sellable;

  public void setId(long id) {
    this.id = id;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public void setReference(String reference) {
    this.reference = reference;
  }

  public void setLocalReferenceId(long localReferenceid) {
    this.localReferenceid = localReferenceid;
  }

  public void setLocalReference(String localReference) {
    this.localReference = localReference;
  }

  public void setRefChannelId(long refChannelid) {
    this.refChannelid = refChannelid;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public void setVisible(boolean visible) {
    this.visible = visible;
  }

  public void setSellable(boolean sellable) {
    this.sellable = sellable;
  }

  public long getId() {
    return id;
  }

  public String getBrand() {
    return brand;
  }

  public String getReference() {
    return reference;
  }

  public long getLocalReferenceId() {
    return localReferenceid;
  }

  public String getLocalReference() {
    return localReference;
  }

  public long getRefChannelId() {
    return refChannelid;
  }

  public String getCode() {
    return code;
  }

  public boolean isVisible() {
    return visible;
  }

  public boolean isSellable() {
    return sellable;
  }
}
