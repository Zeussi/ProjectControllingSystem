package edu.hm.cs.team8.ui;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import edu.hm.cs.team8.masterdata.IMasterData;

@Path("/member.json")
@Produces({MediaType.APPLICATION_JSON})
public class MemberResource {
	
	private final IMasterData masterData;

	
	public MemberResource(IMasterData masterData) {
		this.masterData = masterData;
	}

	@GET
	public MemberView getMember() {
		return new MemberView( masterData.getMemberDAO().getMembers());
	}

}
