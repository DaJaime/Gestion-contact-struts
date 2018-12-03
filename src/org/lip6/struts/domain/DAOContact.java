package org.lip6.struts.domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DAOContact 
{
	private final static String RESOURCE_JDBC = "java:comp/env/jdbc/ContactBD";
	
	
	public String addContact(final String firstName, final String lastName, final String adresse, final String email, final String autre) 
	{
		try 
		{
			final Context lContext = new InitialContext();
			final DataSource lDataSource = (DataSource)
			lContext.lookup(RESOURCE_JDBC);
			final Connection lConnection = lDataSource.getConnection();
			 // adding a new contact
			final PreparedStatement lPreparedStatementCreation = lConnection.prepareStatement
					("INSERT INTO CONTACT(ContactNom, ContactPrenom, ContactAdresse, ContactMail, ContactAutre) VALUES(?, ?, ?, ?, ?)");
			lPreparedStatementCreation.setString(1, firstName);
			lPreparedStatementCreation.setString(2, lastName);
			lPreparedStatementCreation.setString(3, adresse);
			lPreparedStatementCreation.setString(4, email);
			lPreparedStatementCreation.setString(5, autre);
			lPreparedStatementCreation.executeUpdate();
			//récupère l'id de contact inséré
			String requ = "SELECT ContactId FROM contact where ContactId = (select MAX(ContactId) from contact)";
			ResultSet result=lConnection.createStatement().executeQuery(requ);
			result.next();
			return result.getString(1);
		}
		catch (NamingException e)
		{
			System.out.println("Erreur dans l'ajout de la BDD : " + e.getMessage());
			return "Erreur dans l'ajout de la BDD : " + e.getMessage();
		}
		catch (SQLException e)
		{
			System.out.println("Erreur dans la requete SQL: " + e.getMessage());
			return "Erreur dans la requete SQL: " + e.getMessage();
		} 
	}
	
	public String deleteContact(long id){
		try
		{
			final Context lContext = new InitialContext();
			final DataSource lDataSource = (DataSource)
			lContext.lookup(RESOURCE_JDBC);
			final Connection lConnection = lDataSource.getConnection();
			 // delete a new contact
			String requ = "DELETE FROM contact WHERE ContactId="+id;
			lConnection.createStatement().executeUpdate(requ);
			return null;
		}
		catch (NamingException e)
		{
			System.out.println("Erreur dans la suppression de la BDD : " + e.getMessage());
			return "Erreur dans suppression de la BDD : " + e.getMessage();
		}
		catch (SQLException e)
		{
			System.out.println("Erreur dans la requete SQL: " + e.getMessage());
			return "Erreur dans la requete SQL: " + e.getMessage();
		} 
	}
	
	public String updateContact(final long id, final String firstName, final String lastName, final String adresse, final String email, final String autre)
	{
		Context lContext;
		try 
		{
			lContext = new InitialContext();
			final DataSource lDataSource = (DataSource)
			lContext.lookup(RESOURCE_JDBC);
			final Connection lConnection = lDataSource.getConnection();
			// Update contact
			final PreparedStatement lPreparedStatementCreation = lConnection.prepareStatement
					("update CONTACT set ContactPrenom=?, ContactNom=?, ContactAdresse=?, ContactMail=?, ContactAutre=?"
							+ " where ContactId=?");
			lPreparedStatementCreation.setString(1, firstName);
			lPreparedStatementCreation.setString(2, lastName);
			lPreparedStatementCreation.setString(3, adresse);
			lPreparedStatementCreation.setString(4, email);
			lPreparedStatementCreation.setString(5, autre);
			lPreparedStatementCreation.setLong(6, id);
			lPreparedStatementCreation.executeUpdate();
			return null;
		} 
		catch (NamingException e)
		{
			System.out.println("Erreur dans l'ajout de la BDD : " + e.getMessage());
			return "Erreur dans la modification de la BDD : " + e.getMessage();
		}
		catch (SQLException e)
		{
			System.out.println("Erreur dans la requete SQL: " + e.getMessage());
			return "Erreur dans la requete SQL: " + e.getMessage();
		} 
		
	}
	
	public ResultSet afficherContact(){
		try
		{
			final Context lContext = new InitialContext();
			final DataSource lDataSource = (DataSource)
			lContext.lookup(RESOURCE_JDBC);
			final Connection lConnection = lDataSource.getConnection();
			 // delete a new contact
			String requ = "SELECT * FROM contact";
			ResultSet result=lConnection.createStatement().executeQuery(requ);
			return result;
		}
		catch (NamingException e)
		{
			System.out.println("Erreur dans la lecture de la BDD : " + e.getMessage());
		}
		catch (SQLException e)
		{
			System.out.println("Erreur dans la requete SQL: " + e.getMessage());
		}
		return null;
	}
	
	
}
