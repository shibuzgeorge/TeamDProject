package com.kainos.ea.RoleFiles;

import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.statement.SqlQuery;

import java.util.List;

@RegisterRowMapper(RoleMapper.class)
public interface RoleDAO {

    @SqlQuery("select * from RoleListWithID limit 1;")
    public List<Role> getRoles();
}
