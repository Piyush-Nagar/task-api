package com.piyush.task;

import com.datastax.driver.mapping.Mapper;
import java.util.Optional;
import java.util.stream.Stream;
import org.springframework.stereotype.Repository;

@Repository
public class TaskDao {

  private Mapper<Task> mapper;
  private TaskAccessor taskAccessor;

  public TaskDao(CassandraService service) {
    this.mapper = service.mapper(Task.class);
    this.taskAccessor = service.accessor(TaskAccessor.class);
  }

  public void insert(Task task) {
    mapper.save(task);
  }

  public void delete(String id) {
    mapper.delete(id);
  }

  public Stream<Task> getAll() {
    return Stream.empty();
  }

  public Stream<Task> getAll(int fetchSize) {
    return taskAccessor.getAll(fetchSize).all().stream();
  }

  public Optional<Task> getById(String id) {
    return Optional.ofNullable(mapper.get(id));
  }

}
