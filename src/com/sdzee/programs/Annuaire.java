package com.sdzee.programs;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import com.sdzee.beans.Contacte;

public class Annuaire {
	
	
	Element racine;
	Document document;

	public Annuaire() {
		
	}
	
	
	//============================================================================================================================================================
	//===============================================AJOUTER UN CONTACTE=============================================================================================
	//==============================================================================================================================================================
	
	
	List<Contacte> listAnnuaire = new ArrayList<Contacte>();
	
	
	public void ajouter(String nom, String prenom, String numtel, String adresse, String email) {
			
		Contacte c = new Contacte(nom, prenom, numtel, adresse, email);
		this.listAnnuaire.add(c);
			
		
		
		
	}
	
				//============================================ECRIRE DANS LE XML================================================
	
			
	public void ajouterXML() throws JDOMException, IOException  {    	//donnee en memoire ---> fichier XML
		
		
		File fileDATA = new File("annuaireDATA.xml");
		    
				
		//Pour éviter d'ecraser le fichier existant, on fait un teste
		if(fileDATA.exists()) {
			FileInputStream DATA = new FileInputStream(fileDATA);
					
			//lire le fichier avec SAX
			SAXBuilder fileLire = new SAXBuilder();
			document = fileLire.build(DATA);
					
			//on recup l'élement Racine
			racine = document.getRootElement();
			
			for(int i = 0 ; i < this.listAnnuaire.size() ; i++) {
				Element contacte = new Element("contacte");
						
				Element nom = new Element("nom");
				nom.setText(this.listAnnuaire.get(i).getNom());
				contacte.addContent(nom);
					      
				Element prenom = new Element("prenom");
				prenom.setText(this.listAnnuaire.get(i).getPrenom());
				contacte.addContent(prenom);
							
				Element numtel = new Element("numtel");
				numtel.setText(this.listAnnuaire.get(i).getNumtel());
				contacte.addContent(numtel);
							
				Element adresse = new Element("adresse");
				adresse.setText(this.listAnnuaire.get(i).getAdresse());
				contacte.addContent(adresse);
						
				Element email = new Element("email");
				email.setText(this.listAnnuaire.get(i).getEmail());
				contacte.addContent(email);
						
				racine.addContent(contacte);
			}
					
			DATA.close();
					
		}
		else {
			Element racine = new Element("personnes");
			document = new Document(racine);
			
			for(int i = 0 ; i < this.listAnnuaire.size() ; i++) {
				Element contacte = new Element("contacte");
				
					
				Element nom = new Element("nom");
				nom.setText(this.listAnnuaire.get(i).getNom());
				contacte.addContent(nom);
				      
				Element prenom = new Element("prenom");
				prenom.setText(this.listAnnuaire.get(i).getPrenom());
				contacte.addContent(prenom);
						
				Element numtel = new Element("numtel");
				numtel.setText(this.listAnnuaire.get(i).getNumtel());
				contacte.addContent(numtel);
						
				Element adresse = new Element("adresse");
				adresse.setText(this.listAnnuaire.get(i).getAdresse());
				contacte.addContent(adresse);
						
				Element email = new Element("email");
				email.setText(this.listAnnuaire.get(i).getEmail());
				contacte.addContent(email);
						
				racine.addContent(contacte);
			}
		}
		try {
					
			//on écrit sur le fichier existant
			FileOutputStream fileEcrire = new FileOutputStream(fileDATA);
					
			XMLOutputter sortie = new XMLOutputter();
			sortie.setFormat(Format.getPrettyFormat());
			sortie.output(document, fileEcrire);
			sortie.output(document, System.out);
			        
			fileEcrire.close();
		}
		catch(Exception e) {
		}
		
	}
	
	
	//===================================================================================================================================================================
	//===============================================AFFICHER CONTACTE====================================================================================================
	//==================================================================================================================================================================
	
	

	List <Element>contactList;
	
	
	public void afficher() throws JDOMException, IOException {				//donnee XML ---> donnee en memoire
		
		
		File fileDATA = new File("annuaireDATA.xml");

		
		SAXBuilder fileLire = new SAXBuilder();
		document = fileLire.build(fileDATA);
		racine = document.getRootElement();
		
		
		List <Element>contactList = racine.getChildren("contacte");	//recupere les noeuds du XML et on le met dans une liste
		
		
		for(int i = 0; i < contactList.size() ; i++ ) {
			
			Contacte c = new Contacte(	contactList.get(i).getChild("nom").getValue(),
										contactList.get(i).getChild("prenom").getValue(),
										contactList.get(i).getChild("numtel").getValue(),
										contactList.get(i).getChild("adresse").getValue(),
										contactList.get(i).getChild("email").getValue());
			
			this.listAnnuaire.add(c);
		}
		
		
		//Je ne garde que la racine c'est à dire "personnes"
		
		boolean b = racine.removeChild("contacte");
		
		while(b) {
			b = racine.removeChild("contacte");
		}
		
		//J'enregistre le fichier qui possède la racine "personnes" vide
		
		try {
			
			//on écrit sur le fichier existant
			FileOutputStream fileEcrire = new FileOutputStream(fileDATA);
					
			XMLOutputter sortie = new XMLOutputter();
			sortie.setFormat(Format.getPrettyFormat());
			sortie.output(document, fileEcrire);
			sortie.output(document, System.out);
			        
			fileEcrire.close();
		}
		catch(Exception e) {
		}
		
	}
	
	
	
	
	//========================================================================================================================================================================
	//===============================================SUPPRIMER UN CONTACTE=======================================================================================================
	//=================================================================================================================================================================
	
	
	
	public void supprimer(int indice) {
		this.listAnnuaire.remove(indice);
	}
	
	
	//========================================================================================================================================================================
	//===============================================MODIFIER UN CONTACTE=======================================================================================================
	//=================================================================================================================================================================
	
	public void modifier(int indice, String nom, String prenom, String numtel, String adresse, String email) {
		
		this.listAnnuaire.get(indice).setNom(nom);
		this.listAnnuaire.get(indice).setPrenom(prenom);
		this.listAnnuaire.get(indice).setNumtel(numtel);
		this.listAnnuaire.get(indice).setAdresse(adresse);
		this.listAnnuaire.get(indice).setEmail(email);
		
		
	}
	
	
	//================================================================================================================================================================
	//===============================================RECHERCHER UN CONTACTE==============================================================================================
	//==================================================================================================================================================================
	
	
	List<Integer> intSearchAnnuaire = new ArrayList<Integer>();
	
	
	public void clear() {
		this.intSearchAnnuaire.clear();
	}
	
	
	public void recherche(String nom, String prenom, String numtel, String adresse, String email) {
		
		clear();			//on vide la liste grace a la methode creer plus haut
		
		
		//======================POUR AVOIR L'INDICE et POUVOIR SUPPRIMER OU MODIFIER UN CONTACTE================================================
		
		
		if(nom != "") {
			
			for(int i = 0; i < this.listAnnuaire.size(); i++) {
				
				if( this.listAnnuaire.get(i).getNom().equals(nom) ) {
					this.intSearchAnnuaire.add(i);
				}
			}
		}
		else if(prenom != "") {
			for(int i = 0; i < this.listAnnuaire.size(); i++) {
				
				if( this.listAnnuaire.get(i).getPrenom().equals(prenom) ) {
					this.intSearchAnnuaire.add(i);
					
				}
			}
		}
		else if(numtel != "") {
			for(int i = 0; i < this.listAnnuaire.size(); i++) {
				
				if( this.listAnnuaire.get(i).getNumtel().equals(numtel) ) {
					this.intSearchAnnuaire.add(i);
				}
			}
		}
		else if(adresse != "") {
			for(int i = 0; i < this.listAnnuaire.size(); i++) {
				
				if( this.listAnnuaire.get(i).getAdresse().equals(adresse) ) {
					this.intSearchAnnuaire.add(i);
				}
			}
		}
		else if(email != "") {
			for(int i = 0; i < this.listAnnuaire.size(); i++) {
				
				if( this.listAnnuaire.get(i).getEmail().equals(email) ) {
					this.intSearchAnnuaire.add(i);
				}
			}
		}
		
		
		
	}
	
	
	public List<Integer> getIntSearchAnnuaire() {
		return intSearchAnnuaire;
	}
	public void setIntSearchAnnuaire(List<Integer> indice) {
		this.intSearchAnnuaire = indice;
	}
	
	
	
	
	
	

	public List<Contacte> getAnnuaire() {
		return listAnnuaire;
	}
	public void setAnnuaire(List<Contacte> annuaire) {
		this.listAnnuaire = annuaire;
	}

	
	
}
