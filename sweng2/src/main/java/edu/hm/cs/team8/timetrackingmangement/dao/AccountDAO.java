package edu.hm.cs.team8.timetrackingmangement.dao;

import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.skife.jdbi.v2.Handle;

import edu.hm.cs.team8.timetrackingmangement.datamodel.Account;
import edu.hm.cs.team8.timetrackingmangement.datamodel.BusinessArea;
import edu.hm.cs.team8.timetrackingmangement.datamodel.Project;
import edu.hm.cs.team8.timetrackingmangement.impl.Cache;

public class AccountDAO {

	private final Set<Account> accounts = new HashSet<>();

	public AccountDAO(final Handle handle) {

		for (final Map<String, Object> line : Cache.getCache(handle)) {

			if (!line.containsKey("projekt"))
				continue;

			accounts.add(new Account(line.get("konto").toString(), new Project(line.get("projekt").toString(),
					new BusinessArea(line.get("bereich").toString()))));
		}
	}

	public Account findAccountByName(final String name) {

		for (Account area : accounts)
			if (area.getName().equals(name))
				return area;

		return null;
	}

	public Set<Account> getAccounts() {
		return Collections.unmodifiableSet(accounts);
	}

}
