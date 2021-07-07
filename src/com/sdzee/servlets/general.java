package com.sdzee.servlets;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jdom2.JDOMException;

import com.sdzee.programs.Annuaire;




public class general extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	Annuaire annuaire = new Annuaire();
	
	
    public general() {
        super();
    }

    
    public void init(ServletConfig config) throws ServletException {
    	super.init(config);
    	ServletContext one = config.getServletContext();
    	one.setAttribute("annuaire", annuaire);
    	
    	getServletContext().setAttribute("Contacts", annuaire.getAnnuaire());
    	try {
			annuaire.afficher();
			//annuaire.userConnected();
			
		} catch (JDOMException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/accueil.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		if(request.getParameter("ajouterContacte") != null) {
			this.getServletContext().getRequestDispatcher("/add").forward(request, response);
		}
		
		
		
		else if(request.getParameter("rechercherContacte") != null) {
			this.getServletContext().getRequestDispatcher("/search").forward(request, response);
		}
		
		
		
		else if(request.getParameter("afficherContacte") != null) {
			this.getServletContext().getRequestDispatcher("/display").forward(request, response);
		}
		else if(request.getParameter("supprimerContacte") != null) {
			this.getServletContext().getRequestDispatcher("/display").forward(request, response);
		}
		else if(request.getParameter("modifierContacte") != null) {
			this.getServletContext().getRequestDispatcher("/display").forward(request, response);
		}
		
		
		
		else if(request.getParameter("supprimerContacteRechercher") != null) {
			this.getServletContext().getRequestDispatcher("/search").forward(request, response);
		}
		else if(request.getParameter("modifierContacteRechercher") != null) {
			this.getServletContext().getRequestDispatcher("/search").forward(request, response);
		}
		else if(request.getParameter("modifier") != null) {
			this.getServletContext().getRequestDispatcher("/search").forward(request, response);
		}
		
		
		doGet(request, response);
	}
	
	public void destroy(){
		
		Annuaire annuaire = (Annuaire) getServletContext().getAttribute("annuaire");
		try {
			annuaire.ajouterXML();
			//annuaire.ajouterUtilisateurXML();
			
		} catch (JDOMException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
