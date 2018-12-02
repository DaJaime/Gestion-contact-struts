package org.lip6.struts.service;

import org.lip6.struts.domain.DAOGroupe;

public class GroupeService {
	private DAOGroupe dao;
	
	public GroupeService()
	{
		dao = new DAOGroupe();
		
	}
	
	public String addContact(final long idContact, final String nomGroupe) 
	{
		System.out.println("Service");
		final String lError = dao.addContact(idContact, nomGroupe);
		return lError;
	}

}
