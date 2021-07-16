package com.kainos.ea.BandFiles;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Band {

    @JsonProperty
    private Integer bandID; //id
    @JsonProperty
    private String bandName; //band


    public Band() {
    }

    public Band(String bandName) {
        this.bandName = bandName;
    }




    public Integer getBandID() {
        return bandID;
    }

    public void setBandID(Integer bandID) throws IllegalArgumentException {
        if (bandID < 1) {
            throw new IllegalArgumentException("Given integer must be greater than 1");
        } else if (bandID > 16777215) {
            throw new IllegalArgumentException("Given integer must be not greater than 16777215");
        } else {
            this.bandID = bandID;
        }
    }

    public String getBandName() {
        return bandName;
    }

    public void setBandName(String bandName) {
        this.bandName = bandName;
    }

    @Override
    public String toString() {
        return "Band{" +
                "bandID=" + bandID +
                ", bandName='" + bandName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Band band = (Band) o;
        return Objects.equals(bandID, band.bandID) && Objects.equals(bandName, band.bandName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bandID, bandName);
    }
}
