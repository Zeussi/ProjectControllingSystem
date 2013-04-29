package edu.hm.cs.team8.filter.to;

import java.util.Date;

import edu.hm.cs.team8.persistence.datamodel.Account;
import edu.hm.cs.team8.persistence.datamodel.Area;
import edu.hm.cs.team8.persistence.datamodel.Member;
import edu.hm.cs.team8.persistence.datamodel.Projekt;

public class BookEntryResult {
	private Date date;

	private long hour;

	private boolean billable;

	private long costs;

	private String member;

	private String account;

	private String projekt;

	private String area;

	public boolean isBillable() {
		return billable;
	}

	public void setBillable(boolean billable) {
		this.billable = billable;
	}

	public long getCosts() {
		return costs;
	}

	public void setCosts(long costs) {
		this.costs = costs;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public long getHour() {
		return hour;
	}

	public void setHour(long hour) {
		this.hour = hour;
	}

	public String getMember() {
		return member;
	}

	public void setMember(String member) {
		this.member = member;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getProjekt() {
		return projekt;
	}

	public void setProjekt(String projekt) {
		this.projekt = projekt;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}
}
