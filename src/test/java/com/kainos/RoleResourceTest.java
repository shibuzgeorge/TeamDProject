package com.kainos;

import com.kainos.ea.RoleFiles.Role;
import com.kainos.ea.RoleFiles.RoleDAO;
import com.kainos.ea.RoleFiles.RoleResource;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.*;
import io.dropwizard.testing.junit5.DropwizardExtensionsSupport;
import io.dropwizard.testing.junit5.ResourceExtension;

import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(DropwizardExtensionsSupport.class)
public class RoleResourceTest {
    private static final RoleDAO DAO = mock(RoleDAO.class);
    private static final ResourceExtension EXT = ResourceExtension.builder()
            .addResource(new RoleResource(DAO))
            .build();
    private Role role;

    @BeforeEach
    void setup() {
        role = new Role();
        role.setRoleID(1);
        role.setRoleName("Software Engineering");
        role.setCapability("Engineering");
        role.setBand("Associate");
        role.setSpecification("https://kainossoftwareltd.sharepoint.com/:b:/g/people/EYTCv1ssl6pOuH59zXtoF9YB8qNaEMNSkZIkCthDAY5Kjg?e=Ht84rW");
    }

    @AfterEach
    void tearDown() {
        reset(DAO);
    }

    @Test
    void getRolesOneSuccess() throws Exception {
        final List<Role> ListOfRole = Collections.singletonList(role);

        final Response response = EXT.target("/api/role/getRoles").request().get();
        Assertions.assertEquals(response.getStatusInfo().getStatusCode(), Response.Status.OK.getStatusCode());

        when(DAO.getRoles()).thenReturn(ListOfRole);
        final List<Role> responseList = EXT.target("/api/role/getRoles")
                .request().get(new GenericType<List<Role>>() {
                });

        verify(DAO, times(2)).getRoles();
        Assertions.assertEquals(responseList, ListOfRole);
    }

}
