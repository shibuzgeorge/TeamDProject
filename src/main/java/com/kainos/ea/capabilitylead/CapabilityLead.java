package com.kainos.ea.capabilitylead;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class CapabilityLead {

    @JsonProperty
    private String capabilityName;

    @JsonProperty
    private Integer employeeID;

    @JsonProperty
    private String employeeName;

    @JsonProperty
    private String employeeIDPhoto;

    public CapabilityLead() {
    }

    public CapabilityLead(String capabilityName) {
        this.capabilityName = capabilityName;
    }

    public CapabilityLead(String capabilityName, String employeeName, String employeeIDPhoto) {
        this(capabilityName);
        this.employeeName = employeeName;
        this.employeeIDPhoto = employeeIDPhoto;
    }

    public String getCapabilityName() {
        return capabilityName;
    }

    public void setCapabilityName(String capabilityName) {
        this.capabilityName = capabilityName;
    }

    public Integer getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(Integer employeeID) throws IllegalArgumentException {
        if (employeeID < 1) {
            throw new IllegalArgumentException("Given integer must be greater than 1");
        } else if (employeeID > 16777215) {
            throw new IllegalArgumentException("Given integer must be not greater than 16777215");
        } else {
            this.employeeID = employeeID;
        }
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeIDPhoto() {
        return employeeIDPhoto;
    }

    public void setEmployeeIDPhoto(String employeeIDPhoto) throws IllegalArgumentException{
        this.employeeIDPhoto = employeeIDPhoto;
    }

    @Override
    public String toString() {
        return "CapabilityLead{" +
                "capabilityName=" + capabilityName +
                ", employeeID='" + employeeID + '\'' +
                ", employeeName='" + employeeName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof CapabilityLead)) {
            return false;
        }

        CapabilityLead capabilityLead = (CapabilityLead) o;
        return employeeID.equals(capabilityLead.employeeID) &&
                capabilityName.equals(capabilityLead.capabilityName) &&
                Objects.equals(employeeName, capabilityLead.employeeName) &&
                Objects.equals(employeeIDPhoto, capabilityLead.employeeIDPhoto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeID, employeeName, capabilityName, employeeIDPhoto);
    }
}

