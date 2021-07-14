package com.kainos;
import com.kainos.ea.CompetencyFiles.Competency;
import com.kainos.ea.RoleFiles.Role;
import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.api.Assertions;

public class CompetencyTest {
    //TODO complete rest of the tests
    @ParameterizedTest
    @CsvSource({
            "1, Description",
            "2, ",
            "-3 , 3"
    })
    public void competencyGetCompetencyDescriptionPositiveCase(Integer validCompID, String validDescription) {
        Competency validCompetencyInstance = new Competency(validCompID, validDescription);

        Assertions.assertEquals(validCompetencyInstance.getDescription(), validDescription);
    }
}
