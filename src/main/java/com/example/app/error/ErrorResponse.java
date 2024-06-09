package com.example.app.error;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;

public class ErrorResponse {
  private List<String> messages;
  private HttpStatus status;

  public ErrorResponse(List<String> messages, HttpStatus status) {
    this.messages = messages;
    this.status = status;
  }

  /**
   * 
   * @param message stringを受け取った際に長さ１の配列を作る
   * @param status
   */
  public ErrorResponse(String message, HttpStatus status) {
    List<String> str = new ArrayList<String>();
    str.add(message);
    this.messages = str;
    this.status = status;
  }

  public List<String> getMessages() {
    return messages;
  }

  public void setMessages(List<String> messages) {
    this.messages = messages;
  }

  public HttpStatus getStatus() {
    return status;
  }

  public void setStatus(HttpStatus status) {
    this.status = status;
  }
}
