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

	/** MM-YYYY. */
	private final String date;

	public TimeTrackingEntry(final Member member, final Account account, final double workedHours,
			final boolean billable, final double incrementalCosts, final double costRate, final String date) {
		this.member = member;
		this.account = account;
		this.workedHours = workedHours;
		this.billable = billable;
		this.incrementalCosts = incrementalCosts;
		this.costRate = costRate;
		this.date = date;
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
				.format("Account: %s%nM-ID: %s%nWorkedHours: %f%nBillable: %b%nDifferential Costs: %f%nCost Rate: %f%nDate: %s",
						getAccount(), getMember().getmId(), getWorkedHours(), isBillable(), getIncrementalCosts(),
						getCostRate(), getDate());
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

	public String getDate() {
		return date;
	}

	public Member getMember() {
		return member;
	}
}
