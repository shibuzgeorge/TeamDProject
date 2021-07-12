package com.kainos.ea.responsibility;

import org.jdbi.v3.sqlobject.statement.SqlQuery;

public interface ResponsibilityDAO {

    @SqlQuery("select responsibility from Responsibility where roleID = :id")
//    String getResponsibility(@Bind("id") int id);
      String getResponsibility();
}
