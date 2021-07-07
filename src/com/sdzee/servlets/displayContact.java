package com.sdzee.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sdzee.programs.Annuaire;



@WebServlet("/displayContact")
public class displayContact extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	
	
    public displayContact() {
        super();
        
    }

    
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/listingContact.jsp").forward(request, response);
		
	}
	
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		Annuaire annuaire = (Annuaire) request.getServletContext().getAttribute("annuaire");
		
		request.getServletContext().setAttribute("Contacts", annuaire.getAnnuaire());
		
		String boutonSupprimer = request.getParameter("supprimerContacte");
		request.getServletContext().setAttribute("supprimerContacte", boutonSupprimer);
		
		String boutonModifier = request.getParameter("modifierContacte");
		request.getServletContext().setAttribute("modifierContacte", boutonModifier);
		
		String modifierForms = request.getParameter("modifier");
		
		if(boutonSupprimer != null) {
			
			int remove = Integer.parseInt(request.getParameter("supprimerContacte"));
			annuaire.supprimer(remove);
		}
		else if(boutonModifier != null) {
			
			int change = Integer.parseInt(request.getParameter("modifierContacte"));
			
			annuaire.modifier(change, request.getParameter("nom"),
									  request.getParameter("prenom"),
									  request.getParameter("numtel"),
									  request.getParameter("adresse"),
									  request.getParameter("email"));
		}
		else if(modifierForms != null) {
			request.getServletContext().setAttribute("modifier", modifierForms);
		}
		
		
		doGet(request, response);
		
	}

}
