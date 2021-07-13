package com.kainos.ea.responsibility;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Responsibility {

    @JsonProperty
    private Integer roleID; //id

    @JsonProperty
    private Integer responsibilityID; // responsibility id

    @JsonProperty
    private String responsibilityText; //responsibility

    public Responsibility() {
    }

    public Responsibility(String responsibility, int roleID, int responsibilityID) {
        this.responsibilityText = responsibility;
        this.roleID = roleID;
        this.responsibilityID = responsibilityID;
    }

    public Responsibility(String responsibilityText, int responsibilityID) {
        this.responsibilityText = responsibilityText;
        this.responsibilityID = responsibilityID;
    }

    public Integer getRoleID() {
        return roleID;
    }

    public void setRoleID(Integer roleID) throws IllegalArgumentException {
        if (roleID < 1) {
            throw new IllegalArgumentException("Given integer must be greater than 1");
        } else if (roleID > 16777215) {
            throw new IllegalArgumentException("Given integer must be not greater than 16777215");
        } else {
            this.roleID = roleID;
        }
    }

    public String getResponsibilityText() {
        return responsibilityText;
    }

    public void setResponsibilityText(String responsibilityText) {
        this.responsibilityText = responsibilityText;
    }

    public Integer getResponsibilityID() {
        return responsibilityID;
    }

    public void setResponsibilityID(Integer responsibilityID) {
        this.responsibilityID = responsibilityID;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleId=" + roleID +
                ", responsibilityText='" + responsibilityText + '\'' +
                ", responsibilityID='" + responsibilityID + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Responsibility)) {
            return false;
        }

        Responsibility responsibility = (Responsibility) o;
        return roleID.equals(responsibility.roleID) &&
                responsibilityText.equals(responsibility.responsibilityText) &&
                Objects.equals(responsibilityID, responsibility.responsibilityID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleID, responsibilityID, responsibilityText);
    }

}
