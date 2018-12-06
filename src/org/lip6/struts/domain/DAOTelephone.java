package org.lip6.struts.domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DAOTelephone 
{
	
private final static String RESOURCE_JDBC = "java:comp/env/jdbc/ContactBD";
	
	public String addTelephone(String numero, String idContact, String description)
	{
		try 
		{
			final Context lContext = new InitialContext();
			final DataSource lDataSource = (DataSource)
			lContext.lookup(RESOURCE_JDBC);
			final Connection lConnection = lDataSource.getConnection();
			 // adding a new contact
			
			final PreparedStatement lPreparedStatementCreation = lConnection.prepareStatement
					("INSERT INTO telephone(TelephoneNumero, FKTelephoneContactId ,DescriptionNumero) VALUES(?,?,?)");
			lPreparedStatementCreation.setString(1, numero);
			lPreparedStatementCreation.setString(2, idContact);
			lPreparedStatementCreation.setString(3, description);
			lPreparedStatementCreation.executeUpdate();
			return null;
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
	
	
	
	public String updateTelephone(String numero,String id,String description)
	{
		Context lContext;
		try 
		{
			System.out.println(numero);
			System.out.println(id);
			System.out.println(description);
			int num  = Integer.parseInt(numero); 
			lContext = new InitialContext();
			final DataSource lDataSource = (DataSource)
			lContext.lookup(RESOURCE_JDBC);
			final Connection lConnection = lDataSource.getConnection();
			// Update contact
			final PreparedStatement lPreparedStatementCreation = lConnection.prepareStatement
					("update TELEPHONE set TelephoneNumero=?, DescriptionNumero=? where fktelephonecontactid=?");
			lPreparedStatementCreation.setInt(1, num);
			lPreparedStatementCreation.setString(2, description);
			lPreparedStatementCreation.setString(3, id);
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
	

}
