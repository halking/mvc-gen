package com.hal.entity;

import java.lang.String;
import java.util.Date;

public class Export {
  private long id;

  private String brand;

  private String exportType;

  private Date lastExport;

  private boolean active;

  public void setId(long id) {
    this.id = id;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public void setExportType(String exportType) {
    this.exportType = exportType;
  }

  public void setLastExport(Date lastExport) {
    this.lastExport = lastExport;
  }

  public void setActive(boolean active) {
    this.active = active;
  }

  public long getId() {
    return id;
  }

  public String getBrand() {
    return brand;
  }

  public String getExportType() {
    return exportType;
  }

  public Date getLastExport() {
    return lastExport;
  }

  public boolean isActive() {
    return active;
  }
}
