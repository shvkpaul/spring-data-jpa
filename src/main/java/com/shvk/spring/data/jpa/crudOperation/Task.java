package com.shvk.spring.data.jpa.crudOperation;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.shvk.spring.data.jpa.crudOperation.TaskStatus.CREATED;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private TaskStatus status = CREATED;

    private TaskDto toDto() {
        return new TaskDto(String.valueOf(id), title, description, status.name());
    }
}
