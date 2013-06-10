package edu.hm.cs.team8.keyfiguresCalculator;

import java.util.Set;

import edu.hm.cs.team8.keyfiguresCalculator.to.DiagramResult;
import edu.hm.cs.team8.keyfiguresCalculator.to.FilterTO;
import edu.hm.cs.team8.keyfiguresCalculator.to.KeyFigureTableEntry;

public interface IKeyFiguresCalculator {

	Set<KeyFigureTableEntry> calculateOnlyFigures(FilterTO... filters);
	
	DiagramResult calculateTimeBehaviourFiguresForPerformance(FilterTO... filters);
}
