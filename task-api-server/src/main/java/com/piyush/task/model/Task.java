package com.piyush.task.model;

import com.piyush.task.Status;
import java.time.Instant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Task {

  private String name;
  private String description;
  private String id;
  private Instant createdOn;
  private Status status;

  public static com.piyush.task.Task changeToDb(Task task) {
    return com.piyush.task.Task.builder()
        .id(task.getId())
        .name(task.getName())
        .createdOn(task.getCreatedOn())
        .description(task.getDescription())
        .status(task.getStatus())
        .build();
  }

  public static Task changeToResponse(com.piyush.task.Task task) {
    return Task.builder()
        .id(task.getId())
        .name(task.getName())
        .createdOn(task.getCreatedOn())
        .description(task.getDescription())
        .status(task.getStatus())
        .build();
  }


}
