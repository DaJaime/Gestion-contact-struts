package org.lip6.struts.domain;

import java.util.List;

public class Contact 
{
	
	private long id;
	private String firstName;
	private String lastName;
	private String email;
	private List<String> tel;
	private String adresse;
	private String autre;

	public String getEmail()
	{ return email; }

	public String getFirstName()
	{ return firstName; }

	public String getLastName()
	{ return lastName; }
	
	public List<String> getTel()
	{ return tel; }
	
	public String getAdresse()
	{ return adresse; }
	
	public String getAutre()
	{ return autre; }
	
	public void setEmail(String string)
	{ email = string;}

	public void setFirstName(String string)
	{ firstName = string; }

	public void setLastName(String string)
	{ lastName = string;}
	
	public void setAdresse(String string)
	{ adresse = string;}
	
	public void setAutre(String string)
	{ autre = string;}
	
	public void setTel(List<String> list)
	{ tel = list;}

	public long getId()
	{ return id; }

	public void setId(long l)
	{ id = l; }
	
}
