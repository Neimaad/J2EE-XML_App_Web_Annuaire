

package com.sdzee.servlets;



import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sdzee.beans.Contacte;
import com.sdzee.programs.Annuaire;


/**
 * Servlet implementation class addContact
 */
@WebServlet("/addContact")
public class addContact extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	Contacte contacte = new Contacte();
	
    public addContact() {
        super();
    }
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/newContact.jsp").forward(request, response);
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		Annuaire annuaire = (Annuaire) request.getServletContext().getAttribute("annuaire");
		
		String boutonAjouter = request.getParameter("ajouterContacte");
		
		request.getServletContext().setAttribute("boutonAjouter", boutonAjouter);
		
		if(boutonAjouter != null) {
			
			annuaire.ajouter(	request.getParameter("nom"),
								request.getParameter("prenom"),
								request.getParameter("numtel"),
								request.getParameter("adresse"),
								request.getParameter("email"));
		}
		
		doGet(request, response);
		
		
	}

	
}

