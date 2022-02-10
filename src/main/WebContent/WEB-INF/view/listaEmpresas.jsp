<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, br.com.alura.gerenciador.modelo.Empresa"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LISTA DE EMPRESAS</title>
</head>
<body>
	<c:import url="Logout-parcial.jsp" />

	Usuario Logado: ${ usuarioLogado.login } 
	
	<br>
	<br>
	<br>
	
	<c:if test="${not empty empresa}">
		A Empresa: ${ empresa } - CNPJ: ${ cnpj } - Foi cadastrada com sucesso!
		<br>	
		<br />	
	</c:if>
		
	
	LISTA DE EMPRESAS: <br />	
	
	<ul>
		<c:forEach items="${empresas}" var="empresa">
			
			<li>
				${empresa.nome} - CNPJ: ${empresa.cnpj} - <fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy"/>
				<a href="/gerenciador/entrada?acao=MostraEmpresa&id=${empresa.id }">Editar</a>
				<a href="/gerenciador/entrada?acao=RemoveEmpresa&id=${empresa.id }">Remover</a>
			</li>
		</c:forEach>	
	</ul>
	 
</body>
</html>



<!-- 
JSP significa Java Server Pages

JSP é uma página automaticamente processada pelo Tomcat

Para gerar HTML dinamicamente no JSP usamos Scriptlets

Um scriptlet <% %> é um código Java dentro do HTML

Um scriptlet só funciona em uma página JSP

Usamos o RequestDispatcher para chamar um JSP a partir da servlet

Obtemos o RequestDispatcher a partir do HttpServletRequest

Usamos a requisição para colocar ou pegar um atributo 
(setAttribute(.., ..) ou getAttribute(..))
-->