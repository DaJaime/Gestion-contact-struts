package org.lip6.struts.service;

import org.lip6.struts.domain.DAOContact;

public class ContactService 
{
	private DAOContact dao;
	
	public ContactService()
	{
		dao = new DAOContact();
		
	}
	
	public String addContact(final long id, final String firstName, final String lastName, final String email) 
	{
		final String lError = dao.addContact(id, firstName, lastName, email);
		return lError;
	}

	
}
