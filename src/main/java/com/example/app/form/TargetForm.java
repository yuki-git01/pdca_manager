package com.example.app.form;

import org.hibernate.validator.constraints.Range;

import jakarta.validation.constraints.NotBlank;

public class TargetForm {
  @NotBlank(message = "Title must not be blank.")
  private String title;
  private String description;
  @Range(min = 0, max = 5, message = "progressId must be in the range 0-5.")
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
