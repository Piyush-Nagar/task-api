package com.piyush.task.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TaskCreateResponse {

  private String id;
  private String message;

  public static String getSuccessMsg() {
    return "Task is created successfully";
  }

  public static String getErrorMsg() {
    return "There is error in creating task.";
  }
}
