package com.kainos.ea.JobFamily;

import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;

import java.util.List;

@RegisterRowMapper(JobFamilyMapper.class)
public interface JobFamilyDAO {

    @SqlQuery("select * from JobFamilyFull;")
    List<JobFamily> getJobFamilies();

    @SqlQuery("SELECT * FROM JobFamilyFull R WHERE R.capabilityName = :capability;")
    public List<JobFamily> getJobFamilyByCapability(@Bind("capability") String capability);
}
