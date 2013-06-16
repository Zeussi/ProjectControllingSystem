package edu.hm.cs.team8.keyfiguresCalculator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.skife.jdbi.v2.DBI;
import org.skife.jdbi.v2.Handle;

import edu.hm.cs.team8.keyfiguresCalculator.to.DiagramResult;
import edu.hm.cs.team8.keyfiguresCalculator.to.FilterTO;
import edu.hm.cs.team8.timetrackingmangement.ITimeTrackingMangement;
import edu.hm.cs.team8.timetrackingmangement.TimeTrackingManagementFactory;

public class KeyFigureCalculatorTest {

	private ITimeTrackingMangement tmangm;

	private IKeyFiguresCalculator calc;

	@Before
	public void setUp() throws ClassNotFoundException {
		Class.forName("org.apache.hadoop.hive.jdbc.HiveDriver");
		final DBI dbi = new DBI("jdbc:hive://194.97.152.47:10000/default", "",
				"");
		final Handle handle = dbi.open();
		tmangm = TimeTrackingManagementFactory
				.makeTimeTrackingManagement(handle);

		calc = KeyFiguresCalculatorFactory.makeKeyFiguresCalculator(tmangm);

	}

	@Test
	public void testTimeBehaviour() {
		DiagramResult diagram = calc
				.calculateTimeBehaviourFigure("PERFORMANCE", new FilterTO(
						"MemberFilter", "Elvira Seidel"));

		Assert.assertEquals(diagram.getValuesX().get(0), "01-2013");
		Assert.assertEquals(diagram.getValuesY().get(0), "9.5");
		
		Assert.assertEquals(diagram.getValuesX().get(1), "02-2013");
		Assert.assertEquals(diagram.getValuesY().get(1), "1.5");
		
		Assert.assertEquals(diagram.getValuesX().get(2), "03-2013");
		Assert.assertEquals(diagram.getValuesY().get(2), "8.0");
		
	}
}
