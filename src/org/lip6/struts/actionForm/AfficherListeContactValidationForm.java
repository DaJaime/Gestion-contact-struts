package org.lip6.struts.actionForm;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

public class AfficherListeContactValidationForm extends ActionForm 
{
	private static final long serialVersionUID = 1L;
	
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request )
	{ 
		ActionErrors errors = new ActionErrors();		
		return errors; 
	}

}
