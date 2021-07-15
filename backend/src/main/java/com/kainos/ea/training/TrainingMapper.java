package com.kainos.ea.training;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TrainingMapper implements RowMapper<Training> {
    private static final String TRAINING_ID = "trainingID";
    private static final String TRAINING_NAME = "trainingName";
    private static final String TRAINING_TYPE = "trainingType";
    private static final String TRAINING_LINK = "trainingLink";

    @Override
    public Training map(ResultSet rs, StatementContext ctx) throws SQLException {
        Training training = new Training(rs.getString(TRAINING_NAME), rs.getString(TRAINING_TYPE), rs.getString(TRAINING_LINK));
        training.setTrainingID(rs.getInt(TRAINING_ID));
        return training;
    }
}