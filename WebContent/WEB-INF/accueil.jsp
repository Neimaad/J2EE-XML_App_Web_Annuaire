<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="CSS/styleMenu.css" />
		<link rel="stylesheet" href="CSS/styleAccueil.css" />
		<link rel="icon"  href="Images/logo.ico" />
		<title>Accueil</title>
	</head>
	<body>
		<header>
			<%@ include file="index.jsp" %>
		</header>
		
		<div class="message">
			<div id="slider">
				<div class="elem-slide">
					<div class="text">
						<h1>Bienvenue à tous !</h1>
						<p>
							Site présenté par : <br>
							- CHERRIER Dylan (38004487)<br>
							- LAOUSSING Damien (37006987)<br>
						</p>
					</div>
					<a href="#">En savoir plus ...</a>
				</div>
				<div class="elem-slide">
					<div class="text">
						<h1>Ne perdez plus rien !</h1>
						<p>
							Le Lorem Ipsum est simplement du faux texte employé dans la composition et la mise en page avant impression.
							 Le Lorem Ipsum est le faux texte standard de l'imprimerie depuis les années 1500, quand un imprimeur anonyme assembla
							  ensemble des morceaux de texte pour réaliser un livre spécimen de polices de texte. Il n'a pas fait que survivre 
							  cinq siècles, mais s'est aussi adapté à la bureautique informatique, sans que son contenu n'en soit modifié.
						</p>
					</div>
					<a href="#">En savoir plus ...</a>
				</div>
				<div class="elem-slide">
					<div class="text">
						<h1> Ajouter des contacts!!</h1>
						<p>
							Le Lorem Ipsum est simplement du faux texte employé dans la composition et la mise en page avant impression.
							 Le Lorem Ipsum est le faux texte standard de l'imprimerie depuis les années 1500, quand un imprimeur anonyme assembla
							  ensemble des morceaux de texte pour réaliser un livre spécimen de polices de texte. Il n'a pas fait que survivre 
							  cinq siècles, mais s'est aussi adapté à la bureautique informatique, sans que son contenu n'en soit modifié. 
						</p>
					</div>
					<a href="#">En savoir plus ...</a>
				</div>
				<div class="elem-slide">
					<div class="text">
						<h1>Trouvez un contact</h1>
						<p>
							Le Lorem Ipsum est simplement du faux texte employé dans la composition et la mise en page avant impression.
							 Le Lorem Ipsum est le faux texte standard de l'imprimerie depuis les années 1500, quand un imprimeur anonyme assembla
							  ensemble des morceaux de texte pour réaliser un livre spécimen de polices de texte. Il n'a pas fait que survivre 
							  cinq siècles, mais s'est aussi adapté à la bureautique informatique, sans que son contenu n'en soit modifié. 
						</p>
					</div>
					<a href="#">En savoir plus ...</a>
				</div>
			</div>
		</div>
		
		<div class="ctr">
			<div id="line1"></div>
			<div id="line2"></div>
			<div id="line3"></div>
			<div id="line4"></div>
			
			<div id="active"></div>
		</div>
		
		<script type="text/javascript">
			var slider = document.getElementById('slider');
			var active = document.getElementById('active');
			var line1 = document.getElementById('line1');
			var line2 = document.getElementById('line2');
			var line3 = document.getElementById('line3');
			var line4 = document.getElementById('line4');
			
			line1.onclick = function(){
				slider.style.transform = 'translateX(0)';
				active.style.top = '0px';
			}
			
			line2.onclick = function(){
				slider.style.transform = 'translateX(-25%)';
				active.style.top = '100px';
			}
			
			line3.onclick = function(){
				slider.style.transform = 'translateX(-50%)';
				active.style.top = '200px';
			}
			
			line4.onclick = function(){
				slider.style.transform = 'translateX(-75%)';
				active.style.top = '300px';
			}
		
		</script>
	
	</body>
</html>