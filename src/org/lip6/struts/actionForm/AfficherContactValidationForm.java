package org.lip6.struts.actionForm;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class AfficherContactValidationForm extends ActionForm 
{
	private static final long serialVersionUID = 1L;
	
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request )
	{ 
		System.out.println(request.getParameter("name"));
		
		ActionErrors errors = new ActionErrors();
		if(request.getParameter("id")== null)
		{ 
			errors.add("Pas de ID",new ActionMessage("creation.fn.error.required")); 
		}
		return errors;
	}

}
