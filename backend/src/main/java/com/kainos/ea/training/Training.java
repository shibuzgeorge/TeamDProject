package com.kainos.ea.training;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Training {

    @JsonProperty
    private Integer trainingID;
    @JsonProperty
    private String trainingName;
    @JsonProperty
    private String trainingType;
    @JsonProperty
    private String trainingLink;

    public Training() {
    }

    public Training(String trainingName) {
        this.setTrainingName(trainingName);
    }

    public Training(String trainingName, String trainingType) {
        this(trainingName);
        this.setTrainingType(trainingType);
    }


    public Training(String trainingName, String trainingType, String trainingLink) {
        this(trainingName, trainingType);
        this.setTrainingLink(trainingLink);
    }

    public Integer getTrainingID() {
        return trainingID;
    }

    public void setTrainingID(Integer trainingID) throws IllegalArgumentException {
        if (trainingID < 1) {
            throw new IllegalArgumentException("Given integer must be greater than 1");
        } else if (trainingID > 16777215) {
            throw new IllegalArgumentException("Given integer must be not greater than 16777215");
        } else {
            this.trainingID = trainingID;
        }
    }

    public String getTrainingName() {
        return trainingName;
    }

    public void setTrainingName(String trainingName) {
        this.trainingName = trainingName;
    }

    public String getTrainingType() {
        return trainingType;
    }

    public String getTrainingLink() {
        return trainingLink;
    }

    public void setTrainingLink(String trainingLink) {
        this.trainingLink = trainingLink;
    }

    public void setTrainingType(String trainingType) throws IllegalArgumentException {
        this.trainingType = trainingType;
    }

    @Override
    public String toString() {
        return "Training{" +
                "trainingId=" + trainingID +
                ", trainingName='" + trainingName + '\'' +
                ", trainingLink='" + trainingLink + '\'' +
                ", trainingType='" + trainingType + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Training)) {
            return false;
        }

        Training training = (Training) o;
        return trainingID.equals(training.trainingID) &&
                trainingName.equals(training.trainingName) &&
                Objects.equals(trainingType, training.trainingType) &&
                Objects.equals(trainingLink, training.trainingLink);
    }

    @Override
    public int hashCode() {
        return Objects.hash(trainingID, trainingName, trainingType, trainingLink);
    }


}
