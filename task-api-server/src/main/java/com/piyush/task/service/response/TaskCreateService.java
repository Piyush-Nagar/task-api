package com.piyush.task.service.response;

import com.piyush.task.TaskDao;
import com.piyush.task.enums.TaskOperation;
import com.piyush.task.model.Task;
import com.piyush.task.model.response.TaskCreateResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class TaskCreateService extends AbstractTaskService {

  public TaskCreateService(TaskDao taskDao) {
    super(taskDao);
  }

  public TaskOperation operation() {
    return TaskOperation.CREATE;
  }

  public TaskCreateResponse createTask(Task task) {
    taskDao.insert(Task.changeToDb(task));
    return new TaskCreateResponse(task.getId(), TaskCreateResponse.getSuccessMsg());
  }
}
