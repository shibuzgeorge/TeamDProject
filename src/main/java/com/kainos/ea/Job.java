package com.kainos.ea;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Job {

    @JsonProperty
    private Integer id;
    @JsonProperty
    private String role;
    @JsonProperty
    private String capability;


    public Job(String role, String capability) {
        this.role = role;
        this.capability = capability;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getCapability() {
        return capability;
    }

    public void setCapability(String capability) {
        this.capability = capability;
    }

    @Override
    public String toString() {
        return "Job{" +
                "id=" + id +
                ", role='" + role + '\'' +
                ", capability='" + capability + '\'' +
                '}';
    }

}
