package com.kainos.ea.Capability;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CapabilityMapper implements RowMapper<Capability> {

    private static final String CAPABILITY_ID = "capabilityID";
    private static final String CAPABILITY_NAME = "capabilityName";
    private static final String CAPABILITY_LEAD_ID = "capabilityLeadID";
    private static final String CAPABILITY_LEAD_MESSAGE = "capabilityLeadMessage";

    @Override
    public Capability map(ResultSet rs, StatementContext ctx) throws SQLException {
        Capability capability = new Capability(rs.getInt(CAPABILITY_ID), rs.getString(CAPABILITY_NAME), rs.getInt(CAPABILITY_LEAD_ID), rs.getString(CAPABILITY_LEAD_MESSAGE));
        return capability;
    }
}
