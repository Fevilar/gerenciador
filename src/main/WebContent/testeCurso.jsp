<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
  	<body>
     	<c:forEach var="i" begin="1" end="10" step="2">
       		${i} <br />
     	</c:forEach>
  	</body>
</html>

<!-- Imprime os numeros conforme abaixo:
	1
	3
	5
	7
	9
--> 