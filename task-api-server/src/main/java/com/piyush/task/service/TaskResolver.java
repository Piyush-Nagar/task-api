package com.piyush.task.service;

import com.piyush.task.enums.TaskOperation;
import com.piyush.task.service.response.AbstractTaskService;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskResolver {

  private Map<TaskOperation, AbstractTaskService> taskServiceMap;

  public TaskResolver(List<AbstractTaskService> abstractTaskServices) {
    taskServiceMap = abstractTaskServices.stream()
        .collect(Collectors.toMap(AbstractTaskService::operation,
                                  service -> service, (oldVal, newVal) -> oldVal));
  }

  public AbstractTaskService resolve(TaskOperation taskOperation) {
    return taskServiceMap.get(taskOperation);
  }
}
