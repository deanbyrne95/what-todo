package io.github.what.todo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@Table(name = "TDTD_TODO")
@NamedQueries({
        @NamedQuery(name = "get_all_todo_tasks", query = "SELECT t FROM Todo t")
})
@Cacheable
@SQLDelete(sql = "UPDATE todo SET todo_is_deleted = true WHERE todo_id = ?")
@Where(clause = "todo_is_deleted = false")
public class Todo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TODO_ID")
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID", updatable = false, nullable = false)
    private User user;

    @Column(name = "TODO_TASK", nullable = false)
    private String task;

    @UpdateTimestamp
    @Column(name = "TODO_LAST_UPDATED", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP()")
    private LocalDateTime lastUpdatedDate;

    @Column(name = "TODO_IS_COMPLETED", columnDefinition = "BOOLEAN DEFAULT FALSE")
    private boolean completed;

    @Column(name = "TODO_IS_DELETED", columnDefinition = "BOOLEAN DEFAULT FALSE")
    private boolean deleted;

    public Todo(Long id, User user, String task, LocalDateTime lastUpdatedDate, boolean completed, boolean deleted) {
        this.id = id;
        this.user = user;
        this.task = task;
        this.lastUpdatedDate = lastUpdatedDate;
        this.completed = completed;
        this.deleted = deleted;
    }

    public Todo(String task, LocalDateTime lastUpdatedDate, boolean completed, boolean deleted) {
        this.task = task;
        this.lastUpdatedDate = lastUpdatedDate;
        this.completed = completed;
        this.deleted = deleted;
    }
}
