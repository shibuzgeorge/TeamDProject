package com.kainos.ea.JobFamily;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JobFamilyMapper implements RowMapper<JobFamily> {

    private static final String ID = "jobFamilyID";
    private static final String CAPABILITY = "capabilityName";
    private static final String NAME = "jobFamilyName";
    private static final String LEAD = "employeeName";

    @Override
    public JobFamily map(ResultSet rs, StatementContext ctx) throws SQLException {
        JobFamily jobFamily = new JobFamily(rs.getInt(ID), rs.getString(CAPABILITY), rs.getString(NAME), rs.getString(LEAD));
        return jobFamily;
    }

}
