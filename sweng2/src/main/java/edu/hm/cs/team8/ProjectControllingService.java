package edu.hm.cs.team8;

import org.skife.jdbi.v2.DBI;
import org.skife.jdbi.v2.Handle;

import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;
import com.yammer.dropwizard.jdbi.DBIFactory;
import com.yammer.dropwizard.views.ViewBundle;

import edu.hm.cs.team8.keyfiguresCalculator.IKeyFiguresCalculator;
import edu.hm.cs.team8.keyfiguresCalculator.KeyFiguresCalculatorFactory;
import edu.hm.cs.team8.keyfiguresCalculator.ui.KeyFigureCalculatorResource;
import edu.hm.cs.team8.timetrackingmangement.ITimeTrackingMangement;
import edu.hm.cs.team8.timetrackingmangement.TimeTrackingManagementFactory;
import edu.hm.cs.team8.timetrackingmangement.ui.TimeTrackingResource;

public class ProjectControllingService extends Service<ProjectControllingConfiguration> {
	public static void main(String[] args) throws Exception {
		new ProjectControllingService().run(args);
	}

	@Override
	public void initialize(Bootstrap<ProjectControllingConfiguration> bootstrap) {
		bootstrap.setName("project-controlling-service");
		bootstrap.addBundle(new ViewBundle());
	}

	@Override
	public void run(ProjectControllingConfiguration configuration, Environment environment)
			throws ClassNotFoundException {

		final DBI dbi = new DBIFactory().build(environment, configuration.getDatabaseConfiguration(), "hiveDB");
		final Handle handle = dbi.open();

		final ITimeTrackingMangement management = TimeTrackingManagementFactory.makeTimeTrackingManagement(handle);
		final IKeyFiguresCalculator calc = KeyFiguresCalculatorFactory.makeKeyFiguresCalculator(management);

		environment.addResource(new TimeTrackingResource(management));
		environment.addResource(new KeyFigureCalculatorResource(calc));

	}

}