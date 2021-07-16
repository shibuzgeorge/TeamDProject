package com.kainos;

import com.kainos.ea.training.Training;
import com.kainos.ea.training.TrainingDAO;
import com.kainos.ea.training.TrainingResource;
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
import static org.mockito.Mockito.verify;

@ExtendWith(DropwizardExtensionsSupport.class)
public class TrainingResourceTest {

    private static final TrainingDAO DAO = mock(TrainingDAO.class);
    private static final ResourceExtension EXT = ResourceExtension.builder()
            .addResource(new TrainingResource(DAO))
            .build();
    private Training training;

    @BeforeEach
    void setup() {
        training = new Training();
        training.setTrainingID(1);
        training.setTrainingName("Presenting with Impact");
        training.setTrainingLink("https://kainossoftwareltd.sharepoint.com/L%26D/SitePages/Presenting-with-Impact.aspx");
        training.setTrainingType("Professional skills");
    }

    @AfterEach
    void tearDown() {
        reset(DAO);
    }

    @Test
    void getAllTrainingSuccess() throws Exception {
        final List<Training> ListOfTraining = Collections.singletonList(training);

        when(DAO.getTrainings()).thenReturn(ListOfTraining);
        final List<Training> responseList = EXT.target("/api/training/getTrainings")
                .request().get(new GenericType<List<Training>>() {
                });

        verify(DAO).getTrainings();
        Assertions.assertEquals(responseList, ListOfTraining);
    }

    @Test
    void getTrainingByBandSuccess() throws Exception {
        final List<Training> ListOfTrainingByBand = Collections.singletonList(training);

        when(DAO.getTrainingByBandID(1)).thenReturn(ListOfTrainingByBand);
        final List<Training> responseList = EXT.target("/api/training/getTrainingByBand/1")
                .request().get(new GenericType<List<Training>>() {
                });

        verify(DAO).getTrainingByBandID(1);
        Assertions.assertEquals(responseList, ListOfTrainingByBand);
    }
}
