package com.kainos;

import com.kainos.ea.CompetencyFiles.Competency;
import com.kainos.ea.CompetencyFiles.CompetencyDAO;
import com.kainos.ea.CompetencyFiles.CompetencyResource;
import com.kainos.ea.RoleFiles.Role;
import com.kainos.ea.RoleFiles.RoleDAO;
import com.kainos.ea.RoleFiles.RoleResource;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.*;
import io.dropwizard.testing.junit5.DropwizardExtensionsSupport;
import io.dropwizard.testing.junit5.ResourceExtension;
import javax.ws.rs.core.GenericType;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

import java.util.Collections;
import java.util.List;

@ExtendWith(DropwizardExtensionsSupport.class)
public class CompetencyResourceTest {
    private static final CompetencyDAO DAO = mock(CompetencyDAO.class);
    private static final ResourceExtension EXT = ResourceExtension.builder()
            .addResource(new CompetencyResource(DAO))
            .build();
    private Competency competency;


    @BeforeEach
    void setup() {
        competency = new Competency();
        competency.setCompID(1);
        competency.setCompName("Working with Others");
        competency.setBandID(7);
        competency.setDescription("This is a big long description right here");
    }

    @AfterEach
    void tearDown() {
        reset(DAO);
    }

    @Test
    void getAllCompetenciesSuccess() throws Exception {
        final List<Competency> ListOfCompetency = Collections.singletonList(competency);

        when(DAO.getCompetencies()).thenReturn(ListOfCompetency);
        final List<Competency> responseList = EXT.target("/api/competency/getCompetencies")
                .request().get(new GenericType<List<Competency>>() {
                });

        verify(DAO).getCompetencies();
        Assertions.assertEquals(responseList, ListOfCompetency);
    }

    @Test
    void getCompetencySuccess() throws Exception {
        final Competency newCompetency = new Competency(1, "Working with Others", 1, "https://kainossoftwareltd.sharepoint.com/:b:/g/people/EcGbc8drFRlBoh2H2BZSeVwBV1tAiDCTwirdTmrz2EYYmQ?e=XMqXJh");
        newCompetency.setCompID(1);

        when(DAO.getCompetencyByID(1)).thenReturn(newCompetency);
        final Competency response = EXT.target("/api/competency/1")
                .request().get(Competency.class);
        assertThat(response.getCompID()).isEqualTo(newCompetency.getCompID());
        assertThat(response.getCompName()).isEqualTo(newCompetency.getCompName());
        assertThat(response.getBandID()).isEqualTo(newCompetency.getBandID());
        assertThat(response.getDescription()).isEqualTo(newCompetency.getDescription());
        verify(DAO).getCompetencyByID(1);
    }
}