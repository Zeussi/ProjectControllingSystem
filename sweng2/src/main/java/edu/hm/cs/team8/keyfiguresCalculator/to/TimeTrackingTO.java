package edu.hm.cs.team8.keyfiguresCalculator.to;

import edu.hm.cs.team8.timetrackingmangement.datamodel.TimeTrackingEntry;

public class TimeTrackingTO {

	private String account;
	private boolean billable;
	private String businessArea;
	private double costRate;
	private String date;
	private double incrementalCosts;
	private int level;
	private String member;
	private long mid;

	private String project;

	private double workedHours;

	public TimeTrackingTO(String businessArea, String project, int level, long mid, String account, String member,
			double workedHours, boolean billable, double incrementalCosts, double costRate, String date) {
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

		this(entry.getAccount().getProject().getBusinessArea().getName(), entry.getAccount().getProject().getName(),
				entry.getMember().getLevel(), entry.getMember().getmId(), entry.getAccount().getName(), entry
						.getMember().getName(), entry.getWorkedHours(), entry.isBillable(),
				entry.getIncrementalCosts(), entry.getCostRate(), entry.getMonth() + "-" + entry.getYear());
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
		return "TimeTrackingTO [account=" + account + ", member=" + member + ", workedHours=" + workedHours
				+ ", billable=" + billable + ", incrementalCosts=" + incrementalCosts + ", costRate=" + costRate
				+ ", date=" + date + "]";
	}

}
