package com.kainos;
import com.kainos.ea.CompetencyFiles.Competency;
import com.kainos.ea.RoleFiles.Role;
import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.api.Assertions;

public class CompetencyTest {

    @ParameterizedTest
    @CsvSource({
            "Working with Others, Description",
            "Working with Others, Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas dapibus id enim vulputate faucibus. Sed eget ex ante. Nam a elementum nibh. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Pellentesque luctus fermentum iaculis. Vivamus vestibulum mauris id leo elementum, lacinia mollis diam consequat. Aliquam sagittis libero consectetur leo facilisis, a pulvinar nibh congue. Phasellus quis facilisis felis, in sagittis magna. Aliquam erat volutpat. Vestibulum blandit, quam aliquam lobortis euismod, tellus diam tincidunt orci, vel lobortis ligula magna at lorem. Ut dolor arcu, imperdiet a sapien ut, vulputate malesuada felis. Sed in sem sapien. Cras bibendum iaculis lorem, in scelerisque orci dictum at. Nulla dictum tincidunt neque, eu efficitur neque consequat quis. Integer fringilla aliquam tincidunt.",
            "Working with Others, 3",
            "Working with Others, "
    })
    public void competencySetCompetencyDescriptionPositiveCase(String validCompName, String validDescription) {
        Competency validCompetencyInstance = new Competency(validCompName, validDescription);
        validCompetencyInstance.setDescription(validDescription);

        Assertions.assertEquals(validCompetencyInstance.getDescription(), validDescription);
    }

    @ParameterizedTest
    @CsvSource({
            "Apprentice, Description",
            "Manager, Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas dapibus id enim vulputate faucibus. Sed eget ex ante. Nam a elementum nibh. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Pellentesque luctus fermentum iaculis. Vivamus vestibulum mauris id leo elementum, lacinia mollis diam consequat. Aliquam sagittis libero consectetur leo facilisis, a pulvinar nibh congue. Phasellus quis facilisis felis, in sagittis magna. Aliquam erat volutpat. Vestibulum blandit, quam aliquam lobortis euismod, tellus diam tincidunt orci, vel lobortis ligula magna at lorem. Ut dolor arcu, imperdiet a sapien ut, vulputate malesuada felis. Sed in sem sapien. Cras bibendum iaculis lorem, in scelerisque orci dictum at. Nulla dictum tincidunt neque, eu efficitur neque consequat quis. Integer fringilla aliquam tincidunt.",
            "Principal , 3",
            "Senior Associate, "
    })
    public void competencyGetCompetencyDescriptionPositiveCase(String validCompName, String validDesc) {
        Competency validCompetencyInstance = new Competency(validCompName, validDesc);

        Assertions.assertEquals(validCompetencyInstance.getDescription(), validDesc);
    }

    @ParameterizedTest
    @CsvSource({
            "Working With Others",
            "Personal Performance",
            "Communicating and Influence",
            "Personal Performance"
    })
    public void competencySetCompetencyNamePositveCase(String validCompetencyName){
        Competency validCompetencyInstance = new Competency(1);
        validCompetencyInstance.setCompName(validCompetencyName);

        Assertions.assertEquals(validCompetencyInstance.getCompName(), validCompetencyName);
    }


    @ParameterizedTest
    @CsvSource({
            "Working With Others",
            "Personal Performance",
            "Communicating and Influence",
            "Personal Performance"
    })
    public void competencyGetCompetencyNamePositveCase(String validCompetencyName){
        Competency validCompetencyInstance = new Competency(validCompetencyName, 1);

        Assertions.assertEquals(validCompetencyInstance.getCompName(), validCompetencyName);
    }


    @ParameterizedTest
    @CsvSource({
            "10",
            "1",
            "123",
            "55"
    })
    public void competencySetIDPositiveCase(Integer validID){
        Competency validCompetencyInstance = new Competency("Working with Others", 1);
        validCompetencyInstance.setCompID(validID);

        Assertions.assertEquals(validCompetencyInstance.getCompID(), validID);
    }

    @ParameterizedTest
    @CsvSource({
            "-1",
            "0",
            "-1203",
            "16777216"
    })
    public void competencySetIDWhenIDIsIllegalExceptIAE(Integer invalidID){
        Competency validCompetencyInstance = new Competency("Working with Others", 1);

        Assertions.assertThrows(IllegalArgumentException.class, ()->{
            validCompetencyInstance.setCompID(invalidID);
        });
    }

    @ParameterizedTest
    @CsvSource({
            "Personal Performance, 7, Hello World"
    })
    public void competencyToStringPositiveCase(String validCompName, Integer validBandID, String validDescription){
        Competency validCompetencyInstance = new Competency(validCompName, validBandID, validDescription);
        validCompetencyInstance.setCompID(1);

        String expectedReturn = "Competency{" +
                "compID=" + 1 +
                ", compName='" + validCompName + '\'' +
                ", bandID=" + validBandID +
                ", description='" + validDescription + '\'' +
                '}';

        Assertions.assertEquals(validCompetencyInstance.toString(), expectedReturn);
    }

}
