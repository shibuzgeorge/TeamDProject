package com.kainos.ea.Capability;

import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import java.util.List;

@RegisterRowMapper(CapabilityMapper.class)
public interface CapabilityDAO {

    @SqlQuery("select * FROM Capability;")
    List<Capability> getCapability();
}
