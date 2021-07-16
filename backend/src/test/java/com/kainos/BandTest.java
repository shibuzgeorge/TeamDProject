package com.kainos;

import com.kainos.ea.BandFiles.Band;
import com.kainos.ea.CompetencyFiles.Competency;
import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.api.Assertions;

public class BandTest {

    @ParameterizedTest
    @CsvSource({
            "Principal",
            "Apprentice",
            "Any random band name"
    })
    public void bandSetBandNamePositiveCase(String validBandName) {
        Band validBandInstance = new Band();
        validBandInstance.setBandName(validBandName);

        Assertions.assertEquals(validBandInstance.getBandName(), validBandName);
    }

    @ParameterizedTest
    @CsvSource({
            "Principal",
            "Apprentice",
            "Any random band name"
    })
    public void bandGetBandNamePositiveCase(String validBandName) {
        Band validBandInstance = new Band(validBandName);

        Assertions.assertEquals(validBandInstance.getBandName(), validBandName);
    }

    @ParameterizedTest
    @CsvSource({
            "10",
            "1",
            "123",
            "55"
    })
    public void bandSetIDPositiveCase(Integer validID){
        Band validBandInstance = new Band("Principal");
        validBandInstance.setBandID(validID);

        Assertions.assertEquals(validBandInstance.getBandID(), validID);
    }

    @ParameterizedTest
    @CsvSource({
            "-1",
            "0",
            "-1203",
            "16777216"
    })
    public void bandSetIDWhenIDIsIllegalExceptIAE(Integer invalidID){
        Band validBandInstance = new Band("Principal");

        Assertions.assertThrows(IllegalArgumentException.class, ()->{
            validBandInstance.setBandID(invalidID);
        });
    }

    @ParameterizedTest
    @CsvSource({
            "Senior Associate"
    })
    public void bandToStringPositiveCase(String validBandName){
        Band validBandInstance = new Band(validBandName);
        validBandInstance.setBandID(5);

        String expectedReturn =
                "Band{" +
                "bandID=" + 5 +
                ", bandName='" + validBandName + '\'' +
                '}';

        Assertions.assertEquals(validBandInstance.toString(), expectedReturn);
    }


}
