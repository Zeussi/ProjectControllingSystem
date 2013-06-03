package edu.hm.cs.team8.timetrackingmangement.datamodel;


public class TimeTrackingEntry {

	private final Account account;

	private final Member member;

	private final double workedHours;

	private final boolean billable;

	/** Grenzkosten. */
	private final double incrementalCosts;

	/** Verrechnungssatz. */
	private final double costRate;

	private int month;

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

	public Account getAccount() {
		return account;
	}

	@Override
	public boolean equals(Object obj) {

		if (obj == null || obj.getClass() != getClass())
			return false;

		final TimeTrackingEntry that = (TimeTrackingEntry) obj;

		return that.getAccount().equals(getAccount()) && that.getMember().equals(getMember());

	}

	@Override
	public String toString() {
		return String
				.format("Account: %s%nM-ID: %s%nWorkedHours: %f%nBillable: %b%nDifferential Costs: %f%nCost Rate: %f%nDate: %d-%d",
						getAccount(), getMember().getmId(), getWorkedHours(), isBillable(), getIncrementalCosts(),
						getCostRate(), getMonth(), getYear());
	}

	public double getWorkedHours() {
		return workedHours;
	}

	public boolean isBillable() {
		return billable;
	}

	public double getIncrementalCosts() {
		return incrementalCosts;
	}

	public double getCostRate() {
		return costRate;
	}

	public Member getMember() {
		return member;
	}

	@Override
	public int hashCode() {
		return (int) (costRate + incrementalCosts + member.getLevel() + member.getmId());
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
}
