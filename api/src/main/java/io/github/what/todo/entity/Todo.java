package io.github.what.todo.entity;

import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "TDTD_TODO")
@NamedQueries({
        @NamedQuery(name = "get_all_todo_tasks", query = "SELECT t FROM Todo t")
})
@Cacheable
@SQLDelete(sql = "UPDATE todo SET todo_is_deleted = true WHERE todo_id = ?")
@Where(clause = "todo_is_deleted = false")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TODO_ID")
    private Long id;

    @ManyToOne()
    private User user;

    @Column(name = "TODO_TASK", nullable = false)
    private String task;

    @UpdateTimestamp
    @Column(name = "TODO_LAST_UPDATED", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP()")
    private LocalDateTime lastUpdatedDate;

    @Column(name = "TODO_IS_COMPLETED", columnDefinition = "BOOLEAN DEFAULT FALSE")
    private boolean isCompleted;

    @Column(name = "TODO_IS_DELETED", columnDefinition = "BOOLEAN DEFAULT FALSE")
    private boolean isDeleted;

}
