package edu.hm.cs.team8.ui;

import java.util.Set;

import com.yammer.dropwizard.views.View;
import edu.hm.cs.team8.masterdata.datamodel.Member;


public class MemberView extends View{
	private final Set<Member> members;

	public MemberView(Set<Member> members) {
		super("memberJSON.ftl");
		this.members = members;
	}

	public Set<Member> getMembers() {
		return members;
	}
}
