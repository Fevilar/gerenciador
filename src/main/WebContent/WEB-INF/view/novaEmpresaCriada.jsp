<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
	<body>
	
		<c:import url="Logout-parcial.jsp" />
		
		<c:if test="${not empty empresa}">
			A Empresa: ${ empresa } - CNPJ: ${ cnpj } - Foi cadastrada com sucesso!
		</c:if>
		
		<c:if test="${empty empresa}">
			Nenhuma empresa foi cadastrada!
		</c:if>
		
	</body>
</html>



<!-- 
Java service page = JSP 
Dica: Para imprimir no browser, out.println() pode ser trocado por "= ".
-->


