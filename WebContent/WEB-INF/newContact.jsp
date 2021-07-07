
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>



<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="CSS/styleMenu.css" />
		<link rel="stylesheet" href="CSS/styleNewContact.css" />
		<link rel="icon" href="Images/logo.ico" />
		<title>Ajouter Contact</title>
	</head>
	<body>
		<header>
				<%@ include file = "/WEB-INF/index.jsp" %>
		</header>
		
		 <c:if test="${ boutonAjouter != null }"> <h2 class="alertAddContact">Contact Rajouter !!</h2></c:if>
		 <c:set var="boutonAjouter" value="${ null}"/>
		 
			<div class="formsAjouter">
			    <form action="general" method="post">
			    	
			    	<h1>Ajouter un nouveau Contact</h1>
			    		
					<input class="inputs" type ="text" id="nom" name="nom" autocomplete="off" placeholder="Entrez un Nom"/>
			        <input class="inputs" type ="text" id="prenom" name="prenom" autocomplete="off" placeholder="Entrez un Prenom"/>
			       	<input class="inputs" type ="tel" id ="numtel" name="numtel" autocomplete="off" placeholder="Entrez un Téléphone"/>
			        <input class="inputs" type ="text" id="adresse" name="adresse" autocomplete="off" placeholder="Entrez une Adresse"/>
			        <input class="inputs" type ="email" id="email" name="email" autocomplete="off" placeholder="Entrez un Email"/>
			        	
			        <input type="hidden" name="ajouterContacte">
			        <input type="submit" id="boutonAjouter" value="Ajouter"/>
			        
			    </form>
			</div>
			
	</body>
</html>