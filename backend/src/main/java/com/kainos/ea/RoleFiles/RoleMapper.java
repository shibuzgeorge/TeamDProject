package com.kainos.ea.RoleFiles;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RoleMapper implements RowMapper<Role> {
    private static final String ID = "roleID";
    private static final String ROLE = "roleName";
    private static final String CAPABILITY = "capabilityName";
    private static final String BAND = "bandName";
    private static final String SPECIFICATION = "specification";
    private static final String SUMMARY = "roleSummary";

    @Override
    public Role map(ResultSet rs, StatementContext ctx) throws SQLException {
        Role role = new Role(rs.getString(ROLE), rs.getString(CAPABILITY), rs.getString(BAND), rs.getString(SPECIFICATION), rs.getString(SUMMARY));
        role.setRoleID(rs.getInt(ID));
        return role;
    }
}