package com.kainos.ea.JobFamily;

import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.statement.SqlQuery;

import java.util.List;

@RegisterRowMapper(JobFamilyMapper.class)
public interface JobFamilyDAO {

    @SqlQuery("select * from JobFamilyFull;")
    List<JobFamily> getJobFamilies();

}
