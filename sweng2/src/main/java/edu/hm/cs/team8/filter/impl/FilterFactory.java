package edu.hm.cs.team8.filter.impl;

import java.util.Set;

import edu.hm.cs.team8.filter.IFilter;
import edu.hm.cs.team8.filter.impl.memberfilter.MemberFilter;
import edu.hm.cs.team8.filter.impl.organisationfilter.BusinessAreaFilter;
import edu.hm.cs.team8.filter.impl.timefilter.TimeFilter;
import edu.hm.cs.team8.timetrackingmangement.datamodel.TimeTrackingEntry;

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