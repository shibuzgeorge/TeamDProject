package com.kainos;
import com.kainos.ea.Role;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.api.Assertions;


public class RoleTest {
    @ParameterizedTest
    @CsvSource({
            "Software Engineer, 10",
            "Software Engineer, 12",
            "Software Engineer, 13",
            "Software Engineer, 14"
    })
    public void roleGetRolePositveCase(String validRole, Integer validCapabilityID){
        Role validRoleInstance = new Role(validRole, validCapabilityID);

        Assertions.assertEquals(validRoleInstance.getRole(), validRole);
    }


    @ParameterizedTest
    @CsvSource({
            "10",
            "12",
            "13",
            "14"
    })
    public void roleSetCapabilityIDPositveCase(Integer validCapabilityID){
        Role validRoleInstance = new Role("Software Engineer");
        validRoleInstance.setCapabilityID(validCapabilityID);

        Assertions.assertEquals(validRoleInstance.getCapabilityID(), validCapabilityID);
    }


    @ParameterizedTest
    @CsvSource({
            "-10",
            "0",
            "-1203",
            "16777216"
    })
    public void roleSetCapabilityIDInvalidIntegerExceptIAE( Integer validCapabilityID){
        Role validRoleInstance = new Role("Software Engineer");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            validRoleInstance.setCapabilityID(validCapabilityID);

        });
    }


    @ParameterizedTest
    @CsvSource({
            "Software Engineer, 10",
            "Software Engineer, 12",
            "Software Engineer, 13",
            "Software Engineer, 14"
    })
    public void roleGetCapabilityIDPositveCase(String validRole, Integer validCapabilityID){
        Role validRoleInstance = new Role(validRole, validCapabilityID);

        Assertions.assertEquals(validRoleInstance.getCapabilityID(), validCapabilityID);
    }


    @ParameterizedTest
    @CsvSource({
            "10",
            "1",
            "123",
            "55"
    })
    public void roleSetIDPositveCase(Integer validID){
        Role validRoleInstance = new Role("Software Engineer", 1);
        validRoleInstance.setId(validID);

        Assertions.assertEquals(validRoleInstance.getId(), validID);
    }


    @ParameterizedTest
    @CsvSource({
            "-10",
            "0",
            "-1203",
            "16777216"
    })
    public void roleSetIDWhenIDIsIllegalExceptIAE(Integer invalidID){
        Role validRoleInstance = new Role("Software Engineer", 1);

        Assertions.assertThrows(IllegalArgumentException.class, ()->{
            validRoleInstance.setId(invalidID);
        });
    }


    @ParameterizedTest
    @CsvSource({
            "Software Engineer, 10, 10"
    })
    public void roleToStringPositiveCase(String validRole, Integer validCapabilityID, Integer validID){
        Role validRoleInstance = new Role(validRole, validCapabilityID);
        validRoleInstance.setId(validID);

        String expectedReturn = "Role{" +
                "id=" + validID +
                ", role='" + validRole + '\'' +
                ", capability='" + validCapabilityID + '\'' +
                '}';

        Assertions.assertEquals(validRoleInstance.toString(), expectedReturn);
    }
}