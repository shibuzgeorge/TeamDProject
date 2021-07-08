package com.kainos;
import com.kainos.ea.RoleFiles.Role;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.api.Assertions;


public class RoleTest {
    @ParameterizedTest
    @CsvSource({
            "Software Engineer, Engineering",
            "Software Engineer, People",
            "Security Engineer, Cyber Security",
            "Data Consultant, Workday"
    })
    public void roleGetRolePositveCase(String validRole, String validCapability){
        Role validRoleInstance = new Role(validRole, validCapability);

        Assertions.assertEquals(validRoleInstance.getRoleName(), validRole);
    }


    @ParameterizedTest
    @CsvSource({
            "Engineering",
            "People",
            "Cyber Security",
            "Workday"
    })
    public void roleSetCapabilityPositveCase(String validCapability){
        Role validRoleInstance = new Role("Software Engineer");
        validRoleInstance.setCapability(validCapability);

        Assertions.assertEquals(validRoleInstance.getCapability(), validCapability);
    }

    @ParameterizedTest
    @CsvSource({
            "Software Engineer, Engineering",
            "Software Engineer, People",
            "Security Engineer, Cyber Security",
            "Data Consultant, Workday"
    })
    public void roleGetCapabilityPositveCase(String validRole, String validCapability){
        Role validRoleInstance = new Role(validRole, validCapability);

        Assertions.assertEquals(validRoleInstance.getCapability(), validCapability);
    }


    @ParameterizedTest
    @CsvSource({
            "10",
            "1",
            "123",
            "55"
    })
    public void roleSetIDPositveCase(Integer validID){
        Role validRoleInstance = new Role("Software Engineer", "Engineering");
        validRoleInstance.setRoleID(validID);

        Assertions.assertEquals(validRoleInstance.getRoleID(), validID);
    }


    @ParameterizedTest
    @CsvSource({
            "-10",
            "0",
            "-1203",
            "16777216"
    })
    public void roleSetIDWhenIDIsIllegalExceptIAE(Integer invalidID){
        Role validRoleInstance = new Role("Software Engineer", "Engineering");

        Assertions.assertThrows(IllegalArgumentException.class, ()->{
            validRoleInstance.setRoleID(invalidID);
        });
    }


    @ParameterizedTest
    @CsvSource({
            "Software Engineer, 10, 10"
    })
    public void roleToStringPositiveCase(String validRole, String validCapabilityID, Integer validID){
        Role validRoleInstance = new Role(validRole, validCapabilityID);
        validRoleInstance.setRoleID(validID);

        String expectedReturn = "Role{" +
                "roleId=" + validID +
                ", roleName='" + validRole + '\'' +
                ", capability='" + validCapabilityID + '\'' +
                '}';

        Assertions.assertEquals(validRoleInstance.toString(), expectedReturn);
    }
}