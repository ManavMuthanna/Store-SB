package com.codewithmanav.store.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users") // Optional, but avoids naming conflicts
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;

    // No-arg constructor (required by JPA)
    public User() {
    }

    // // Optional constructor
    // public User(String name, String email) {
    //     this.name = name;
    //     this.email = email;
    // }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
