package com.kainos;

import com.kainos.ea.Capability.Capability;
import com.kainos.ea.Capability.CapabilityDAO;
import com.kainos.ea.Capability.CapabilityResource;
import com.kainos.ea.RoleFiles.Role;
import com.kainos.ea.employee.Employee;
import com.kainos.ea.responsibility.Responsibility;
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

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(DropwizardExtensionsSupport.class)
public class CapabilityResourceTest {
    private static final CapabilityDAO capabilityDAO = mock(CapabilityDAO.class);
    private static final ResourceExtension EXT = ResourceExtension.builder()
            .addResource(new CapabilityResource(capabilityDAO))
            .build();
    private Capability capability;

    @BeforeEach
    void setup() {
        capability = new Capability();
        capability.setCapabilityID(1);
        capability.setCapabilityName("Engineering");
        capability.setCapabilityLeadID(1);
        capability.setCapabilityLeadMessage("Come join the Engineering team");
    }

    @AfterEach
    void tearDown() {
        reset(capabilityDAO);
    }

    @Test
    void getCapabilityAllSuccess() throws Exception {
        final List<Capability> ListOfCapability = Collections.singletonList(capability);

        when(capabilityDAO.getCapability()).thenReturn(ListOfCapability);
        final List<Capability> responseList = EXT.target("/api/capability/getCapability")
                .request().get(new GenericType<List<Capability>>() {
                });

        verify(capabilityDAO).getCapability();
        Assertions.assertEquals(responseList, ListOfCapability);

    }
}



