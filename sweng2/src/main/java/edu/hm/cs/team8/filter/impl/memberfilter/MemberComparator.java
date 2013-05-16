package edu.hm.cs.team8.filter.impl.memberfilter;

import edu.hm.cs.team8.filter.impl.Option;
import edu.hm.cs.team8.timetrackingmangement.datamodel.Member;

public class MemberComparator {

	public static boolean compare(final Member member, final long memberId, Option option) {

		boolean result = false;

		switch (option) {
		case EQUALS:
			result = member.getmId() == memberId;
			break;

		case BIGGER:
			result = member.getmId() > memberId;
			break;

		case BIGGER_OR_EQUALS:
			result = member.getmId() >= memberId;
			break;

		case LESS:
			result = member.getmId() < memberId;
			break;

		case LESS_OR_EQUALS:
			result = member.getmId() >= memberId;
			break;

		default:
			break;
		}

		return result;
	}
}
