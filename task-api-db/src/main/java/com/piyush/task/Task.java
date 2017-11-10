package com.piyush.task;

import com.datastax.driver.mapping.annotations.Column;
import com.datastax.driver.mapping.annotations.PartitionKey;
import com.datastax.driver.mapping.annotations.Table;
import java.time.Instant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(keyspace = "task", name = "task")
public class Task {

  @PartitionKey
  private String id;

  @Column
  private String name;

  @Column
  private String description;

  @Column(name = "created_on")
  private Instant createdOn;

  @Column
  private Status status;
}
