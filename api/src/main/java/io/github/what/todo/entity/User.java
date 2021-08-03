package io.github.what.todo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "TDTD_USERS")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private Long id;

    @Column(unique = true, name = "USER_USERNAME")
    private String username;

    @Column(name = "USER_NAME")
    private String name;

    @Column(name = "USER_SURNAME")
    private String surname;

    @Column(unique = true, name = "USER_EMAIL")
    private String email;

    @Column(name = "USER_DOB")
    private Date dateOfBirth;

    @Column(name = "USER_PASSWORD")
    private String password;

    @OneToMany(mappedBy = "task", cascade = CascadeType.ALL)
    private List<Todo> todoCollection;

    public User(String username, String name, String surname, String email, Date dateOfBirth) {
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
    }

    public User(Long id, String username, String name, String surname, String email, Date dateOfBirth) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
    }
}
