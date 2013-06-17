package edu.hm.cs.team8.timetrackingmangement.ui;

import edu.hm.cs.team8.timetrackingmangement.datamodel.TimeTrackingEntry;

public class TimeTrackingTO {

	private String account;
	private boolean billable;
	private String businessArea;
	private double costRate;
	private String date;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((account == null) ? 0 : account.hashCode());
		result = prime * result + (billable ? 1231 : 1237);
		result = prime * result
				+ ((businessArea == null) ? 0 : businessArea.hashCode());
		long temp;
		temp = Double.doubleToLongBits(costRate);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		temp = Double.doubleToLongBits(incrementalCosts);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + level;
		result = prime * result + ((member == null) ? 0 : member.hashCode());
		result = prime * result + (int) (mid ^ (mid >>> 32));
		result = prime * result + ((project == null) ? 0 : project.hashCode());
		temp = Double.doubleToLongBits(workedHours);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TimeTrackingTO other = (TimeTrackingTO) obj;
		if (account == null) {
			if (other.account != null)
				return false;
		} else if (!account.equals(other.account))
			return false;
		if (billable != other.billable)
			return false;
		if (businessArea == null) {
			if (other.businessArea != null)
				return false;
		} else if (!businessArea.equals(other.businessArea))
			return false;
		if (Double.doubleToLongBits(costRate) != Double
				.doubleToLongBits(other.costRate))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (Double.doubleToLongBits(incrementalCosts) != Double
				.doubleToLongBits(other.incrementalCosts))
			return false;
		if (level != other.level)
			return false;
		if (member == null) {
			if (other.member != null)
				return false;
		} else if (!member.equals(other.member))
			return false;
		if (mid != other.mid)
			return false;
		if (project == null) {
			if (other.project != null)
				return false;
		} else if (!project.equals(other.project))
			return false;
		if (Double.doubleToLongBits(workedHours) != Double
				.doubleToLongBits(other.workedHours))
			return false;
		return true;
	}

	private double incrementalCosts;
	private int level;
	private String member;
	private long mid;

	private String project;

	private double workedHours;

	public TimeTrackingTO(String businessArea, String project, int level,
			long mid, String account, String member, double workedHours,
			boolean billable, double incrementalCosts, double costRate,
			String date) {
		this.setBusinessArea(businessArea);
		this.setProject(project);
		this.setLevel(level);
		this.setMid(mid);
		this.account = account;
		this.member = member;
		this.workedHours = workedHours;
		this.billable = billable;
		this.incrementalCosts = incrementalCosts;
		this.costRate = costRate;
		this.date = date;
	}

	public TimeTrackingTO(final TimeTrackingEntry entry) {

		this(entry.getAccount().getProject().getBusinessArea().getName(), entry
				.getAccount().getProject().getName(), entry.getMember()
				.getLevel(), entry.getMember().getmId(), entry.getAccount()
				.getName(), entry.getMember().getName(),
				entry.getWorkedHours(), entry.isBillable(), entry
						.getIncrementalCosts(), entry.getCostRate(), entry
						.getMonth() + "-" + entry.getYear());
	}

	public String getAccount() {
		return account;
	}

	public String getBusinessArea() {
		return businessArea;
	}

	public double getCostRate() {
		return costRate;
	}

	public String getDate() {
		return date;
	}

	public double getIncrementalCosts() {
		return incrementalCosts;
	}

	public int getLevel() {
		return level;
	}

	public String getMember() {
		return member;
	}

	public long getMid() {
		return mid;
	}

	public String getProject() {
		return project;
	}

	public double getWorkedHours() {
		return workedHours;
	}

	public boolean isBillable() {
		return billable;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public void setBillable(boolean billable) {
		this.billable = billable;
	}

	public void setBusinessArea(String businessArea) {
		this.businessArea = businessArea;
	}

	public void setCostRate(double costRate) {
		this.costRate = costRate;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setIncrementalCosts(double incrementalCosts) {
		this.incrementalCosts = incrementalCosts;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public void setMember(String member) {
		this.member = member;
	}

	public void setMid(long mid) {
		this.mid = mid;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public void setWorkedHours(double workedHours) {
		this.workedHours = workedHours;
	}

	@Override
	public String toString() {
		return "TimeTrackingTO [account=" + account + ", member=" + member
				+ ", workedHours=" + workedHours + ", billable=" + billable
				+ ", incrementalCosts=" + incrementalCosts + ", costRate="
				+ costRate + ", date=" + date + "]";
	}

}
