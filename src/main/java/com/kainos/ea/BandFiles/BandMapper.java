package com.kainos.ea.BandFiles;

import com.kainos.ea.RoleFiles.Role;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BandMapper implements RowMapper<Band>{
    private static final String ID = "bandID";
    private static final String NAME = "bandName";

    @Override
    public Band map(ResultSet rs, StatementContext ctx) throws SQLException {
        Band band = new Band(rs.getString(NAME));
        band.setBandID(rs.getInt(ID));
        System.out.println(band);
        return band;
    }

}
