package com.piyush.task.model.response;

import com.piyush.task.model.Task;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class TaskGetResponse {
  private Task task;
  private String message;

  public static String getSuccessMsg() {
    return "Task is fetched successfully";
  }

  public static String getErrorMsg() {
    return "Task is not fetched successfully";
  }
}

