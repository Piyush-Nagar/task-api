package com.piyush.task.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class TaskDeleteResponse {
  private String id;
  private String message;

  public static String getSuccessMsg() {
    return "Task is deleted successfully";
  }

  public static String getErrorMsg() {
    return "Task is no such task found";
  }
}
