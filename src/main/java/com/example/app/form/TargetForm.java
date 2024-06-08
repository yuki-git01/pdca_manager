package com.example.app.form;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class TargetForm {
  @NotBlank(message = "{0}は必須入力です")
  private String title;
  private String description;
  @Min(0)
  @Max(5)
  private Integer progressId;

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

  public Integer getProgressId() {
    return progressId;
  }

  public void setProgressId(Integer progressId) {
    this.progressId = progressId;
  }

}
