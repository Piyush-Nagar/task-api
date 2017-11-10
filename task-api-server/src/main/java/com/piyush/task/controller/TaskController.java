package com.piyush.task.controller;

import com.piyush.task.enums.TaskOperation;
import com.piyush.task.model.Task;
import com.piyush.task.model.response.*;
import com.piyush.task.service.TaskResolver;
import com.piyush.task.service.response.TaskCreateService;
import com.piyush.task.service.response.TaskDeleteService;
import com.piyush.task.service.response.TaskGetService;
import com.piyush.task.service.response.TaskUpdateService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@AllArgsConstructor
public class TaskController {

  private final TaskResolver taskResolver;

  /**
   * URI used to create the task.
   *
   * @return {@link TaskCreateResponse}.
   */
  @PutMapping(value = "/task")
  public ResponseEntity<TaskCreateResponse> createTask(@RequestBody Task task) {
    TaskCreateService taskService = (TaskCreateService) taskResolver.resolve(TaskOperation.CREATE);
    TaskCreateResponse createTaskResponse = taskService.createTask(task);
    return ResponseEntity.ok(createTaskResponse);
  }

  /**
   * delete the task with given id.
   *
   * @param id task id
   * @return {@link TaskCreateResponse}
   */
  @DeleteMapping(value = "/task/{id}")
  public ResponseEntity<TaskDeleteResponse> deleteTask(@PathVariable("id") String id) {
    TaskDeleteService taskService = (TaskDeleteService) taskResolver.resolve(TaskOperation.DELETE);
    TaskDeleteResponse taskDeleteResponse = taskService.deleteTask(id);
    return ResponseEntity.ok(taskDeleteResponse);
  }

  /**
   * get the task for id.
   *
   * @param id task id
   * @return {@link TaskGetResponse}.
   */
  @GetMapping(value = "/task/{id}")
  public ResponseEntity<TaskGetResponse> getTask(@PathVariable("id") String id) {
    TaskGetService taskService = (TaskGetService) taskResolver.resolve(TaskOperation.GET);
    TaskGetResponse createTaskResponse = taskService.getById(id);
    return ResponseEntity.ok(createTaskResponse);
  }

  /**
   * get all task.
   * this is only the url call no need to pass any data.
   *
   * @return {@link TaskGetAllResponse}
   */
  @GetMapping(value = "/tasks")
  public ResponseEntity<TaskGetAllResponse> getTaskWithFetchSize(
      @RequestParam("fetch-size") int fetchSize) {
    TaskGetService taskService = (TaskGetService) taskResolver.resolve(TaskOperation.GET);
    TaskGetAllResponse taskGetAllResponse = taskService.getAll(fetchSize);
    return ResponseEntity.ok(taskGetAllResponse);
  }


  /**
   * update the task with given id.
   *
   * @param task task task.
   * @return {@link TaskUpdateService}
   */
  @PostMapping(value = "/task")
  public ResponseEntity<TaskUpdateResponse> updateTask(@RequestBody Task task) {
    TaskUpdateService taskService = (TaskUpdateService) taskResolver.resolve(TaskOperation.UPDATE);
    TaskUpdateResponse createTaskResponse = taskService.updateTask(task);
    return ResponseEntity.ok(createTaskResponse);
  }
}
