package com.kainos.ea.user;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.security.Principal;
import java.util.Objects;

public class User implements Principal {

    @JsonProperty
    private Integer userID;
    @JsonProperty
    private String username;
    @JsonProperty
    private String role;

    public User() {
    }

    public User(String username, String role) {
        this.username = username;
        this.role = role;
    }


    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) throws IllegalArgumentException {
        if (userID < 1) {
            throw new IllegalArgumentException("Given integer must be greater than 1");
        } else if (userID > 16777215) {
            throw new IllegalArgumentException("Given integer must be not greater than 16777215");
        } else {
            this.userID = userID;
        }
    }

    public String getUsername() {
        return username;
    }

    public String getRole() {
        return role;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "userID=" + userID +
                ", username='" + username + '\'' +
                ", role='" + role + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userID, user.userID)
                && Objects.equals(username, user.username)
                && Objects.equals(role, user.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userID, username, role);
    }

    @Override
    public String getName() {
        return username;
    }
}