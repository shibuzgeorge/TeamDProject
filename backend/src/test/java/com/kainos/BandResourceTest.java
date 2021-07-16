package com.kainos;

import com.kainos.ea.BandFiles.Band;
import com.kainos.ea.BandFiles.BandDAO;
import com.kainos.ea.BandFiles.BandResource;
import com.kainos.ea.BandFiles.Band;
import com.kainos.ea.BandFiles.Band;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.*;
import io.dropwizard.testing.junit5.DropwizardExtensionsSupport;
import io.dropwizard.testing.junit5.ResourceExtension;
import javax.ws.rs.core.GenericType;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

@ExtendWith(DropwizardExtensionsSupport.class)
public class BandResourceTest {
    private static final BandDAO DAO = mock(BandDAO.class);
    private static final ResourceExtension EXT = ResourceExtension.builder()
            .addResource(new BandResource(DAO))
            .build();
    private Band band;

    @BeforeEach
    void setup() {
        band = new Band();
        band.setBandID(1);
        band.setBandName("Working with Others");
    }

    @AfterEach
    void tearDown() {
        reset(DAO);
    }

    @Test
    void getAllBandsSuccess() throws Exception {
        final List<Band> ListOfBand = Collections.singletonList(band);

        when(DAO.getBands()).thenReturn(ListOfBand);
        final List<Band> responseList = EXT.target("/api/band/getBands")
                .request().get(new GenericType<List<Band>>() {
                });

        verify(DAO).getBands();
        Assertions.assertEquals(responseList, ListOfBand);
    }

    
}
