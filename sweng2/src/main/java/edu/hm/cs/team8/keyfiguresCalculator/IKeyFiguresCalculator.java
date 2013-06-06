package edu.hm.cs.team8.keyfiguresCalculator;

import java.util.Set;

import edu.hm.cs.team8.filter.IFilter;
import edu.hm.cs.team8.keyfiguresCalculator.to.KeyFigureResult;
import edu.hm.cs.team8.keyfiguresCalculator.to.TimeBehaviourKeyFigureResult;

public interface IKeyFiguresCalculator {

	Set<KeyFigureResult> calculateOnlyFigures(IFilter... filters);
	
	Set<TimeBehaviourKeyFigureResult> calculateTimeBehaviourFigures(IFilter... filters);
}
