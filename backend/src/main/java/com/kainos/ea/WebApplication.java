package com.kainos.ea;

import com.kainos.ea.Capability.CapabilityDAO;
import com.kainos.ea.Capability.CapabilityResource;
import com.kainos.ea.CompetencyFiles.Competency;
import com.kainos.ea.CompetencyFiles.CompetencyDAO;
import com.kainos.ea.CompetencyFiles.CompetencyResource;
import com.kainos.ea.capabilitylead.CapabilityLeadDAO;
import com.kainos.ea.capabilitylead.CapabilityLeadResource;
import com.kainos.ea.RoleFiles.RoleDAO;
import com.kainos.ea.RoleFiles.RoleResource;
import com.kainos.ea.BandFiles.BandDAO;
import com.kainos.ea.BandFiles.BandResource;
import com.kainos.ea.employee.EmployeeDAO;
import com.kainos.ea.employee.EmployeeResource;
import com.kainos.ea.responsibility.ResponsibilityDAO;
import com.kainos.ea.responsibility.ResponsibilityResource;
import io.dropwizard.Application;
import io.dropwizard.configuration.EnvironmentVariableSubstitutor;
import io.dropwizard.configuration.SubstitutingSourceProvider;
import io.dropwizard.jdbi3.JdbiFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.jdbi.v3.core.Jdbi;

public class WebApplication extends Application<WebApplicationConfiguration> {

    public static void main(final String[] args) throws Exception {
        new WebApplication().run(args);
    }

    @Override
    public void initialize(final Bootstrap<WebApplicationConfiguration> bootstrap) {
        bootstrap.setConfigurationSourceProvider(
                new SubstitutingSourceProvider(bootstrap.getConfigurationSourceProvider(),
                        new EnvironmentVariableSubstitutor(false))
        );
    }

    @Override
    public void run(final WebApplicationConfiguration configuration,
                    final Environment environment) {
        final JdbiFactory factory = new JdbiFactory();
        final Jdbi jdbi = factory.build(environment, configuration.getDataSourceFactory(), "mysql");
        final RoleDAO roleDAO = jdbi.onDemand(RoleDAO.class);
        final BandDAO bandDAO = jdbi.onDemand(BandDAO.class);
        final CompetencyDAO competencyDAO = jdbi.onDemand(CompetencyDAO.class);
        final CapabilityLeadDAO capabilityLeadDAO = jdbi.onDemand(CapabilityLeadDAO.class);
        final EmployeeDAO employeeDAO = jdbi.onDemand(EmployeeDAO.class);
        final ResponsibilityDAO responsibilityDAO = jdbi.onDemand(ResponsibilityDAO.class);
        final CapabilityDAO capabilityDAO = jdbi.onDemand(CapabilityDAO.class);
        environment.jersey().register(new RoleResource(roleDAO));
        environment.jersey().register(new BandResource(bandDAO));
        environment.jersey().register(new CompetencyResource(competencyDAO));
        environment.jersey().register(new CapabilityLeadResource(capabilityLeadDAO));
        environment.jersey().register(new EmployeeResource(employeeDAO));
        environment.jersey().register(new ResponsibilityResource(responsibilityDAO));
        environment.jersey().register(new CapabilityResource(capabilityDAO));
    }
}
