package com.kainos.ea.JobFamily;

import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;

@RegisterRowMapper(JobFamilyMapper.class)
public interface JobFamilyDAO {

    @SqlQuery("select * from JobFamilyFull;")
    List<JobFamily> getJobFamilies();

    @SqlQuery("SELECT * FROM JobFamilyFull R WHERE R.capabilityName = :capability;")
    List<JobFamily> getJobFamilyByCapability(@Bind("capability") String capability);

    @SqlUpdate("INSERT INTO JobFamily (capabilityID, jobFamilyName) VALUES ((SELECT capabilityID FROM Capability WHERE capabilityName = :capability), :jobFamilyName);")
    boolean insertNewJobFamily(@Bind("jobFamilyName") String jobFamilyName, @Bind("capability") String capability);

}
