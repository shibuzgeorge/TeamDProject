package com.kainos.ea.Capability;

import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import java.util.List;

@RegisterRowMapper(CapabilityMapper.class)
public interface CapabilityDAO {

    // Can extend this query, need to add image
    @SqlQuery("select * FROM Capability;")
    List<Capability> getCapability();
}
