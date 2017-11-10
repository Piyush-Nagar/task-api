package com.piyush.task.service.response;

import com.piyush.task.TaskDao;
import com.piyush.task.enums.TaskOperation;
import com.piyush.task.model.Task;
import com.piyush.task.model.response.TaskDeleteResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class TaskDeleteService extends AbstractTaskService {
  private final TaskDao taskDao;

  public TaskOperation operation() {
    return TaskOperation.DELETE;
  }

  public TaskDeleteResponse deleteTask(String id) {
    taskDao.delete(id);
    return new TaskDeleteResponse(id, TaskDeleteResponse.getSuccessMsg());
  }

  private com.piyush.task.Task changeToDb(Task task) {
    return com.piyush.task.Task.builder()
        .id(task.getId())
        .name(task.getName())
        .createdOn(task.getCreatedOn())
        .description(task.getDescription())
        .status(task.getStatus())
        .build();
  }
}
