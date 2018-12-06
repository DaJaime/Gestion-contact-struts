package org.lip6.struts.actionForm;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class AfficherContactGroupeValidationForm extends ActionForm{
	
	private static final long serialVersionUID = 1L;
	
	private String id=null; 

	public String getId()
	{ return id;}


	public void setId(String string) 
	{ id = string; }
	
	public void reset(ActionMapping mapping, HttpServletRequest request) 
	{ 
		this.id=null;
	}
	
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request )
	{ 
		ActionErrors errors = new ActionErrors();
		if( getId()== null || getId().length() < 1 )
		{ 
			errors.add("id",new ActionMessage("creation.fn.error.required")); 
		}
		return errors; 
	}

}
