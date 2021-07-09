package com.kainos;

import com.kainos.ea.capabilitylead.CapabilityLead;
import com.kainos.ea.capabilitylead.CapabilityLeadDAO;
import com.kainos.ea.capabilitylead.CapabilityLeadResource;
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
public class CapabilityLeadResourceTest {
    private static final CapabilityLeadDAO capabilityLeadDAO = mock(CapabilityLeadDAO.class);
    private static final ResourceExtension EXT = ResourceExtension.builder()
            .addResource(new CapabilityLeadResource(capabilityLeadDAO))
            .build();
    private CapabilityLead capabilityLead;

    @BeforeEach
    void setup() {
        capabilityLead = new CapabilityLead();
        capabilityLead.setEmployeeID(1);
        capabilityLead.setCapabilityName("Engineering");
        capabilityLead.setEmployeeName("Peter");
    }

    @AfterEach
    void tearDown() {
        reset(capabilityLeadDAO);
    }

    @Test
    void getCapabilityLeadAllSuccess() throws Exception {
        final List<CapabilityLead> ListOfCapabilityLeads = Collections.singletonList(capabilityLead);

        final Response response = EXT.target("/api/capability/getCapabilityLeads").request().get();
        Assertions.assertEquals(response.getStatusInfo().getStatusCode(), Response.Status.OK.getStatusCode());

        when(capabilityLeadDAO.getCapabilityLead()).thenReturn(ListOfCapabilityLeads);
        final List<CapabilityLead> responseList = EXT.target("/api/capability/getCapabilityLeads")
                .request().get(new GenericType<List<CapabilityLead>>() {
                });

        verify(capabilityLeadDAO, times(2)).getCapabilityLead();
        Assertions.assertEquals(responseList, ListOfCapabilityLeads);

    }
}
