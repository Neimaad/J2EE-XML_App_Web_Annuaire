

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x" %>


	
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="CSS/styleMenu.css" />
		<link rel="stylesheet" href="CSS/styleListing.css" />
		<link rel="icon" href="Images/logo.ico" />
		<title>Liste des Contacts</title>
	</head>
	<body>
		
		<header>
			<%@ include file = "/WEB-INF/index.jsp" %>
		</header>
		
	   	<section class="listing">
		   	<h1>Liste des Contacts :</h1>
		   
		   
		   	<c:if test="${ supprimerContacte != null }"> <h2 class="delDisplayContact">Contact Supprimer !!</h2></c:if>
		   	<c:set var="supprimerContacte" value="${ null}"/>
		   	
		   	<c:if test="${ modifierContacte != null }"> <h2 class="modifDisplayContact">Contact Modifier !!</h2></c:if>
		   	<c:set var="modifierContacte" value="${ null}"/>
		   	
			<div class="contacts">
				<c:forEach items="${ Contacts}" var="contact" varStatus="status">
					
					<div class="contact">
						<c:choose>
							<c:when test="${ modifier == status.index }">
								
								<form action="general" method="post">
									<p>Nom : <input type ="text" id="nom" name="nom" value="${ contact.nom }"/></p>
				        			<p>Prénom : <input type ="text" id="prenom" name="prenom" value="${ contact.prenom }"/></p>
				       				<p>NumTel : <input type ="tel" id ="numtel" name="numtel" value="${ contact.numtel }"/></p>
					        		<p>Adresse : <input type ="text" id="adresse" name="adresse" value="${ contact.adresse }"/></p>
					        		<p>Email : <input type ="email" id="email" name="email" value="${ contact.email }"/></p>
				        			
				        			<div class="bouttons">
										<input	type="hidden" name="modifierContacte" value="${status.index }">
										<input	type="submit" value="Modifier le contact">
									</div>
								</form>
									
								<c:set var="modifier" value="${ null}"/>
									
							</c:when>
								
							<c:otherwise>
								<p>Nom : <c:out value="${ contact.nom }"></c:out></p>
								<p>Prenom : <c:out value="${ contact.prenom }"></c:out></p>
								<p>Numtel : <c:out value="${ contact.numtel }"></c:out></p>
								<p>Adresse : <c:out value="${ contact.adresse }"></c:out></p>
								<p>Email : <c:out value="${ contact.email }"></c:out></p>
									
								<div class="bouttons">
									<form action="general" method="post">
										<input	type="hidden" name="supprimerContacte" value="${status.index }">
										<input	type="submit" value="Supprimez le contact">
									</form>
									
									<form action="displayContact" method="post">
										<input	type="hidden" name="modifier" value="${status.index }">
										<input	type="submit" value="Modifier">
									</form>
								</div>
						
							</c:otherwise>
						</c:choose> 
					</div>
				</c:forEach>
			</div>
		</section>	
	</body>
</html>