package com.softiv.todo.domain;

import com.softiv.todo.enums.TaskPriority;
import com.softiv.todo.enums.TaskStatus;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Set;

@Entity
@Data
public class Task extends Auditable<String>{
    @Id
    @GeneratedValue
    private Long id;

    @Column
    @Size(min = 5, max = 150)
    private String description;

    @Column
    private TaskStatus status;

    @Version
    public int version;

    @Column
    private TaskPriority priority;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Task> subtasks;

}
