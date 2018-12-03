package org.lip6.struts.service;

import org.lip6.struts.domain.DAOGroupe;

public class GroupeService {
	private DAOGroupe dao;
	
	public GroupeService()
	{
		dao = new DAOGroupe();
		
	}
	
	public String addGroupe(String name) 
	{
		final String lError = dao.addGroupe(name);
		return lError;
	}
	
	public String addContactAllGroupe(String idContact) 
	{
		final String lError = dao.addContactAllGroupe(idContact);
		return lError;
	}

}
