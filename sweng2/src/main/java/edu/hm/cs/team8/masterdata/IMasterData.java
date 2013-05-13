package edu.hm.cs.team8.masterdata;

import edu.hm.cs.team8.masterdata.dao.AccountDAO;
import edu.hm.cs.team8.masterdata.dao.BusinessAreaDAO;
import edu.hm.cs.team8.masterdata.dao.MemberDAO;
import edu.hm.cs.team8.masterdata.dao.ProjectDAO;

public interface IMasterData {

	public MemberDAO getMemberDAO();

	public AccountDAO getAccountDAO();

	public BusinessAreaDAO getBusinessAreaDAO();

	public ProjectDAO getProjectDAO();
}
