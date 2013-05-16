package edu.hm.cs.team8.keyfiguresCalculator;

import java.util.Set;

import org.skife.jdbi.v2.Handle;

import edu.hm.cs.team8.filter.IFilter;
import edu.hm.cs.team8.keyfiguresCalculator.keyfigure.result.KeyFigureResult;

public interface IKeyFiguresCalculator {

	Set<KeyFigureResult> calculateFigures(Handle handle, IFilter... filters);
}
