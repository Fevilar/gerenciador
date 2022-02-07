<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/entrada?acao=NovaEmpresa" var="LinkEntradaServlet"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<!-- O metodo post esconde os parametros no endereço do browser -->
	
	<form action = "${LinkEntradaServlet}" method="post">
	
		Nome: <input type="text" name="nome" /> 
		CNPJ: <input type="text" name="cnpj" /> <br />
		Data Abertura: <input type="text" name="data" /> <br />
		<input type="hidden" name="acao" value="NovaEmpresa" />
		
		<input type="submit" />
			
	</form>

</body>
</html>
