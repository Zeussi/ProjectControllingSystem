package edu.hm.cs.team8.filter;

import edu.hm.cs.team8.filter.dto.Compare;
import edu.hm.cs.team8.filter.dto.Filter;
import edu.hm.cs.team8.filter.memberfilter.MemberFilterFactory;

public class Main {

	public static void main(String[] args) {
		Filter filter = MemberFilterFactory.makeMemberFilter(2, Compare.EQUALS);
		
		System.out.println(filter.apply());
	}
}
