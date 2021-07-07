package com.sdzee.beans;



public class Contacte{
	
	
	private String Nom;
	private String Prenom;
	private String Numtel;
	private String Adresse;
	private String Email;
	
	public Contacte() {
		
	}
	
	public Contacte(String nom, String prenom, String numtel, String adresse, String email) {
		this.Nom = nom;
		this.Prenom = prenom;
		this.Numtel = numtel;
		this.Adresse = adresse;
		this.Email = email;
	}
	
	
	
	
	
	public void setNom(String nom) {
		this.Nom = nom;
	}
	public String getNom() {
		return this.Nom;
	}
	
	
	
	public void setPrenom(String prenom) {
		this.Prenom = prenom;
	}
	public String getPrenom() {
		return this.Prenom;
	}
	
	
	
	public void setNumtel(String numtel) {
		this.Numtel = numtel;
	}
	public String getNumtel() {
		return this.Numtel;
	}
	
	
	
	public void setAdresse(String adresse) {
		this.Adresse = adresse;
	}
	public String getAdresse() {
		return this.Adresse;
	}
	
	

	public void setEmail(String email) {
		this.Email = email;
	}
	public String getEmail() {
		return this.Email;
	}
	
	
}
