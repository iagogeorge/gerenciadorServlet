<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<body>
Bem vindo ao nosso gerenciador de empresas!<br/>

	<c:if test="${not empty usuarioLogado}">
	
		usuario logado: ${usuarioLogado.email}
	
	</c:if>

<form action="novaEmpresa" method="POST">

nome: <input type="text" name = "nome">
<input type="submit" value ="enviar">

</form>


<form action="login" method="POST">

email: <input type="email" name = "email">
email: <input type="password" name = "senha">

<input type="submit" value ="enviar">

</form>

<form action="logout" method="post">
    <input type="submit" value="Logout" />
</form>

</body>
</html>