package com.kainos.ea.CompetencyFiles;

import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;

import java.util.List;

@RegisterRowMapper(CompetencyMapper.class)
public interface CompetencyDAO {

    @SqlQuery("SELECT * FROM Competency") //TODO add WHERE clause
    public List<Competency> getCompetencies();

    @SqlQuery("SELECT * FROM Competency WHERE competencyID = :id;")

    public Competency getCompetencyByID(@Bind("id") int id);

    //TODO create and add View to get Competencies by BandID

    @SqlQuery("SELECT * FROM Competency WHERE bandID = :id;")
    public List<Competency> getCompetencyByBandID(@Bind("id") int id);



}
