package com.kainos.ea.RoleFiles;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Role {

    @JsonProperty
    private Integer roleID; //id
    @JsonProperty
    private String roleName; //role
    @JsonProperty
    private String capability; //capability
    @JsonProperty
    private String band; //band
    @JsonProperty
    private String specification; //specification
    @JsonProperty
    private String roleSummary;
    @JsonProperty
    private String jobFamily;

    public Role() {
    }

    public Role(String roleName) {
        this.setRoleName(roleName);
    }

    public Role(String roleName, String capability) {
        this(roleName);
        this.setCapability(capability);
    }

    public Role(String roleName, String capability, String band) {
        this(roleName, capability);
        this.setBand(band);
    }

    public Role(String roleName, String capability, String band, String specification) {
        this(roleName, capability, band);
        this.setSpecification(specification);
    }

    public Role(String roleName, String capability, String band, String specification, String roleSummary) {
        this(roleName, capability, band, specification);
        this.setRoleSummary(roleSummary);
    }

    public Role(String roleName, String capability, String band, String specification, String roleSummary, String jobFamily) {
        this(roleName, capability, band, specification, roleSummary);
        this.setJobFamily(jobFamily);
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

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getCapability() {
        return capability;
    }

    public String getBand() {
        return band;
    }

    public void setBand(String band) {
        this.band = band;
    }

    public void setCapability(String capability) throws IllegalArgumentException {
        this.capability = capability;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public String getRoleSummary() {
        return roleSummary;
    }

    public void setRoleSummary(String roleSummary) {
        this.roleSummary = roleSummary;
    }

    public String getJobFamily() {
        return jobFamily;
    }

    public void setJobFamily(String jobFamily) {
        this.jobFamily = jobFamily;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleId=" + roleID +
                ", roleName='" + roleName + '\'' +
                ", capability='" + capability + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Role)) {
            return false;
        }

        Role role = (Role) o;
        return roleID.equals(role.roleID) &&
                capability.equals(role.capability) &&
                Objects.equals(roleName, role.roleName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleID, capability, roleName, band);
    }


}
