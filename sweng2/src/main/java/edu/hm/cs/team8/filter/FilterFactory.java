package edu.hm.cs.team8.filter;

import edu.hm.cs.team8.filter.impl.memberfilter.MemberFilter;
import edu.hm.cs.team8.filter.impl.organisationfilter.BusinessAreaFilter;
import edu.hm.cs.team8.filter.impl.timefilter.TimeFilter;

public class FilterFactory {

	public static IFilter makeFilter(String name, String value) {

		final IFilter result;

		switch (name) {
		case "MemberFilter":
			result = new MemberFilter(value);
			break;
		case "BusinessareaFilter":
			result = new BusinessAreaFilter(value);
			break;
		case "TimeFilter":
			result = new TimeFilter(value);
			break;
		default:
			result = null;
		}
		return result;
	}

}
