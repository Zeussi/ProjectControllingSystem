package edu.hm.cs.team8.keyfiguresCalculator.keyfigure;

import org.skife.jdbi.v2.Handle;

import edu.hm.cs.team8.filter.IFilter;
import edu.hm.cs.team8.keyfiguresCalculator.keyfigure.result.KeyFigureResult;

public interface IKeyFigure {

	public KeyFigureResult calculate(KeyFigures keyfigure, Handle dao, final IFilter... filters);
}
