package edu.hm.cs.team8.keyfiguresCalculator;

import edu.hm.cs.team8.keyfiguresCalculator.impl.KeyFiguresCalculatorImpl;
import edu.hm.cs.team8.timetrackingmangement.ITimeTrackingMangement;

public class KeyFiguresCalculatorFactory {

	private static IKeyFiguresCalculator keyFiguresCalculator;
	
	public static IKeyFiguresCalculator makeKeyFiguresCalculator(ITimeTrackingMangement management)
	{
		if(keyFiguresCalculator == null)
			keyFiguresCalculator = new KeyFiguresCalculatorImpl(management);
		
		return keyFiguresCalculator;
	}
	
}
