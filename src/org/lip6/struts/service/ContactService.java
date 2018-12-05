package org.lip6.struts.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.lip6.struts.domain.Contact;
import org.lip6.struts.domain.DAOContact;

public class ContactService 
{
	private DAOContact dao;
	
	public ContactService()
	{
		dao = new DAOContact();
		
	}
	
	public String addContact(final String firstName, final String lastName, final String adresse, final String email, final String autre) 
	{
		System.out.println("Service");
		final String lError = dao.addContact(firstName, lastName, adresse, email, autre);
		GroupeService gs = new GroupeService();
		//gs.addContact(id, "All");
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
	
	public List<Contact> afficherListeContact() throws SQLException{
		List<Contact> liste = new ArrayList<Contact>();
		final ResultSet resu = dao.afficherListeContact();
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
			Contact contact = new Contact(id,nom,prenom,adresse,email,autre);
			liste.add(contact);
		}
		return liste;
	}
	
	public Contact afficherContact(long id) throws SQLException{
		Contact contact = new Contact();
		final ResultSet resu = dao.afficherContact(id);
		if (resu == null){
			return contact;
		}
		while (resu.next()) 
		{    
			long idi =  Long.parseLong(resu.getString("ContactId"), 10);
			contact.setId(idi);
			contact.setLastName(resu.getString("ContactNom"));
			contact.setFirstName(resu.getString("ContactPrenom"));
			contact.setAdresse(resu.getString("ContactAdresse"));
			contact.setEmail(resu.getString("ContactMail"));
			contact.setAutre(resu.getString("ContactAutre"));
		}
		return contact;
	}
	
}
