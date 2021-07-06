package com.kainos.ea;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Role {

    @JsonProperty
    private Integer roleID; //id
    @JsonProperty
    private String roleName; //role
    @JsonProperty
    private Integer capabilityID; //capability


    public Role(String roleName, Integer capabilityID) {
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

    public void setRole(String roleName) {
        this.roleName = roleName;
    }

    public Integer getCapabilityID() {
        return capabilityID;
    }

    public void setCapabilityID(Integer capabilityID) {
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
