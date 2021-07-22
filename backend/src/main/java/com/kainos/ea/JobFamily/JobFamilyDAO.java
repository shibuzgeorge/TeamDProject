package com.kainos.ea.JobFamily;

import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import javax.ws.rs.FormParam;
import java.util.List;

@RegisterRowMapper(JobFamilyMapper.class)
public interface JobFamilyDAO {

    @SqlQuery("select * from JobFamilyFull;")
    List<JobFamily> getJobFamilies();

    @SqlQuery("SELECT * FROM JobFamilyFull R WHERE R.capabilityName = :capability;")
    List<JobFamily> getJobFamilyByCapability(@Bind("capability") String capability);

    @SqlQuery("SELECT * FROM JobFamilyFull R WHERE R.jobFamilyID = :id;")
    JobFamily getJobFamilyByID(@Bind("id") int id);

    @SqlUpdate("INSERT INTO JobFamily (capabilityID, jobFamilyName) VALUES ((SELECT capabilityID FROM Capability WHERE capabilityName = :capability), :jobFamilyName);")
    boolean insertNewJobFamily(@Bind("jobFamilyName") String jobFamilyName, @Bind("capability") String capability);

    @SqlQuery("SELECT * FROM JobFamilyFull WHERE jobFamilyName = :jobFamilyName AND capabilityName = :capability;")
    JobFamily checkIfJobFamilyNameAndCapabilityComboExist(@Bind("jobFamilyName") String jobFamilyName, @Bind("capability") String capability);

    @SqlUpdate("UPDATE JobFamily SET jobFamilyName = :jobFamilyName WHERE jobFamilyID = :id;")
    boolean editJobFamilyName(@Bind("jobFamilyName") String jobFamilyName, @Bind("id") int id);

    @SqlUpdate("UPDATE JobFamily SET capabilityID = (SELECT capabilityID FROM Capability WHERE capabilityName = :capability) WHERE jobFamilyID = :id;")
    boolean editJobFamilyCapability(@Bind("capability") String capability, @Bind("id") int id);
}
