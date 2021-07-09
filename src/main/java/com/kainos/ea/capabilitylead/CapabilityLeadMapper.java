package com.kainos.ea.capabilitylead;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CapabilityLeadMapper implements RowMapper<CapabilityLead> {

    private static final String CAPABILITY_NAME = "capabilityName";
    private static final String EMPLOYEE_ID = "employeeID";
    private static final String EMPLOYEE_NAME = "employeeName";
    private static final String EMPLOYEE_PHOTO = "employeeIDPhoto";

    @Override
    public CapabilityLead map(ResultSet rs, StatementContext ctx) throws SQLException {
        CapabilityLead capabilityLead = new CapabilityLead(rs.getString(CAPABILITY_NAME), rs.getString(EMPLOYEE_NAME), rs.getString(EMPLOYEE_PHOTO));
        capabilityLead.setEmployeeID(rs.getInt(EMPLOYEE_ID));
        System.out.println(capabilityLead);
        return capabilityLead;
    }
}
