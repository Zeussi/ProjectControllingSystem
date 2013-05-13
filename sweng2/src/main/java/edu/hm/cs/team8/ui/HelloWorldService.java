package edu.hm.cs.team8.ui;

import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;
import com.yammer.dropwizard.views.ViewBundle;

import edu.hm.cs.team8.masterdata.impl.MasterDataImpl;

public class HelloWorldService extends Service<HelloWorldConfiguration> {
	public static void main(String[] args) throws Exception {
		new HelloWorldService().run(args);
	}

	@Override
	public void initialize(Bootstrap<HelloWorldConfiguration> bootstrap) {
		bootstrap.setName("hello-world");
		bootstrap.addBundle(new ViewBundle());
	}

	@Override
	public void run(HelloWorldConfiguration configuration, Environment environment) {
		final String template = configuration.getTemplate();
		final String defaultName = configuration.getDefaultName();
		environment.addResource(new HelloWorldResource(template, defaultName));
		environment.addResource(new PersonResource());

		try {
			environment.addResource(new MasterDataResource(new MasterDataImpl()));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}