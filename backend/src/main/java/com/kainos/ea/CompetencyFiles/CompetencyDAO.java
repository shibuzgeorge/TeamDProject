package com.kainos.ea.CompetencyFiles;

import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.statement.SqlQuery;

import java.util.List;

@RegisterRowMapper(CompetencyMapper.class)
public interface CompetencyDAO {

    @SqlQuery("SELECT * FROM Competency") //TODO add WHERE clause
    public List<Competency> getCompetencies();

}
