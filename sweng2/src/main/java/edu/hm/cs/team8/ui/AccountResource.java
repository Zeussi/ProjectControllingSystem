package edu.hm.cs.team8.ui;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import edu.hm.cs.team8.masterdata.IMasterData;

@Path("/account.json")
@Produces({MediaType.APPLICATION_JSON})
public class AccountResource {
	
	private final IMasterData masterData;

	
	public AccountResource(IMasterData masterData) {
		this.masterData = masterData;
	}

	@GET
	public AccountView getMember() {
		return new AccountView( masterData.getAccountDAO().getAccounts());
	}

}
