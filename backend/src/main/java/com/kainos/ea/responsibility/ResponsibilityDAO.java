package com.kainos.ea.responsibility;

import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import java.util.List;

@RegisterRowMapper(ResponsibilityMapper.class)
public interface ResponsibilityDAO {

    @SqlQuery("select * FROM Responsibility where roleID = :id")
    Responsibility getResponsibility(@Bind("id") int id);
}
