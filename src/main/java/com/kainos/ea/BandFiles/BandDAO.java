package com.kainos.ea.BandFiles;

import com.kainos.ea.BandFiles.BandMapper;
import com.kainos.ea.RoleFiles.Role;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.statement.SqlQuery;

import java.util.List;

@RegisterRowMapper(BandMapper.class)

public interface BandDAO {
    @SqlQuery("select * from Band;")
    public List<Band> getBands();
}
