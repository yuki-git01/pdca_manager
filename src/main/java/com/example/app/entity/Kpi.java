package com.example.app.entity;

import java.time.LocalDateTime;

/**
 * Processの子クラス
 * 1 <---> many
 * Process Kpi
 */
public class Kpi {
  private int id;
  private String description;
  private Progress progress;
  private LocalDateTime due_date;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public LocalDateTime getDue_date() {
    return due_date;
  }

  public void setDue_date(LocalDateTime due_date) {
    this.due_date = due_date;
  }

  public Progress getProgress() {
    return progress;
  }

  public void setProgress(Progress progress) {
    this.progress = progress;
  }
}
