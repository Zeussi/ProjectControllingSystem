package edu.hm.cs.team8.dropwizard;

import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.assets.AssetsBundle;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;

public class HelloWorldService extends Service<HelloWorldConfiguration> {
	public static void main(String[] args) throws Exception {
		new HelloWorldService().run(args);
	}

	@Override
	public void initialize(Bootstrap<HelloWorldConfiguration> bootstrap) {
		bootstrap.setName("hello-world");
	    bootstrap.addBundle(new AssetsBundle());
	}

	@Override
	public void run(HelloWorldConfiguration configuration,
	                Environment environment) {
	    final String template = configuration.getTemplate();
	    final String defaultName = configuration.getDefaultName();
	    environment.addResource(new HelloWorldResource(template, defaultName));
	}

}