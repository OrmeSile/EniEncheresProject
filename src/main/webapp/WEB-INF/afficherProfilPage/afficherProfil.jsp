<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<title>Profil</title>
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
	
	<p>Pseudo : ${requestScope.user.pseudo}</p>
	<p>Nom : ${requestScope.user.nom}</p>
	<p>Prénom : ${requestScope.user.prenom}</p>
	<p>Email : ${requestScope.user.email}</p>
	<p>Téléphone : ${requestScope.user.telephone}</p>
	<p>Rue : ${requestScope.user.rue}</p>
	<p>Code Postal : ${requestScope.user.codePostal}</p>
	<p>Ville : ${requestScope.user.ville}</p>
	
	<c:if test="${sessionScope.utilisateur.noUtilisateur eq requestScope.utilisateur.noUtilisateur}">
	<div>
	
	<a href=<c:url value="/monProfil"/>><button class="button" id="modifierProfil">Modifier</button></a>
	</div>
	</c:if>
</body>
</html>