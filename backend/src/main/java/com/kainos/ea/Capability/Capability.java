package com.kainos.ea.Capability;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kainos.ea.capabilitylead.CapabilityLead;

import java.util.Objects;

public class Capability {

    @JsonProperty
    private Integer capabilityID;

    @JsonProperty
    private String capabilityName;

    @JsonProperty
    private Integer capabilityLeadID;

    @JsonProperty
    private String capabilityLeadMessage;

    public Capability() {
    }

    public Capability(int capabilityID, String capabilityName, int capabilityLeadID, String capabilityLeadMessage) {
        this.capabilityID = capabilityID;
        this.capabilityName = capabilityName;
        this.capabilityLeadID = capabilityLeadID;
        this.capabilityLeadMessage = capabilityLeadMessage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof CapabilityLead)) {
            return false;
        }

        Capability capability = (Capability) o;
        return capabilityID.equals(capability.capabilityID) &&
                capabilityName.equals(capability.capabilityName) &&
                Objects.equals(capabilityLeadID, capability.capabilityLeadID) &&
                Objects.equals(capabilityLeadMessage, capability.capabilityLeadMessage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(capabilityID, capabilityName, capabilityLeadID, capabilityLeadMessage);
    }

    public Integer getCapabilityID() {
        return capabilityID;
    }

    public void setCapabilityID(Integer capabilityID) throws IllegalArgumentException {
        if (capabilityID < 1) {
            throw new IllegalArgumentException("Given integer must be greater than 1");
        } else if (capabilityID > 16777215) {
            throw new IllegalArgumentException("Given integer must be not greater than 16777215");
        } else {
            this.capabilityID = capabilityID;
        }
    }

    public String getCapabilityName() {
        return capabilityName;
    }

    public void setCapabilityName(String capabilityName) {
        this.capabilityName = capabilityName;
    }

    public Integer getCapabilityLeadID() {
        return capabilityLeadID;
    }

    public void setCapabilityLeadID(Integer capabilityLeadID) {
        if (capabilityLeadID < 1) {
            throw new IllegalArgumentException("Given integer must be greater than 1");
        } else if (capabilityLeadID > 16777215) {
            throw new IllegalArgumentException("Given integer must be not greater than 16777215");
        } else {
            this.capabilityLeadID = capabilityID;
        }
    }

    public String getCapabilityLeadMessage() {
        return capabilityLeadMessage;
    }

    public void setCapabilityLeadMessage(String capabilityLeadMessage) {
        this.capabilityLeadMessage = capabilityLeadMessage;
    }
}
