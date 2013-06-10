package edu.hm.cs.team8.filter;

import java.lang.reflect.Constructor;

public class FilterFactory {

	public static IFilter makeFilter(String name, String value) {

		final String className = FilterFactory.class.getPackage() + ".impl"
				+ name;
		IFilter result;

		try {
			final Class<?> clasz = Class.forName(className);

			Constructor<?> cons = clasz.getConstructor(String.class);

			result = (IFilter) cons.newInstance(value);

		} catch (ReflectiveOperationException e) {
			result = null;
		}
		return result;
	}

}
