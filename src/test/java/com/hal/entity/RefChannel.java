package com.hal.entity;

import java.lang.String;

public class RefChannel {
  private long id;

  private String code;

  private String legacyId;

  private String legacyLabel;

  private String description;

  private boolean active;

  public void setId(long id) {
    this.id = id;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public void setLegacyId(String legacyId) {
    this.legacyId = legacyId;
  }

  public void setLegacyLabel(String legacyLabel) {
    this.legacyLabel = legacyLabel;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setActive(boolean active) {
    this.active = active;
  }

  public long getId() {
    return id;
  }

  public String getCode() {
    return code;
  }

  public String getLegacyId() {
    return legacyId;
  }

  public String getLegacyLabel() {
    return legacyLabel;
  }

  public String getDescription() {
    return description;
  }

  public boolean isActive() {
    return active;
  }
}
