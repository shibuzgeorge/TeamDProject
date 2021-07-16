package com.kainos.ea.JobFamily;

import com.fasterxml.jackson.annotation.JsonProperty;

public class JobFamily {
    @JsonProperty
    private int jobFamilyID;
    @JsonProperty
    private String capability;
    @JsonProperty
    private String jobFamilyName;
    @JsonProperty
    private String disciplineLead;

    public JobFamily(int jobFamilyID, String capabilityID, String jobFamilyName, String disciplineLead) {
        this.setJobFamilyID(jobFamilyID);
        this.setCapabilityID(capabilityID);
        this.setJobFamilyName(jobFamilyName);
        this.setDisciplineLead(disciplineLead);
    }

    public JobFamily(){
    }


    public int getJobFamilyID() {
        return jobFamilyID;
    }

    public void setJobFamilyID(int jobFamilyID) {
        this.jobFamilyID = jobFamilyID;
    }

    public String getCapability() {
        return capability;
    }

    public void setCapabilityID(String capability) {
        this.capability = capability;
    }

    public String getJobFamilyName() {
        return jobFamilyName;
    }

    public void setJobFamilyName(String jobFamilyName) {
        this.jobFamilyName = jobFamilyName;
    }

    public String getDisciplineLead() {
        return disciplineLead;
    }

    public void setDisciplineLead(String disciplineLead) {
        this.disciplineLead = disciplineLead;
    }
}
