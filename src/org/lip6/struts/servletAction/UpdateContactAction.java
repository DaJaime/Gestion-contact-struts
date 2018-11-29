package org.lip6.struts.servletAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.lip6.struts.actionForm.UpdateContactValidationForm;
import org.lip6.struts.service.ContactService;

public class UpdateContactAction extends Action
{
	public ActionForward execute(final ActionMapping pMapping, ActionForm pForm,
			final HttpServletRequest pRequest,final HttpServletResponse pResponse)
	{
		final UpdateContactValidationForm lForm=(UpdateContactValidationForm)pForm;
		final long id = lForm.getId();
		final String firstName = lForm.getFirstName();
		final String lastName = lForm.getLastName();
		final String adresse = lForm.getAdresse();
		final String email = lForm.getEmail();
		final String autre = lForm.getAutre();
        // create a new Contact
		final ContactService contactService = new ContactService();
		final String lError = contactService.updateContact(id, firstName, lastName, adresse, email, autre);
		
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
