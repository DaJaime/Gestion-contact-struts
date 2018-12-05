package org.lip6.struts.actionForm;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;


public class UpdateContactValidationForm extends ActionForm
{
	private static final long serialVersionUID = 1L;
	
	private long id=2;
	private String firstName=null; 
	private String lastName=null; 
	private String adresse=null;
	private String email=null;
	private String autre=null;
	
	public String getEmail() 
	{ return email; }

	public String getFirstName()
	{ return firstName;}

	public String getLastName() 
	{ return lastName;}
	
	public String getAdresse() 
	{ return adresse;}
	
	public String getAutre() 
	{ return autre;}

	public void setAutre(String string) 
	{ autre = string;}
	
	public void setAdresse(String string) 
	{ adresse = string;}
	
	public void setEmail(String string) 
	{ email = string;}

	public void setFirstName(String string) 
	{ firstName = string; }

	public void setLastName(String string) 
	{ lastName = string; }

	public long getId()
	{ return id; }

	public void setId(long l)
	{ id = l; }
	
	public void reset(ActionMapping mapping, HttpServletRequest request) 
	{ 
		this.id=0;
		this.firstName=null;
		this.lastName=null;
		this.adresse=null;
		this.email=null;
		this.autre=null;
	}
	
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request )
	{ 
		ActionErrors errors = new ActionErrors();
		if( getFirstName()== null || getFirstName().length() < 1 )
		{ 
			errors.add("first name",new ActionMessage("creation.fn.error.required")); 
		}
		
		if( getLastName()== null || getLastName().length() < 1 )
		{ 
			errors.add("last name",new ActionMessage("creation.ln.error.required")); 
		}
		
		return errors; 
	}

}
