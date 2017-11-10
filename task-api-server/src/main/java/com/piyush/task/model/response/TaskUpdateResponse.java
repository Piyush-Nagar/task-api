package com.piyush.task.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class TaskUpdateResponse {

  private String id;
  private String message;

  public static String getSuccessMsg() {
    return "com.piyush.task.Task is updated succesfully";
  }

  public static String getErrorMsg() {
    return "com.piyush.task.Task is not updated succesfully";
  }

}
