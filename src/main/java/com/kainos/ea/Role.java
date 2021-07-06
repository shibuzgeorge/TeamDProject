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

    public void setId(Integer roleID) {
        this.roleID = roleID;
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
