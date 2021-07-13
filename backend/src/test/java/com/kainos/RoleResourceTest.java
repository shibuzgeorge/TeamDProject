package com.kainos;

import com.kainos.ea.RoleFiles.Role;
import com.kainos.ea.RoleFiles.RoleDAO;
import com.kainos.ea.RoleFiles.RoleResource;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.*;
import io.dropwizard.testing.junit5.DropwizardExtensionsSupport;
import io.dropwizard.testing.junit5.ResourceExtension;

import javax.ws.rs.core.GenericType;
import static org.assertj.core.api.Assertions.assertThat;
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
    void getAllRolesSuccess() throws Exception {
        final List<Role> ListOfRole = Collections.singletonList(role);

        when(DAO.getRoles()).thenReturn(ListOfRole);
        final List<Role> responseList = EXT.target("/api/role/getRoles")
                .request().get(new GenericType<List<Role>>() {
                });

        verify(DAO).getRoles();
        Assertions.assertEquals(responseList, ListOfRole);
    }

    @Test
    void getRoleSuccess() throws Exception {
        final Role newRole = new Role("Test Engineer", "Engineering", "Trainee", "https://kainossoftwareltd.sharepoint.com/:b:/g/people/EcGbc8drFRlBoh2H2BZSeVwBV1tAiDCTwirdTmrz2EYYmQ?e=XMqXJh");
        newRole.setRoleID(1);

        when(DAO.getRoleByID(1)).thenReturn(newRole);
        final Role response = EXT.target("/api/role/1")
                .request().get(Role.class);
        assertThat(response.getRoleID()).isEqualTo(newRole.getRoleID());
        assertThat(response.getRoleName()).isEqualTo(newRole.getRoleName());
        assertThat(response.getBand()).isEqualTo(newRole.getBand());
        assertThat(response.getSpecification()).isEqualTo(newRole.getSpecification());
        verify(DAO).getRoleByID(1);
    }

}
