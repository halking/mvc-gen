package com.hal.entity;

import java.lang.String;

public class LocalModelLabel {
  private long id;

  private long localModelId;

  private String language;

  private String modelLabel;

  public void setId(long id) {
    this.id = id;
  }

  public void setLocalModelId(long localModelId) {
    this.localModelId = localModelId;
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
    return localModelId;
  }

  public String getLanguage() {
    return language;
  }

  public String getModelLabel() {
    return modelLabel;
  }
}
