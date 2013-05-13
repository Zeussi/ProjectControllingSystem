package edu.hm.cs.team8.ui;

import java.util.Set;

import com.yammer.dropwizard.views.View;

import edu.hm.cs.team8.masterdata.datamodel.Account;
import edu.hm.cs.team8.masterdata.datamodel.BusinessArea;
import edu.hm.cs.team8.masterdata.datamodel.Member;
import edu.hm.cs.team8.masterdata.datamodel.Project;

public class MasterDataView extends View {

	private final Set<Account> accounts;
	private final Set<Member> members;
	private final Set<BusinessArea> areas;
	private final Set<Project> projects;

	public MasterDataView(Set<Account> accounts, Set<Member> members, Set<BusinessArea> areas, Set<Project> projects) {
		super("masterData.ftl");
		this.accounts = accounts;
		this.members = members;
		this.areas = areas;
		this.projects = projects;
	}

	public Set<Member> getMembers() {
		return members;
	}

	public Set<Account> getAccounts() {
		return accounts;
	}

	public Set<BusinessArea> getAreas() {
		return areas;
	}

	public Set<Project> getProjects() {
		return projects;
	}

}
