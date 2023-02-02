<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<title>Page d'accueil</title>
<jsp:include page="/WEB-INF/fragments/_bootstrap-import.jsp" />
</head>
<body>
	<div class="container-fluid">
		<header
			class="row navbar navbar-expand-md bg-dark-subtle d-flex align-content-between">
			<div class="col-2">
				<jsp:include page="/WEB-INF/fragments/_header.jsp" />
			</div>
		</header>
	</div>
	
	
	

	<form action="<%=request.getContextPath() %>/ServletAfficherProfil" method="post">
		<label for="Pseudo">Pseudo : </label><input type="text" id="Pseudo" name="Pseudo" />
		<br/>
		<label for="Nom">Nom : </label><input type="text" id="Nom" name="Nom" />
		<br/>
		<label for="Prenom">Prénom :</label><input type="text" id="Prenom" name="Prenom"/>
		<br/>
		<label for="Email">Email :</label><input type="text" id="Email" name="Email"/>
		<br/>
		<label for="Telephone">Téléphone :</label><input type="text" id="Telephone" name="Telephone"/>
		<br/>
		<label for="Rue">Rue :</label><input type="text" id="Rue" name="Rue"/>
		<br/>
		<label for="cp">Code Postal :</label><input type="text" id="cp" name="cp" />
		<br/>
		<label for="Ville">Ville :</label><input type="text" id="Ville" name="Ville"/>
	
	</form>
	
</body>
</html>