package com.piyush.task.service.response;

import com.piyush.task.TaskDao;
import com.piyush.task.enums.TaskOperation;
import com.piyush.task.model.Task;
import com.piyush.task.model.response.TaskUpdateResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@AllArgsConstructor
@Service
public class TaskUpdateService extends AbstractTaskService {

  private final TaskDao taskDao;

  @Override
  public TaskOperation operation() {
    return TaskOperation.UPDATE;
  }

  public TaskUpdateResponse updateTask(Task task) {
    taskDao.insert(Task.changeToDb(task));
    return new TaskUpdateResponse(task.getId(), TaskUpdateResponse.getSuccessMsg());
  }
}
