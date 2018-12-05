package org.lip6.struts.servletAction;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.Globals;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.action.ActionRedirect;
import org.lip6.struts.actionForm.AddContactValidationForm;
import org.lip6.struts.actionForm.AfficherContactValidationForm;
import org.lip6.struts.actionForm.AfficherListeContactValidationForm;
import org.lip6.struts.actionForm.SuppContactValidationForm;
import org.lip6.struts.domain.Contact;
import org.lip6.struts.domain.DAOContact;
import org.lip6.struts.service.ContactService;

public class AfficherInfosContactAction extends Action
{
	public ActionForward execute(final ActionMapping pMapping, ActionForm pForm,
			final HttpServletRequest pRequest,final HttpServletResponse pResponse) throws ServletException, IOException
	{
		final AfficherContactValidationForm lForm=(AfficherContactValidationForm)pForm;
        // Suppression du contact
		final ContactService contactService = new ContactService();
		Contact c  = new Contact();
		long id =  Long.parseLong(pRequest.getParameter("id"), 10) ;
		try 
		{
			c = contactService.afficherContact(id);
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			c = null;
		}
		
		if(c.equals(null))
		{
			// if no exception is raised, forward "success" return pMapping.findForward("success");
			return pMapping.findForward("error");
		}
		else
		{
			pRequest.setAttribute("contact", c);
			//RequestDispatcher rd = pRequest.getRequestDispatcher( "contactAfficher.jsp" );
			//rd.include(pRequest, pResponse);
			//rd.forward(pRequest, pResponse);
			return pMapping.findForward("success");
		}
	}
}
