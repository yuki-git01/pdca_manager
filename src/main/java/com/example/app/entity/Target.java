package com.example.app.entity;

import java.time.LocalDateTime;
import java.util.List;

public class Target {
  private int id;
  private int userId;
  private String title;
  private String description;
  private Progress progress;
  private LocalDateTime lastUpdated;
  private List<Process> processes;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Progress getProgress() {
    return progress;
  }

  public void setProgress(Progress progress) {
    this.progress = progress;
  }

  public LocalDateTime getLastUpdated() {
    return lastUpdated;
  }

  public void setLastUpdated(LocalDateTime lastUpdated) {
    this.lastUpdated = lastUpdated;
  }

  public List<Process> getProcesses() {
    return processes;
  }

  public void setProcesses(List<Process> processes) {
    this.processes = processes;
  }

}
