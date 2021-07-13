package com.kainos;

import com.kainos.ea.responsibility.Responsibility;
import com.kainos.ea.responsibility.ResponsibilityDAO;
import com.kainos.ea.responsibility.ResponsibilityResource;
import io.dropwizard.testing.junit5.DropwizardExtensionsSupport;
import io.dropwizard.testing.junit5.ResourceExtension;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

import static org.mockito.Mockito.*;

@ExtendWith(DropwizardExtensionsSupport.class)
public class ResponsibilityResourceTest {

    private static final ResponsibilityDAO DAO = mock(ResponsibilityDAO.class);
    private static final ResourceExtension EXT = ResourceExtension.builder()
            .addResource(new ResponsibilityResource(DAO))
            .build();
    private Responsibility responsibility;

    @BeforeEach
    void setUp() {
        responsibility = new Responsibility();
        responsibility.setResponsibilityID(1);
        responsibility.setRoleID(1);
        responsibility.setResponsibilityText("As a Test Engineer (Trainee) in Kainos, you’ll work within a multi-skilled agile team, developing and executing functional automated and manual tests to help the team deliver working application software that meets user needs.");
    }

    @AfterEach
    void tearDown() {
        reset(DAO);
    }

    @Test
    void getResponsibilityOneSuccess() throws Exception {
        final Responsibility testResponsibility = responsibility;
        when(DAO.getResponsibility(1)).thenReturn(testResponsibility);

        final Responsibility responseStr = EXT.target("/api/responsibility/getResponsibilityByID/1")
                .request().get(Responsibility.class);

        verify(DAO).getResponsibility(1);
        Assertions.assertEquals(testResponsibility, responseStr);
    }
}
