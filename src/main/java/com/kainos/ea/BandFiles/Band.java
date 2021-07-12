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

    public void setBandID(Integer bandID) {
        this.bandID = bandID;
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
