package edu.hm.cs.team8.keyfiguresCalculator;

import java.util.Set;

import edu.hm.cs.team8.filter.IFilter;
import edu.hm.cs.team8.keyfiguresCalculator.keyfigure.result.KeyFigureResult;

public interface IKeyFiguresCalculator {

	Set<KeyFigureResult> calculateOnlyFigures(IFilter... filters);
	
	Set<KeyFigureResult> calculateTimeBehaviourFigures(IFilter... filters);
}
