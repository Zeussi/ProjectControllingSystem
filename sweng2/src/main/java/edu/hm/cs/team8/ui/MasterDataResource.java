package edu.hm.cs.team8.ui;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import edu.hm.cs.team8.masterdata.IMasterData;

@Path("/masterdata")
@Produces(MediaType.TEXT_HTML)
public class MasterDataResource {

	private final IMasterData masterData;

	public MasterDataResource(IMasterData masterData) {
		this.masterData = masterData;

	}

	@GET
	public MasterDataView getMasterData() {
		return new MasterDataView(masterData.getAccountDAO().getAccounts(), masterData.getMemberDAO().getMembers(),
				masterData.getBusinessAreaDAO().getBusinessAreas(), masterData.getProjectDAO().getProjects());
	}

}
