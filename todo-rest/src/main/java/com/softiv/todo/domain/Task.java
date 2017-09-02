package com.softiv.todo.domain;

import com.softiv.todo.enums.TaskPriority;
import com.softiv.todo.enums.TaskStatus;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Set;

@Entity
@Table
@Data
public class Task {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    @Size(min = 5, max = 150)
    private String description;

    @Column
    private TaskStatus status;

    @Column(name = "created_at", updatable = false, insertable = false)
    public Date createdAt;

    @Column(name = "updated_at", updatable = false, insertable = false)
    public Date updatedAt;

    @Version
    public int version;

    @Column
    private TaskPriority priority;

//    @Column
//    private Set<Task> subtasks;

}
