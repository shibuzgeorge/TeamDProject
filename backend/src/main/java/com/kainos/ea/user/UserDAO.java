package com.kainos.ea.user;

import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;

import java.util.List;

@RegisterRowMapper(UserMapper.class)
public interface UserDAO {

    @SqlQuery("select * from `User`;")
    public List<User> getUsers();

    @SqlQuery("select * from `User` where username = :username")
    public User getUser(@Bind("username") String username);

    @SqlQuery("select password from `User` where username = :username")
    public String getHashedPassword(@Bind("username") String username);

    @SqlQuery("select role from `User` where username = :username")
    public String getRole(@Bind("username") String username);

}