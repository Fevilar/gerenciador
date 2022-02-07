<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/entrada" var="LinkEntradaServlet"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<!-- O metodo post esconde os parametros no endereço do browser -->
	
	<form action = "${LinkEntradaServlet}" method="post">

		Login: <input type="text" name="login" /> <br /><br />
		Senha: <input type="password" name="senha" /> <br /><br />

		<input type="hidden" name="acao" value="Login" />
		
		<input type="submit" />

	</form>

</body>
</html>
