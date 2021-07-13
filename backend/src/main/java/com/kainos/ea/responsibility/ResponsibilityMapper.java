package com.kainos.ea.responsibility;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ResponsibilityMapper implements RowMapper<Responsibility> {

    private static final String ROLE_ID = "roleID";
    private static final String RESPONSIBILITY_ID = "responsibilityID";
    private static final String RESPONSIBILITY_TEXT = "responsibility";

    @Override
    public Responsibility map(ResultSet rs, StatementContext ctx) throws SQLException {
        Responsibility responsibility = new Responsibility(rs.getString(RESPONSIBILITY_TEXT), rs.getInt(RESPONSIBILITY_ID));
        responsibility.setRoleID(rs.getInt(ROLE_ID));
        return responsibility;
    }
}
