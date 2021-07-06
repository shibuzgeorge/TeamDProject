package com.kainos.ea;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Role {

    @JsonProperty
    private Integer roleID; //id
    @JsonProperty
    private String roleName; //role
    @JsonProperty
    private Integer capabilityID; //capability

    public Role(){}
      
    public Role(String roleName){
        this.roleName = roleName;
    }

    public Role(String roleName, Integer capabilityID) {
        this(roleName);
        this.capabilityID = capabilityID;
    }

    public Integer getRoleID() {
        return roleID;
    }

    public void setRoleID(Integer roleID) throws IllegalArgumentException{
            if (roleID < 1) {
                throw new IllegalArgumentException("Given integer must be greater than 1");
            } else if (roleID > 16777215) {
                throw new IllegalArgumentException("Given integer must be not greater than 16777215");
            } else {
                this.roleID = roleID;
            }
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Integer getCapabilityID() {
        return capabilityID;
    }


    public void setCapabilityID(Integer capabilityID) throws IllegalArgumentException{
        if (capabilityID < 1) {
            throw new IllegalArgumentException("Given integer must be greater than 1");
        } else if (capabilityID > 16777215) {
            throw new IllegalArgumentException("Given integer must be not greater than 16777215");
        } else {
            this.capabilityID = capabilityID;
        }
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleId=" + roleID +
                ", roleName='" + roleName + '\'' +
                ", capabilityID='" + capabilityID + '\'' +
                '}';
    }

}
