package io.github.what.todo.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Data
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
}
