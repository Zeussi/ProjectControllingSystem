package edu.hm.cs.team8.filter.memberfilter;

import edu.hm.cs.team8.filter.dto.Compare;
import edu.hm.cs.team8.filter.dto.Filter;

public class MemberFilterFactory {

	public static Filter makeMemberFilter(String name, final Compare compare) {
		return new MemberFilterName(name, compare);
	}

	public static Filter makeMemberFilter(int level, final Compare compare) {
		return new MemberFilterLevel(level, compare);
	}
}
