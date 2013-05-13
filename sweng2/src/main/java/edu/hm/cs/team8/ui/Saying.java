package edu.hm.cs.team8.ui;

import edu.hm.cs.team8.timetrackingmangement.datamodel.Member;

public class Saying {
	private final long id;
	private final String content;
	private final Member member;

	public Saying(long id, String content) {
		this.id = id;
		this.content = content;
		member = new Member(0, "k", 1);
	}

	public long getId() {
		return id;
	}

	public String getContent() {
		return content;
	}

	public Member getMember() {
		return member;
	}
}