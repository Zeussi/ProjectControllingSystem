package edu.hm.cs.team8.timetrackingmangement.datamodel;

public class Member {

	private final int level;

	private final long mId;

	private final String name;

	public Member(long mid, String name, int level) {
		mId = mid;
		this.name = name;
		this.level = level;

	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || obj.getClass() != getClass())
			return false;

		final Member that = (Member) obj;

		return that.getLevel() == getLevel() && that.getmId() == getmId()
				&& that.getName().equals(getName());
	}

	public int getLevel() {
		return level;
	}

	public long getmId() {
		return mId;
	}

	public String getName() {
		return name;
	}

	@Override
	public int hashCode() {
		return (int) getmId();
	}

	@Override
	public String toString() {
		return String.format(
				"Member Name: %s%nMember ID: %d%nMember Level: %d", getName(),
				getmId(), getLevel());
	}

}
