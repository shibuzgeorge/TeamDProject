package com.kainos.ea.employee;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeMapper implements RowMapper<Employee> {
    private static final String ID = "employeeID";
    private static final String NAME = "employeeName";
    private static final String PHOTO = "employeeIDPhoto";

    @Override
    public Employee map(ResultSet rs, StatementContext ctx) throws SQLException {
        Employee employee = new Employee(rs.getString(NAME), rs.getString(PHOTO));
        employee.setEmployeeID(rs.getInt(ID));
        return employee;
    }
}