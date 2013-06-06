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


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((account == null) ? 0 : account.hashCode());
		result = prime * result + (billable ? 1231 : 1237);
		long temp;
		temp = Double.doubleToLongBits(costRate);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(incrementalCosts);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((member == null) ? 0 : member.hashCode());
		result = prime * result + month;
		temp = Double.doubleToLongBits(workedHours);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + year;
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
		TimeTrackingEntry other = (TimeTrackingEntry) obj;
		if (account == null) {
			if (other.account != null)
				return false;
		} else if (!account.equals(other.account))
			return false;
		if (billable != other.billable)
			return false;
		if (Double.doubleToLongBits(costRate) != Double.doubleToLongBits(other.costRate))
			return false;
		if (Double.doubleToLongBits(incrementalCosts) != Double.doubleToLongBits(other.incrementalCosts))
			return false;
		if (member == null) {
			if (other.member != null)
				return false;
		} else if (!member.equals(other.member))
			return false;
		if (month != other.month)
			return false;
		if (Double.doubleToLongBits(workedHours) != Double.doubleToLongBits(other.workedHours))
			return false;
		if (year != other.year)
			return false;
		return true;
	}
}
