package com.sdzee.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sdzee.programs.Annuaire;




@WebServlet("/searchContact")
public class searchContact extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	
    public searchContact() {
        super();
        
    }

    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/searchContact.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		Annuaire annuaire = (Annuaire) request.getServletContext().getAttribute("annuaire");
		
		request.getServletContext().setAttribute("contact", annuaire.getAnnuaire());
		
		request.getServletContext().setAttribute("searchAnnuaire", annuaire.getIntSearchAnnuaire());
		
		String boutonSupprimer = request.getParameter("supprimerContacteRechercher");
		request.getServletContext().setAttribute("supprimerContacteRechercher", boutonSupprimer);
		
		String boutonModifier = request.getParameter("modifierContacteRechercher");
		request.getServletContext().setAttribute("modifierContacteRechercher", boutonModifier);
		
		String modifierForms = request.getParameter("modifier");
		
		if(request.getParameter("rechercherContacte") != null) {
			
			annuaire.recherche(	request.getParameter("nom"),
								request.getParameter("prenom"),
								request.getParameter("numtel"),
								request.getParameter("adresse"),
								request.getParameter("email"));
										 
			
		}
		else if(boutonSupprimer != null) {
			
			int remove = Integer.parseInt(request.getParameter("supprimerContacteRechercher"));
			annuaire.supprimer(remove);
			
			annuaire.clear();
			
		}
		else if(boutonModifier != null) {
			
			int change = Integer.parseInt(request.getParameter("modifierContacteRechercher"));
			
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
