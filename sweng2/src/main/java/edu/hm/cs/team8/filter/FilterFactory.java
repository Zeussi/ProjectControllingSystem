package edu.hm.cs.team8.filter;

import edu.hm.cs.team8.filter.impl.AccountFilter;
import edu.hm.cs.team8.filter.impl.BusinessAreaFilter;
import edu.hm.cs.team8.filter.impl.MemberFilter;
import edu.hm.cs.team8.filter.impl.ProjectFilter;
import edu.hm.cs.team8.filter.impl.TimeFilter;

public class FilterFactory {

	public static IFilter makeFilter(String name, String value) {

		final IFilter result;

		switch (name) {
		case "MemberFilter":
			result = new MemberFilter(value);
			break;

		case "AccountFilter":
			result = new AccountFilter(value);
			break;
		case "BusinessareaFilter":
			result = new BusinessAreaFilter(value);
			break;

		case "ProjectFilter":
			result = new ProjectFilter(value);
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
