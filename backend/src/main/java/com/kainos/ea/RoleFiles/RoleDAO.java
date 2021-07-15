package com.kainos.ea.RoleFiles;

import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;

import java.util.List;

@RegisterRowMapper(RoleMapper.class)
public interface RoleDAO {

    @SqlQuery("select * from RoleListWithID;")
    public List<Role> getRoles();

    @SqlQuery("SELECT * FROM RoleListWithID R WHERE R.roleID = :id;")
    public Role getRoleByID(@Bind("id") int id);

    @SqlQuery("SELECT * FROM RoleListWithID R WHERE R.capabilityName = :capability;")
    public List<Role> getRoleByCapability(@Bind("capability") String capability);
}
