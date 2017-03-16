package com.hal.entity;

import java.lang.Integer;
import java.lang.String;
import java.util.Date;

public class SchemaVersion {
  private Integer versionRank;

  private Integer installedRank;

  private String version;

  private String description;

  private String type;

  private String script;

  private Integer checksum;

  private String installedBy;

  private Date installedOn;

  private Integer executionTime;

  private boolean success;

  public void setVersionRank(Integer versionRank) {
    this.versionRank = versionRank;
  }

  public void setInstalledRank(Integer installedRank) {
    this.installedRank = installedRank;
  }

  public void setVersion(String version) {
    this.version = version;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setType(String type) {
    this.type = type;
  }

  public void setScript(String script) {
    this.script = script;
  }

  public void setChecksum(Integer checksum) {
    this.checksum = checksum;
  }

  public void setInstalledBy(String installedBy) {
    this.installedBy = installedBy;
  }

  public void setInstalledOn(Date installedOn) {
    this.installedOn = installedOn;
  }

  public void setExecutionTime(Integer executionTime) {
    this.executionTime = executionTime;
  }

  public void setSuccess(boolean success) {
    this.success = success;
  }

  public Integer getVersionRank() {
    return versionRank;
  }

  public Integer getInstalledRank() {
    return installedRank;
  }

  public String getVersion() {
    return version;
  }

  public String getDescription() {
    return description;
  }

  public String getType() {
    return type;
  }

  public String getScript() {
    return script;
  }

  public Integer getChecksum() {
    return checksum;
  }

  public String getInstalledBy() {
    return installedBy;
  }

  public Date getInstalledOn() {
    return installedOn;
  }

  public Integer getExecutionTime() {
    return executionTime;
  }

  public boolean isSuccess() {
    return success;
  }
}
