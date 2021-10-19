package com.StudentMarkWeb.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Users {

    @Id

     @GeneratedValue(strategy = GenerationType.AUTO)
     int id;
    @NotNull(message = "Username Can not be Empty")
    @Size(min = 3,max = 5, message = "username must be between 3-5 Characters")
     String username;

    @NotNull(message = "password must be more than 3 Characters")
     String password;
     String email;
     String type;

    public Users() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
