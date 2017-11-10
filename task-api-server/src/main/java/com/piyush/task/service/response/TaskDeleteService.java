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
public class TaskDeleteService extends AbstractTaskService {

  public TaskDeleteService(TaskDao taskDao) {
    super(taskDao);
  }

  public TaskOperation operation() {
    return TaskOperation.DELETE;
  }

  public TaskDeleteResponse deleteTask(String id) {
    taskDao.delete(id);
    return new TaskDeleteResponse(id, TaskDeleteResponse.getSuccessMsg());
  }
}
