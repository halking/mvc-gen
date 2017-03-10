package com.hal.entity;

import java.lang.String;

public class LocalModelLabel {
  private long id;

  private long localModelid;

  private String language;

  private String modelLabel;

  public void setId(long id) {
    this.id = id;
  }

  public void setLocalModelId(long localModelid) {
    this.localModelid = localModelid;
  }

  public void setLanguage(String language) {
    this.language = language;
  }

  public void setModelLabel(String modelLabel) {
    this.modelLabel = modelLabel;
  }

  public long getId() {
    return id;
  }

  public long getLocalModelId() {
    return localModelid;
  }

  public String getLanguage() {
    return language;
  }

  public String getModelLabel() {
    return modelLabel;
  }
}
