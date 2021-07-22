package com.kainos.ea.employee;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Api(value="/employee")
@Path("/api")
public class EmployeeResource {

    private final EmployeeDAO employeeDAO;

    public EmployeeResource(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @GET
    @RolesAllowed({ "Admin" })
    @Path("/employee/getEmployees")
    @ApiOperation(
            value = "Gets all employees",
            notes = "Returns a list of all employees in the database",
            response = Employee.class)
    @ApiResponses(value = {
            @ApiResponse(code = 401, message = "User is not authorised for this request"),
            @ApiResponse(code = 403, message = "Forbidden: This user does not have authorisation for this request"),
            @ApiResponse(code = 500, message = "Internal server error") })
    @Produces(MediaType.APPLICATION_JSON)
    public List<Employee> getEmployees() {
        return employeeDAO.getEmployees();
    }
}
