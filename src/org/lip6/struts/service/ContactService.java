package org.lip6.struts.service;

import org.lip6.struts.domain.DAOContact;

public class ContactService 
{
	private DAOContact dao;
	
	public ContactService()
	{
		dao = new DAOContact();
		
	}
	
	public String addContact(final long id, final String firstName, final String lastName, final String adresse, final String email, final String autre) 
	{
		final String lError = dao.addContact(id, firstName, lastName, adresse, email, autre);
		return lError;
	}
	
	public String updateContact(final long id, final String firstName, final String lastName, final String adresse, final String email, final String autre)
	{
		final String lError = dao.updateContact(id, firstName, lastName, adresse, email, autre);
		return lError;
	}
}
