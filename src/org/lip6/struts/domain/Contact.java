package org.lip6.struts.domain;

public class Contact 
{
	
	private long id;
	private String firstName;
	private String lastName;
	private String email;

	public String getEmail()
	{ return email; }

	public String getFirstName()
	{ return firstName; }

	public String getLastName()
	{ return lastName; }
	
	public void setEmail(String string)
	{ email = string;}

	public void setFirstName(String string)
	{ firstName = string; }

	public void setLastName(String string)
	{ lastName = string;}

	public long getId()
	{ return id; }

	public void setId(long l)
	{ id = l; }
	
	
	
}
