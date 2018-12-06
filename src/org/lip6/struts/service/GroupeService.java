package org.lip6.struts.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.lip6.struts.domain.Contact;
import org.lip6.struts.domain.DAOGroupe;
import org.lip6.struts.domain.Groupe;
import org.lip6.struts.domain.Telephone;

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
	
	public List<Groupe> afficherGroupeNameUnique(String id) throws SQLException{
		List<Groupe> liste = new ArrayList<Groupe>();
		final ResultSet resu = dao.afficherGroupeNameUnique(id);
		if (resu == null){
			return liste;
		}
		while (resu.next()) {
			Groupe g = new Groupe(resu.getString(1),resu.getString(2));
			liste.add(g);
			}
		return liste;
	}
	
	public List<Contact> afficherContactListeGroupe(String idGroupe) throws SQLException{
		List<Contact> liste = new ArrayList<Contact>();
		final ResultSet resu = dao.afficherContactListeGroupe(idGroupe);
		if (resu == null){
			return liste;
		}
		while (resu.next()) 
		{    
			long id =  Long.parseLong(resu.getString("ContactId"), 10) ;
			String nom = resu.getString("ContactNom");
			String prenom = resu.getString("ContactPrenom");
			String adresse = resu.getString("ContactAdresse");
			String email = resu.getString("ContactMail");
			String autre = resu.getString("ContactAutre");
			String numero = resu.getString("TelephoneNumero");
			String description = resu.getString("DescriptionNumero");
			String idTel = resu.getString("TelephoneId");
			Contact contact = new Contact(id,nom,prenom,adresse,email,autre);
			Telephone t = new Telephone(idTel, numero, description);
			List<Telephone> tel = new ArrayList<Telephone>();
			tel.add(t);
			contact.setTel(tel);
			liste.add(contact);
		}
		return liste;
	}
}
