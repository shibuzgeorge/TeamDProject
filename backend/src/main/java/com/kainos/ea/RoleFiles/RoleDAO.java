package com.kainos.ea.RoleFiles;

import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;

import java.util.List;

@RegisterRowMapper(RoleMapper.class)
public interface RoleDAO {

    @SqlQuery("select * from RoleListWithID;")
    public List<Role> getRoles();

    @SqlQuery("SELECT R.roleID, R.roleName, C.capabilityName, " +
            "JF.jobFamilyName, B.bandName, R.specification, R.roleSummary " +
            "FROM Role R LEFT JOIN Capability C ON R.capabilityID = C.capabilityID " +
            "LEFT JOIN Band B ON R.bandID = B.bandID LEFT JOIN JobFamily JF ON R.jobFamilyID = " +
            "JF.jobFamilyID WHERE R.roleID = :id;")
    public Role getRoleByID(@Bind("id") int id);
}
