package com.kainos.ea.capabilitylead;

import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.statement.SqlQuery;

import java.util.List;

@RegisterRowMapper(CapabilityLeadMapper.class)
public interface CapabilityLeadDAO {

    // Can extend this query, need to add image
    @SqlQuery("select * FROM CapabilityLeads;")
    List<CapabilityLead> getCapabilityLead();

}
