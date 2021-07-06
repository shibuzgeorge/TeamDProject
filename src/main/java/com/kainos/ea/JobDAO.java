package com.kainos.ea;

import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.statement.SqlQuery;

import java.util.List;

@RegisterRowMapper(JobMapper.class)
public interface JobDAO {

    @SqlQuery("select * from job;")
        public List<Job> getJobs();
}
