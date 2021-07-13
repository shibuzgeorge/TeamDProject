package com.kainos.ea.employee;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Employee {

    @JsonProperty
    private Integer employeeID;
    @JsonProperty
    private String employeeName;
    @JsonProperty
    private String employeeIDPhoto;

    public Employee() {
    }

    public Employee(String employeeName) {
        this.employeeName = employeeName;
    }

    public Employee(String employeeName, String employeeIDPhoto) {
        this(employeeName);
        this.employeeIDPhoto = employeeIDPhoto;
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
        return "Employee{" +
                "employeeID=" + employeeID +
                ", employeeName='" + employeeName + '\'' +
                ", employeeIDPhoto='" + employeeIDPhoto + '\'' +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Employee)) {
            return false;
        }

        Employee employee = (Employee) o;
        return employeeID.equals(employee.employeeID) &&
                employeeIDPhoto.equals(employee.employeeIDPhoto) &&
                Objects.equals(employeeName, employee.employeeName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeID, employeeName, employeeIDPhoto);
    }

}
