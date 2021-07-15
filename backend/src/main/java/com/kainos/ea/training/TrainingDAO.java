package com.kainos.ea.training;

import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;

import java.util.List;

@RegisterRowMapper(TrainingMapper.class)
public interface TrainingDAO {

    @SqlQuery("select * from TrainingByBand;")
    public List<Training> getTrainings();

    @SqlQuery("SELECT * FROM TrainingByBand T WHERE T.bandID = :id;")
    public List<Training> getTrainingByBandID(@Bind("id") int id);
}
