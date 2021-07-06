package com.kainos.ea;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Role {

    @JsonProperty
    private Integer roleID; //id
    @JsonProperty
    private String roleName; //role
    @JsonProperty
    private String capabilityID; //capability


    public Role(String roleName, String capabilityID) {
        this.roleName = roleName;
        this.capabilityID = capabilityID;
    }

    public Integer getId() {
        return roleID;
    }

    public void setId(Integer roleID) throws IllegalArgumentException{
            if (roleID < 1) {
                throw new IllegalArgumentException("Given integer must be greater than 1");
            } else if (roleID > 16777215) {
                throw new IllegalArgumentException("Given integer must be not greater than 16777215");
            } else {
                this.roleID = roleID;
            }
    }

    public String getRole() {
        return roleName;
    }

    public void setRole(String role) {
        this.roleName = roleName;
    }

    public String getCapability() {
        return capabilityID;
    }

    public void setCapability(String capability) {
        this.capabilityID = capabilityID;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + roleID +
                ", role='" + roleName + '\'' +
                ", capability='" + capabilityID + '\'' +
                '}';
    }

}
