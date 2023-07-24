package com.shvk.spring.data.jpa.crudOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class TaskController {
    private final TaskRepository repository;

    @Autowired
    public TaskController(TaskRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/tasks")
    public ResponseEntity<Task> createTask(@RequestBody TaskDto requestDto) {
        String title = requestDto.getTitle();
        String description = requestDto.getDescription();

        Task newTask = new Task();
        newTask.setTitle(title);
        newTask.setDescription(description);

        Task createdTask = repository.save(newTask);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTask);
    }

    @GetMapping("/tasks/{id}")
    public ResponseEntity<?> getTask(@PathVariable("id") Long id) {
        Task task = repository.findById(id).orElse(null);
        if (task == null) {
            return (ResponseEntity<?>) ResponseEntity.status(HttpStatus.NO_CONTENT);
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(task);
        }
    }

    @GetMapping("/tasks")
    public Iterable<Task> getAllTasks() {
        return repository.findAll();
    }

    @PutMapping("/tasks/{id}")
    public ResponseEntity<?> updateTask(@PathVariable("id") Long id,
                                        @RequestBody TaskDto requestDto) {

        List<String> validStatusNames = Arrays.asList(TaskStatus.CREATED.name(), TaskStatus.APPROVED.name(), TaskStatus.REJECTED.name(), TaskStatus.BLOCKED.name(), TaskStatus.DONE.name());

        String requestStatus = requestDto.getStatus();

        boolean isValidStatus = validStatusNames.contains(requestStatus);

        if (!isValidStatus) {
            return (ResponseEntity<?>) ResponseEntity.status(HttpStatus.BAD_REQUEST);
        }
        Task task = repository.findById(id).orElse(null);
        if (task == null) {
            return (ResponseEntity<?>) ResponseEntity.status(HttpStatus.NO_CONTENT);
        } else {
            task.setStatus(TaskStatus.valueOf(requestStatus));
            task.setDescription(requestDto.getDescription());
            task.setTitle(requestDto.getTitle());
            repository.save(task);
            return ResponseEntity.status(HttpStatus.OK).body(task);
        }
    }

    @DeleteMapping("/tasks/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable Long id) {
        Task task = repository.findById(id).orElse(null);
        if (task == null) {
            return (ResponseEntity<?>) ResponseEntity.status(HttpStatus.NO_CONTENT);
        } else {
            repository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body(task);
        }
    }
}
