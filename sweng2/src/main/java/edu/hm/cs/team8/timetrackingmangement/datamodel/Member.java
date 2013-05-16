package edu.hm.cs.team8.timetrackingmangement.datamodel;

public class Member {

	private final long mId;

	private final String name;

	private final int level;

	public Member(long mid, String name, int level) {
		mId = mid;
		this.name = name;
		this.level = level;

	}

	public int getLevel() {
		return level;
	}

	public String getName() {
		return name;
	}

	public long getmId() {
		return mId;
	}

	@Override
	public String toString() {
		return String.format("Member Name: %s%nMember ID: %d%nMember Level: %d", getName(), getmId(), getLevel());
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || obj.getClass() != getClass())
			return false;

		final Member that = (Member) obj;

		return that.getLevel() == getLevel() && that.getmId() == getmId() && that.getName().equals(getName());
	}

	@Override
	public int hashCode() {
		return (int) getmId();
	}

}
