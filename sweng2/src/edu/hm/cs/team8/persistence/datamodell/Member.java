package edu.hm.cs.team8.persistence.datamodell;

public class Member {

	private long mId;

	private String name;

	private int level;

	public int getLevel() {
		return level;
	}

	public String getName() {
		return name;
	}

	public long getmId() {
		return mId;
	}

	public void setmId(long mId) {
		this.mId = mId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setLevel(int level) {
		this.level = level;
	}

}
