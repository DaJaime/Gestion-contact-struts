package org.lip6.struts.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
		System.out.println("Service");
		final String lError = dao.addContact(id, firstName, lastName, adresse, email, autre);
		return lError;
	}
	
	public String deleteContact(final long id) 
	{
		final String lError = dao.deleteContact(id);
		return lError;
	}

	
	public String updateContact(final long id, final String firstName, final String lastName, final String adresse, final String email, final String autre)
	{
		final String lError = dao.updateContact(id, firstName, lastName, adresse, email, autre);
		return lError;
	}
	
	public List<String> afficherContact() throws SQLException{
		System.out.println("Service");
		List<String> liste = new ArrayList<String>();
		final ResultSet resu = dao.afficherContact();
		if (resu == null){
			return liste;
		}
		while (resu.next()) {              
			   int i = 2;
			   while(i <= 6) {
			        liste.add(resu.getString(i++));
			   }
			}
		System.out.println(liste.size());
		System.out.println(liste.get(0));
		System.out.println(liste.get(1));
		return liste;
	}
}
