package org.lip6.struts.servletAction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.lip6.struts.actionForm.AddContactValidationForm;
import org.lip6.struts.service.ContactService;
import org.lip6.struts.service.GroupeService;
import org.lip6.struts.service.TelephoneService;

public class AddContactAction extends Action
{
	public ActionForward execute(final ActionMapping pMapping, ActionForm pForm,
			final HttpServletRequest pRequest,final HttpServletResponse pResponse)
	{
		final AddContactValidationForm lForm=(AddContactValidationForm)pForm;
		final String firstName = lForm.getFirstName();
		final String lastName = lForm.getLastName();
		final String adresse = lForm.getAdresse();
		final String email = lForm.getEmail();
		final String autre = lForm.getAutre();
		final String numero = lForm.getTelephone();
		final String description = lForm.getTelephoneDescription();
		final String[] idGroupes = lForm.getIdGroupes();
		String lError = "";
        // create a new Contact
		final ContactService contactService = new ContactService();
		final String id = contactService.addContact(firstName, lastName, adresse, email, autre);
		GroupeService gs = new GroupeService();
		for(int i=0;i<idGroupes.length;i++){
			lError = gs.addContactOnGroupe(id, idGroupes[i]);
		}
		TelephoneService tel = new TelephoneService();
		tel.addTelephone(numero, id, description);
		
		
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
