package com.pinot.central;

import com.pinot.central.resource.OpenTracingResource;
import io.dropwizard.Application;
import io.dropwizard.configuration.EnvironmentVariableSubstitutor;
import io.dropwizard.configuration.ResourceConfigurationSourceProvider;
import io.dropwizard.configuration.SubstitutingSourceProvider;
import io.dropwizard.forms.MultiPartBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import ru.vyarus.dropwizard.guice.GuiceBundle;

/**
 * @author ankush.nakaskar
 */
public class OpenTracingApp extends Application<BasicConfiguration> {

    protected GuiceBundle guiceBundle;

    public static void main(final String[] args) throws Exception {
        new OpenTracingApp().run("server", "application.yml");
    }

    @Override
    public void run(final BasicConfiguration basicConfiguration,
                    final Environment environment) {
        environment.jersey().register(new OpenTracingResource());

    }

    @Override
    public void initialize(final Bootstrap<BasicConfiguration> bootstrap) {

        bootstrap.setConfigurationSourceProvider(
                new SubstitutingSourceProvider(bootstrap.getConfigurationSourceProvider(),
                        new EnvironmentVariableSubstitutor()));

        bootstrap.addBundle(new MultiPartBundle());
        bootstrap.setConfigurationSourceProvider(new ResourceConfigurationSourceProvider());

        super.initialize(bootstrap);
    }


}
