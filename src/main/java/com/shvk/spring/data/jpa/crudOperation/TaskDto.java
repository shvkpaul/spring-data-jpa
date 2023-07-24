package com.shvk.spring.data.jpa.crudOperation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TaskDto {
    private String id;
    private String title;
    private String description;
    private String status;
}
