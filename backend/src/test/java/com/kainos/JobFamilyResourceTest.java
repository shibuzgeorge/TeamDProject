package com.kainos;

import com.kainos.ea.Capability.Capability;
import com.kainos.ea.JobFamily.JobFamily;
import com.kainos.ea.JobFamily.JobFamilyDAO;
import com.kainos.ea.JobFamily.JobFamilyResource;
import com.kainos.ea.responsibility.Responsibility;
import io.dropwizard.testing.junit5.DropwizardExtensionsSupport;
import io.dropwizard.testing.junit5.ResourceExtension;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import javax.ws.rs.core.GenericType;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(DropwizardExtensionsSupport.class)
public class JobFamilyResourceTest {

    private static final JobFamilyDAO jobFamilyDAO = mock(JobFamilyDAO.class);
    private static final ResourceExtension EXT = ResourceExtension.builder()
            .addResource(new JobFamilyResource(jobFamilyDAO))
            .build();
    private JobFamily jobFamily;

    @BeforeEach
    void setup() {
        jobFamily = new JobFamily();
        jobFamily.setJobFamilyID(1);
        jobFamily.setJobFamilyName("Testing and Quality Assurance");
        jobFamily.setDisciplineLead("Peter");
        jobFamily.setCapability("Capability");
    }

    @AfterEach
    void tearDown() { reset(jobFamilyDAO); }

    @Test
    void getJobFamilyAllSuccess() throws Exception {

        final List<JobFamily> ListOfJobFamily = Collections.singletonList(jobFamily);

        when(jobFamilyDAO.getJobFamilies()).thenReturn(ListOfJobFamily);
        final List<JobFamily> responseList = EXT.target("/api/jobFamily/getJobFamily")
                .request().get(new GenericType<List<JobFamily>>() {
                });

        verify(jobFamilyDAO).getJobFamilies();
        Assertions.assertEquals(responseList, ListOfJobFamily);
    }

    @Test
    void getJobFamiliesInOneCapabilitySuccess() throws Exception {
        final List<JobFamily> listOfJobFamily = Collections.singletonList(jobFamily);
        when(jobFamilyDAO.getJobFamilyByCapability("Engineering")).thenReturn(listOfJobFamily);

        final List<JobFamily> responseJobFamilyList = EXT.target("/api/jobFamilyFromCapability/Engineering")
                .request().get(new GenericType<List<JobFamily>>() {
                });

        verify(jobFamilyDAO).getJobFamilyByCapability("Engineering");
        Assertions.assertEquals(listOfJobFamily, responseJobFamilyList);
    }
}
