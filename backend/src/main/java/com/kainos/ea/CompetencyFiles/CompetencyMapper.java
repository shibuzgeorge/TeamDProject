package com.kainos.ea.CompetencyFiles;

import com.kainos.ea.RoleFiles.Role;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CompetencyMapper implements RowMapper<Competency> {

    private static final String ID = "competencyID";
    private static final String NAME = "competencyName";
    private static final String BAND_ID = "bandID";
    private static final String DESCRIPTION = "description";

    @Override
    public Competency map(ResultSet rs, StatementContext ctx) throws SQLException {
        Competency competency = new Competency(rs.getString(NAME), rs.getString(DESCRIPTION));
        competency.setCompID(rs.getInt(ID));
        competency.setBandID(rs.getInt(BAND_ID));
        return competency;
    }
}
