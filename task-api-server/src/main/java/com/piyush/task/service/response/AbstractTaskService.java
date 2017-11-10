package com.piyush.task.service.response;

import com.piyush.task.TaskDao;
import com.piyush.task.enums.TaskOperation;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class AbstractTaskService {

  TaskDao taskDao;

  public abstract TaskOperation operation();
}
