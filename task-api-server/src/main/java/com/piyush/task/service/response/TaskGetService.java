package com.piyush.task.service.response;

import static com.piyush.task.model.response.TaskGetResponse.getErrorMsg;
import static com.piyush.task.model.response.TaskGetResponse.getSuccessMsg;

import com.piyush.task.TaskDao;
import com.piyush.task.enums.TaskOperation;
import com.piyush.task.model.Task;
import com.piyush.task.model.response.TaskGetAllResponse;
import com.piyush.task.model.response.TaskGetResponse;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@AllArgsConstructor
@Service
public class TaskGetService extends AbstractTaskService {

  private final TaskDao taskDao;

  @Override
  public TaskOperation operation() {
    return TaskOperation.GET;
  }

  public TaskGetResponse getById(String id) {
    return taskDao.getById(id)
        .map(task -> new TaskGetResponse(Task.changeToResponse(task), getSuccessMsg()))
        .orElse(new TaskGetResponse(new Task(), getErrorMsg()));
  }

  public TaskGetAllResponse getAll(int fetchSize) {
    List<com.piyush.task.model.Task> responseTask = taskDao.getAll(fetchSize)
        .map(com.piyush.task.model.Task::changeToResponse)
        .collect(Collectors.toList());
    return responseTask.isEmpty()
        ? new TaskGetAllResponse(Collections.emptyList(), TaskGetAllResponse.getErrorMsg())
        : new TaskGetAllResponse(responseTask, TaskGetAllResponse.getSuccessMsg());
  }
}
