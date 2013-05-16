package edu.hm.cs.team8.filter.impl.timefilter;

public class TimeEntry {

	private int fromMonth;
	private int fromYear;
	private int toYear;
	private int toMonth;

	public TimeEntry(final int fromMonth, final int fromYear, final int toYear, final int toMonth) {
		this.fromMonth = fromMonth;
		this.fromYear = fromYear;
		this.toYear = toYear;
		this.toMonth = toMonth;

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + fromMonth;
		result = prime * result + fromYear;
		result = prime * result + toMonth;
		result = prime * result + toYear;
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
		TimeEntry other = (TimeEntry) obj;
		if (fromMonth != other.fromMonth)
			return false;
		if (fromYear != other.fromYear)
			return false;
		if (toMonth != other.toMonth)
			return false;
		if (toYear != other.toYear)
			return false;
		return true;
	}

	public boolean contains(int month, int year) {
		return year >= fromYear && month >= fromMonth && year <= toYear && month <= toMonth;
	}

	@Override
	public String toString() {
		return String.format("%d.%d - %d.%d", fromMonth, fromYear, toMonth, toYear);
	}
}
