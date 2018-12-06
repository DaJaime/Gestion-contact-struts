package org.lip6.struts.servletAction;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.lip6.struts.actionForm.AfficherContactGroupeValidationForm;
import org.lip6.struts.actionForm.AfficherListeContactValidationForm;
import org.lip6.struts.domain.Contact;
import org.lip6.struts.domain.Groupe;
import org.lip6.struts.service.ContactService;
import org.lip6.struts.service.GroupeService;

public class AfficherContactGroupeAction extends Action{
	public ActionForward execute(final ActionMapping pMapping, ActionForm pForm,
			final HttpServletRequest pRequest,final HttpServletResponse pResponse) throws ServletException, IOException
	{
		final AfficherContactGroupeValidationForm lForm=(AfficherContactGroupeValidationForm)pForm;
		final String id = lForm.getId();
        // Suppression du contact
		final GroupeService groupeService = new GroupeService();
		List<Contact> liste = new ArrayList<Contact>();
		List<Groupe> groupe = new ArrayList<Groupe>();
		try 
		{
			liste = groupeService.afficherContactListeGroupe(id);
			groupe = groupeService.afficherGroupeNameUnique(id);
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			liste = null;
		}
		
		if(liste.size() == 0)
		{
			// if no exception is raised, forward "success" return pMapping.findForward("success");
			return pMapping.findForward("error");
		}
		else
		{
			pRequest.setAttribute("liste", liste);
			pRequest.setAttribute("nomGroupe", groupe.get(0).getNom());
			return pMapping.findForward("success");
		}
	}

}
