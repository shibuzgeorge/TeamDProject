package com.kainos.ea.CompetencyFiles;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Competency {

    @JsonProperty
    private Integer compID;

    @JsonProperty
    private String compName;

    @JsonProperty
    private Integer bandID;

    @JsonProperty
    private String description;


    public Competency() {

    }

    public Competency(Integer bandID) {
        this.bandID = bandID;
    }

    public Competency(String compName) {
        this.compName = compName;
    }

    public Competency(String compName, String description) {
        this.compName = compName;
        this.description = description;
    }

    public Competency(String compName, Integer bandID) {
        this.compName = compName;
        this.bandID = bandID;
    }

    public Competency(Integer bandID, String description) {
        this.bandID = bandID;
        this.description = description;
    }

    public Competency(Integer compID, Integer bandID, String description) {
        this.compID = compID;
        this.bandID = bandID;
        this.description = description;
    }

    public Competency(String compName, Integer bandID, String description) {
        this.compName = compName;
        this.bandID = bandID;
        this.description = description;
    }

    public Competency(Integer compID, String compName, Integer bandID, String description) {
        this.compID = compID;
        this.compName = compName;
        this.bandID = bandID;
        this.description = description;
    }

    public Integer getCompID() {
        return compID;
    }

    public void setCompID(Integer compID) throws IllegalArgumentException {
        if (compID < 1) {
            throw new IllegalArgumentException("Given integer must be greater than 1");
        } else if (compID > 16777215) {
            throw new IllegalArgumentException("Given integer must be not greater than 16777215");
        } else {
            this.compID = compID;
        }
    }

    public String getCompName() {
        return compName;
    }

    public void setCompName(String compName) {
        this.compName = compName;
    }

    public Integer getBandID() {
        return bandID;
    }

    public void setBandID(Integer bandID) {
        this.bandID = bandID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Competency that = (Competency) o;
        return Objects.equals(compID, that.compID) && Objects.equals(compName, that.compName) && Objects.equals(bandID, that.bandID) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(compID, compName, bandID, description);
    }

    @Override
    public String toString() {
        return "Competency{" +
                "compID=" + compID +
                ", compName='" + compName + '\'' +
                ", bandID=" + bandID +
                ", description='" + description + '\'' +
                '}';
    }
}
