package com.kainos.ea;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RoleMapper implements RowMapper<Role> {
    private static final String ID = "roleID";
    private static final String ROLE = "roleName";
    private static final String CAPABILITY = "capabilityID";

    @Override
    public Role map(ResultSet rs, StatementContext ctx) throws SQLException {
        Role role = new Role(rs.getString(ROLE), rs.getString(CAPABILITY));
        role.setId(rs.getInt(ID));
        return role;
    }
}