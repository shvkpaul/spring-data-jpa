package com.shvk.spring.data.jpa.crudOperation;

import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<Task, Long> {
}
