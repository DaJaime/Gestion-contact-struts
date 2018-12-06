package org.lip6.struts.service;

import org.lip6.struts.domain.DAOTelephone;

public class TelephoneService 
{
	private DAOTelephone dao;
	
	public TelephoneService()
	{
		dao = new DAOTelephone();
	}
	
	public String addTelephone(String numero, String idContact, String description) 
	{
		final String lError = dao.addTelephone(numero, idContact, description);
		return lError;
	}

}
