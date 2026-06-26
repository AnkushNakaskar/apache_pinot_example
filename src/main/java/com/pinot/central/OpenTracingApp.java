package com.pinot.central;

import io.appform.opentracing.TracingManager;
import io.appform.opentracing.TracingOptions;
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
        TracingOptions tracingOptions = new TracingOptions.TracingOptionsBuilder().parameterCaptureEnabled(true)
                .build();
        TracingManager.initialize(tracingOptions);

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
