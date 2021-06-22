package com.etfbl.dimitric.model.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Data
@Entity
public class User {
    @Id@Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Basic@Column(name = "first_name", nullable = true, length = 50)
    private String firstName;
    @Basic@Column(name = "last_name", nullable = true, length = 50)
    private String lastName;
    @Basic@Column(name = "username", nullable = false, length = 50)
    private String username;
    @Basic@Column(name = "email", nullable = false, length = 50)
    private String email;
    @Basic@Column(name = "password", nullable = false, length = 256)
    private String password;
    @Basic@Column(name = "active", nullable = false, insertable = false)
    private Byte active;

}
