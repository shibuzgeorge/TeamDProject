package com.kainos.ea.capabilitylead;


import com.fasterxml.jackson.annotation.JsonProperty;

public class CapabilityLead {

    @JsonProperty
    private String capabilityName;

    @JsonProperty
    private Integer employeeID;

    @JsonProperty
    private String employeeName;

    public CapabilityLead() {
    }

    public CapabilityLead(String capabilityName) {
        this.capabilityName = capabilityName;
    }

    public CapabilityLead(String capabilityName, String employeeName) {
        this(capabilityName);
        this.employeeName = employeeName;
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

    public void setEmployeeID(Integer employeeID) {
        this.employeeID = employeeID;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    @Override
    public String toString() {
        return "CapabilityLead{" +
                "capabilityName=" + capabilityName +
                ", employeeID='" + employeeID + '\'' +
                ", employeeName='" + employeeName + '\'' +
                '}';
    }
}

