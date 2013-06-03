package edu.hm.cs.team8.ui;

import java.util.Set;

import com.yammer.dropwizard.views.View;

import edu.hm.cs.team8.masterdata.datamodel.Account;


public class AccountView extends View{
	private final Set<Account> accounts;

	public AccountView(Set<Account> accounts) {
		super("accountJSON.ftl");
		this.accounts = accounts;
	}

	public Set<Account> getAccounts() {
		return accounts;
	}
}
