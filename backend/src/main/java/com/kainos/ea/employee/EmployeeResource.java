package com.kainos.ea.employee;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/api")
public class EmployeeResource {

    private final EmployeeDAO employeeDAO;

    public EmployeeResource(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @GET
    @Path("/employee/getEmployees")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Employee> getEmployees() {
        return employeeDAO.getEmployees();
    }
}
