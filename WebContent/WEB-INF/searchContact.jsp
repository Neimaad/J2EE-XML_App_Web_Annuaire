<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x" %>    

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="CSS/styleMenu.css" />
		<link rel="stylesheet" href="CSS/styleSearch.css" />
		<link rel="icon" href="Images/logo.ico" />
		<title>Recherche Contact</title>
	</head>
	<body>
	
		
		<div class="searchContact">
			<header>
				<%@ include file = "index.jsp" %>
			</header>
			
			<c:if test="${ supprimerContacteRechercher != null }"> <h2 class="delSearchContact">Contact Supprimer !!</h2></c:if>
			<c:set var="supprimerContacteRechercher" value="${ null}"/>
			
			<c:if test="${ modifierContacteRechercher != null }"> <h2 class="modifSearchContact">Contact Modifier !!</h2></c:if>
			<c:set var="modifierContacteRechercher" value="${ null}"/>
			
			<h1>Bonjour, <br/> Qui recherchez-vous ?</h1>
	
			<div class="formsSearch">
				<form action="general" method="post" >
					<div class="inputs">
						<input type="text" name="nom" placeholder="Nom">
						<input type="text" name="prenom" placeholder="Prénom">
						<input type="tel" name="numtel" placeholder="Téléphone">
						<input type="text" name="adresse" placeholder="Adresse postale">
						<input type="email" name="email" placeholder="Adresse Email">
					</div>
					<input type="hidden" name="rechercherContacte">
					<input type="submit" id="boutonRechercher" value="">
				</form>
			</div>
			<div class="filtre"> 
				<div class="elem-filtre">Nom</div>
				<div class="elem-filtre">Prénom</div>
				<div class="elem-filtre">Adresse</div>
				<div class="elem-filtre">Email</div>
				<div class="elem-filtre">Num de Tel</div>
			</div>
			
		</div>
		
		<section class="displayResearch">
			
			<c:if test="${!empty searchAnnuaire }"><h1>Résultat de la recherche : </h1></c:if>
		   
			<div class="contacts">
				<c:forEach items="${ searchAnnuaire}" var="search" varStatus="status">
					
						<div class="contact">
							<c:choose>
								<c:when test="${ modifier == status.index }">
									
									<form action="general" method="post">
										<p>Nom : <input type ="text" id="nom" name="nom" value="${ contact[search].nom }"/></p>
					        			<p>Prénom : <input type ="text" id="prenom" name="prenom" value="${ contact[search].prenom }"/></p>
					       				<p>NumTel : <input type ="tel" id ="numtel" name="numtel" value="${ contact[search].numtel }"/></p>
					        			<p>Adresse : <input type ="text" id="adresse" name="adresse" value="${ contact[search].adresse }"/></p>
					        			<p>Email : <input type ="email" id="email" name="email" value="${ contact[search].email }"/></p>
				        				
				        				<div class="buttons">
											<input	type="hidden" name="modifierContacteRechercher" value="${search }">
											<input	type="submit" value="Modifier le contact">
										</div>
									</form>
									
									<c:set var="modifier" value="${ null}"/>
									
								</c:when>
								
								<c:otherwise>
									<div class="infoContact">
										<p>Nom : <c:out value="${ contact[search].nom }"></c:out></p>
										<p>Prenom : <c:out value="${ contact[search].prenom }"></c:out></p>
										<p>Numtel : <c:out value="${ contact[search].numtel }"></c:out></p>
										<p>Adresse : <c:out value="${ contact[search].adresse }"></c:out></p>
										<p>Email : <c:out value="${ contact[search].email }"></c:out></p>
										
										<div class="buttons">
											<form action="general" method="post">
												
													<input	type="hidden" name="supprimerContacteRechercher" value="${search }">
													<input	type="submit" value="Supprimez le contact">
											</form>
											
											<form action="general" method="post">
												
													<input	type="hidden" name="modifier" value="${status.index }">
													<input	type="submit" value="Modifier">	
											</form>
										</div>
									</div>
								</c:otherwise>
							</c:choose> 
						</div>
						<c:set var="searchAnnuaire" value="${ null}"/>
						
				</c:forEach>
				
			</div>
		</section>
		
	</body>
</html>