package com.kainos;
import com.kainos.ea.Role;
import junit.framework.AssertionFailedError;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.api.Assertions;

import static junit.framework.TestCase.*;


public class RoleTest {
    @ParameterizedTest
    @CsvSource({
            "Software Engineer, Engineering",
            "Software Engineer, Engineering",
            "Software Engineer, Engineering",
            "Software Engineer, Engineering"
    })
    public void roleGetRolePositveCase(String validRole, String validCapability){
        Role validRoleInstance = new Role(validRole, validCapability);

        assertEquals(validRoleInstance.getRole(), validRole);
    }

    @ParameterizedTest
    @CsvSource({
            "Software Engineer, Engineering",
            "Software Engineer, Engineering",
            "Software Engineer, Engineering",
            "Software Engineer, Engineering"
    })
    public void roleGetCapabilityPositveCase(String validRole, String validCapability){
        Role validRoleInstance = new Role(validRole, validCapability);

        assertEquals(validRoleInstance.getCapability(), validCapability);
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
        validRoleInstance.setId(validID);

        assertEquals(validRoleInstance.getId(), validID);
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
            validRoleInstance.setId(invalidID);
        });
    }

}
