package org.lip6.struts.domain;

public class Telephone 
{
	private String id;
	private String numero;
	private String description;
	
	public Telephone(String id, String numero, String description)
	{
		this.id = id;
		this.numero = numero;
		this.description = description;
	}
	
	public String getId()
	{
		return this.id;
	}
	
	public String getNumero()
	{
		return this.numero;
	}
	
	public String getDescription()
	{
		return this.description;
	}
	
	public void setId(String id)
	{
		this.id = id;
	}
	
	public void setNumero(String numero)
	{
		this.numero = numero;
	}
	
	public void setDescription(String description)
	{
		this.description = description;
	}

}
