package com.kainos.ea.user;

import com.kainos.ea.BandFiles.Band;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {

    private static final String ID = "userID";
    private static final String USERNAME = "username";
    private static final String ROLE = "role";

    @Override
    public User map(ResultSet rs, StatementContext ctx) throws SQLException {

            User user = new User(rs.getString(USERNAME), rs.getString(ROLE));
            user.setUserID(rs.getInt(ID));
            System.out.println(user);
            return user;

    }
}
