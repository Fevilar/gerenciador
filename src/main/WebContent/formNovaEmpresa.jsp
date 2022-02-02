<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/novaEmpresa" var="LinkServletNovaEmpresa"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<!-- O metodo post esconde os parametros no endereço do browser -->
	
	<form action = "${LinkServletNovaEmpresa}" method="post">
	
		Nome: <input type="text" name="nome" /> 
		CNPJ: <input type="text" name="cnpj" /> <br />
		Data Abertura: <input type="text" name="data" /> <br />
		
		<input type="submit" />
		
	
	
	</form>

</body>
</html>
