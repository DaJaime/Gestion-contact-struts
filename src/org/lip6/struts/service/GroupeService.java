package org.lip6.struts.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.lip6.struts.domain.DAOGroupe;
import org.lip6.struts.domain.Groupe;

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

	public String addContactOnGroupe(String idContact, String idGroupe){
		final String lError = dao.addContactOnGroupe(idContact, idGroupe);
		return lError;
	}
	
	public List<Groupe> afficherGroupeName() throws SQLException{
		List<Groupe> liste = new ArrayList<Groupe>();
		final ResultSet resu = dao.afficherGroupeName();
		if (resu == null){
			return liste;
		}
		while (resu.next()) {
			Groupe g = new Groupe(resu.getString(1),resu.getString(2));
			liste.add(g);
			}
		return liste;
	}
}
