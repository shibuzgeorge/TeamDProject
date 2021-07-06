package com.kainos.ea;

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
        final JobDAO dao = jdbi.onDemand(JobDAO.class);
        environment.jersey().register(new JobResource(dao));
    }

}
