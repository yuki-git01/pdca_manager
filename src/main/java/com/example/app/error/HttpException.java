package com.example.app.error;

import org.springframework.http.HttpStatus;

/**
 * HttpStatusを持ったclass<br>
 * NotFound,BadRequestに継承させる事でHandleする時にHttpStatusが使える
 */
public class HttpException extends RuntimeException {
  private HttpStatus httpStatus;

  public HttpException() {
  }

  public HttpException(String message, HttpStatus httpStatus) {
    super(message);
    this.httpStatus = httpStatus;
  }

  public HttpException(Throwable cause, HttpStatus httpStatus) {
    super(cause);
    this.httpStatus = httpStatus;
  }

  public HttpException(String message, Throwable cause, HttpStatus httpStatus) {
    super(message, cause);
    this.httpStatus = httpStatus;
  }

  public HttpException(String message, Throwable cause,
      boolean enableSuppression,
      boolean writableStackTrace, HttpStatus httpStatus) {
    super(message, cause, enableSuppression, writableStackTrace);
    this.httpStatus = httpStatus;
  }

  public HttpStatus getHttpStatus() {
    return httpStatus;
  }
}
