package com.hal.entity;

import java.lang.String;

public class LocalReferenceLabel {
  private long id;

  private long localReferenceId;

  private String language;

  private String referenceLabel;

  public void setId(long id) {
    this.id = id;
  }

  public void setLocalReferenceId(long localReferenceId) {
    this.localReferenceId = localReferenceId;
  }

  public void setLanguage(String language) {
    this.language = language;
  }

  public void setReferenceLabel(String referenceLabel) {
    this.referenceLabel = referenceLabel;
  }

  public long getId() {
    return id;
  }

  public long getLocalReferenceId() {
    return localReferenceId;
  }

  public String getLanguage() {
    return language;
  }

  public String getReferenceLabel() {
    return referenceLabel;
  }
}
