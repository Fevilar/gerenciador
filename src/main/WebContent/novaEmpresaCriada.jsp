<%
 //scriplet - pedacinho de código Java
 String nomeEmpresa = (String)request.getAttribute("empresa");
 String cnpj = (String)request.getAttribute("cnpj");
 System.out.println(nomeEmpresa);
%>





<html><body>
A Empresa: <%= nomeEmpresa %> - CNPJ: <%= cnpj %> - Foi cadastrada com sucesso!
</body></html>

<!-- 

Java service page = JSP 

Dica: Para imprimir no browser, out.println() pode ser trocado por "= ".

-->


