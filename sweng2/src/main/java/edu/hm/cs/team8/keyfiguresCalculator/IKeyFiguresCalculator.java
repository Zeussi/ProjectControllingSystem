package edu.hm.cs.team8.keyfiguresCalculator;

import java.util.Map;

import edu.hm.cs.team8.keyfiguresCalculator.keyfigure.KeyFigures;
import edu.hm.cs.team8.keyfiguresCalculator.keyfigure.value.KeyFigureValue;

public interface IKeyFiguresCalculator {

	Map<KeyFigures, KeyFigureValue> calculateFigures() throws ClassNotFoundException;
}
