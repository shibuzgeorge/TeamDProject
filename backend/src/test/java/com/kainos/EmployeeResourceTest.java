package com.kainos;

import com.kainos.ea.employee.Employee;
import com.kainos.ea.employee.EmployeeDAO;
import com.kainos.ea.employee.EmployeeResource;
import io.dropwizard.testing.junit5.DropwizardExtensionsSupport;
import io.dropwizard.testing.junit5.ResourceExtension;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(DropwizardExtensionsSupport.class)
public class EmployeeResourceTest {
    private static final EmployeeDAO DAO = mock(EmployeeDAO.class);
    private static final ResourceExtension EXT = ResourceExtension.builder()
            .addResource(new EmployeeResource(DAO))
            .build();
    private Employee employee;

    @BeforeEach
    void setup() {
        employee = new Employee();
        employee.setEmployeeID(1);
        employee.setEmployeeName("John Test");
        employee.setEmployeeIDPhoto("iVBORw0KGgoAAAANSUhEUgAAAAUAAAAFCAYAAACNbyblAAAAHElEQVQI12P4//8/w38GIAXDIBKE0DHxgljNBAAO9TXL0Y4OHwAAAABJRU5ErkJggg==");
    }

    @AfterEach
    void tearDown() {
        reset(DAO);
    }

    @Test
    void getEmployeeAllSuccess() throws Exception {
        final List<Employee> ListOfEmployee = Collections.singletonList(employee);

        final Response response = EXT.target("/api/employee/getEmployees").request().get();
        Assertions.assertEquals(response.getStatusInfo().getStatusCode(), Response.Status.OK.getStatusCode());

        when(DAO.getEmployees()).thenReturn(ListOfEmployee);
        final List<Employee> responseList = EXT.target("/api/employee/getEmployees")
                .request().get(new GenericType<List<Employee>>() {
                });

        verify(DAO, times(2)).getEmployees();
        Assertions.assertEquals(responseList, ListOfEmployee);

    }
}
