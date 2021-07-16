package com.kainos.ea.JobFamily;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

public class JobFamily {
    @JsonProperty
    private int jobFamilyID;
    @JsonProperty
    private String capability; // capability name
    @JsonProperty
    private String jobFamilyName;
    @JsonProperty
    private String disciplineLead; // correlates to employeeName

    public JobFamily(int jobFamilyID, String capability, String jobFamilyName, String disciplineLead) {
        this.setJobFamilyID(jobFamilyID);
        this.setCapability(capability);
        this.setJobFamilyName(jobFamilyName);
        this.setDisciplineLead(disciplineLead);
    }

    public JobFamily(){
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof JobFamily)) {
            return false;
        }

        JobFamily jobFamily = (JobFamily) o;
        return Objects.equals(jobFamilyID, jobFamily.jobFamilyID) &&
                Objects.equals(capability, jobFamily.capability) &&
                Objects.equals(jobFamilyName, jobFamily.jobFamilyName) &&
                Objects.equals(disciplineLead, jobFamily.disciplineLead);
    }

    @Override
    public int hashCode() {
        return Objects.hash(jobFamilyID, capability, jobFamilyName, disciplineLead);
    }


    public int getJobFamilyID() {
        return jobFamilyID;
    }

    public void setJobFamilyID(int jobFamilyID) {

        if (jobFamilyID < 1) {
            throw new IllegalArgumentException("Given integer must be greater than 1");
        } else if (jobFamilyID > 16777215) {
            throw new IllegalArgumentException("Given integer must be not greater than 16777215");
        } else {
            this.jobFamilyID = jobFamilyID;
        }
    }

    public String getCapability() {
        return capability;
    }

    public void setCapability(String capability) {
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
