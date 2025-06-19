package com.marreco.crud_person.entity;

import com.marreco.crud_person.dto.UserDTO;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Table
@Entity(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name", length = 50)
    private String name;

    @Column(name = "last_name", length = 50)
    private String lastName;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public User (){
    }

    public User (Long id, String name, String lastName, String email, String password, LocalDateTime createdAt) {
        this.id = id;
        setName(name);
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.createdAt = createdAt;
    }

    public User(UserDTO dto) {
        setName(dto.name());
        setLastName(dto.lastName());
        setEmail(dto.email());
        setPassword(dto.password());
        setCreatedAt(LocalDateTime.now());
    }

    private String capitalizeString(String word) {
        return word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = capitalizeString(name);
    }

    public String getName() {
        return name;
    }

    public void setLastName (String lastName) {
        this.lastName = capitalizeString(lastName);
    }

    public String getLastName() {
        return lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword () {
        return password;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

}
