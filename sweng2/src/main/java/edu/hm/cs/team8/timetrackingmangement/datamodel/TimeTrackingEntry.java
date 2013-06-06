package edu.hm.cs.team8.timetrackingmangement.datamodel;

public class TimeTrackingEntry {

	private final Account account;

	private final boolean billable;

	/** Verrechnungssatz. */
	private final double costRate;

	/** Grenzkosten. */
	private final double incrementalCosts;

	private final Member member;

	private int month;

	private final double workedHours;

	private int year;

	public TimeTrackingEntry(final Member member, final Account account, final double workedHours,
			final boolean billable, final double incrementalCosts, final double costRate, final int month,
			final int year) {
		this.member = member;
		this.account = account;
		this.workedHours = workedHours;
		this.billable = billable;
		this.incrementalCosts = incrementalCosts;
		this.costRate = costRate;
		this.setMonth(month);
		this.setYear(year);
	}

	@Override
	public boolean equals(Object obj) {

		if (obj == null || obj.getClass() != getClass())
			return false;

		final TimeTrackingEntry that = (TimeTrackingEntry) obj;

		return that.getAccount().equals(getAccount()) && that.getMember().equals(getMember());

	}

	public Account getAccount() {
		return account;
	}

	public double getCostRate() {
		return costRate;
	}

	public double getIncrementalCosts() {
		return incrementalCosts;
	}

	public Member getMember() {
		return member;
	}

	public int getMonth() {
		return month;
	}

	public double getWorkedHours() {
		return workedHours;
	}

	public int getYear() {
		return year;
	}

	@Override
	public int hashCode() {
		return (int) (costRate + incrementalCosts + member.getLevel() + member.getmId());
	}

	public boolean isBillable() {
		return billable;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return String
				.format("Account: %s%nM-ID: %s%nWorkedHours: %f%nBillable: %b%nDifferential Costs: %f%nCost Rate: %f%nDate: %d-%d",
						getAccount(), getMember().getmId(), getWorkedHours(), isBillable(), getIncrementalCosts(),
						getCostRate(), getMonth(), getYear());
	}
}
