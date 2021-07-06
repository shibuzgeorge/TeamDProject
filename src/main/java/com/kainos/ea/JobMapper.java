package com.kainos.ea;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JobMapper implements RowMapper<Job> {
    private static final String ID = "id";
    private static final String ROLE = "role";
    private static final String CAPABILITY = "capability";

    @Override
    public Job map(ResultSet rs, StatementContext ctx) throws SQLException {
        Job job = new Job(rs.getString(ROLE), rs.getString(CAPABILITY));
        job.setId(rs.getInt(ID));
        return job;
    }
}