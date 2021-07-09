package com.kainos.ea.employee;

import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.statement.SqlQuery;

import java.util.List;

@RegisterRowMapper(EmployeeMapper.class)
public interface EmployeeDAO {

    @SqlQuery("select * from Employee;")
    public List<Employee> getEmployees();
}
