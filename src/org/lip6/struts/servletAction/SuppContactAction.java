package org.lip6.struts.servletAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.lip6.struts.actionForm.SuppContactValidationForm;
import org.lip6.struts.service.ContactService;

public class SuppContactAction extends Action
{
	public ActionForward execute(final ActionMapping pMapping, ActionForm pForm,
			final HttpServletRequest pRequest,final HttpServletResponse pResponse)
	{
		final SuppContactValidationForm lForm=(SuppContactValidationForm)pForm;
        // Suppression du contact
		long id =  Long.parseLong(pRequest.getParameter("id"), 10) ;
		final ContactService contactService = new ContactService();
		final String lError = contactService.deleteContact(id);
		
		if(lError == null)
		{
			// if no exception is raised, forward "success" return pMapping.findForward("success");
			return pMapping.findForward("success");
		}
		else
		{
			// If any exception, return the "error" forward
			return pMapping.findForward("error");
		}
	}
}
