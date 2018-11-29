package org.lip6.struts.actionForm;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class SuppContactValidationForm extends ActionForm{
	private long id = 0;
	
	public long getId()
	{ return id; }

	public void setId(long l)
	{ id = l; }
	
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request )
	{ 
		ActionErrors errors = new ActionErrors();
		if( getId() < 0)
		{ 
			errors.add("id",new ActionMessage("creation.id.error.required")); 
		}
		
		return errors; 
	}

}
