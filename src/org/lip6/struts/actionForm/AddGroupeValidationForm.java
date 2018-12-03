package org.lip6.struts.actionForm;


import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;


public class AddGroupeValidationForm extends ActionForm
{
	private static final long serialVersionUID = 1L;
	
	private String name=null; 

	public String getName()
	{ return name;}


	public void setName(String string) 
	{ name = string; }
	
	public void reset(ActionMapping mapping, HttpServletRequest request) 
	{ 
		this.name=null;
	}
	
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request )
	{ 
		ActionErrors errors = new ActionErrors();
		if( getName()== null || getName().length() < 1 )
		{ 
			errors.add("name",new ActionMessage("creation.fn.error.required")); 
		}
		return errors; 
	}

}
