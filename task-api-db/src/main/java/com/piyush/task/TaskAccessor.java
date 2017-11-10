package com.piyush.task;

import com.datastax.driver.mapping.Result;
import com.datastax.driver.mapping.annotations.Accessor;
import com.datastax.driver.mapping.annotations.Query;

@Accessor
public interface TaskAccessor {
  @Query("select * from task.task limit ?")
   Result<Task> getAll(int fetchSize);
}
