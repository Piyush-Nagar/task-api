package com.piyush.task.model.response;

import com.piyush.task.model.Task;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class TaskGetAllResponse {
  private List<Task> tasks;
  private String message;

  public static String getSuccessMsg() {
    return "All Task is fetched successfully";
  }

  public static String getErrorMsg() {
    return "Task is not fetched successfully";
  }
}
