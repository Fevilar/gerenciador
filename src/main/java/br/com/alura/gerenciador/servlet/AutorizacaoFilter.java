package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


//@WebFilter("/entrada") //Transferido para web.xml para ordenar a entrada
public class AutorizacaoFilter extends HttpFilter implements Filter {

	/* Anota��es n�o nos permitem definir a ordem dos filtros, 
	 * para isso precisamos utilizar o web.xml. Ou seja, quando 
	 * precisamos definir uma ordem de aplica��o dos filtros,
	 * devemos optar pelo uso do web.xml.
	 */

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {

		System.out.println("AutorizacaoFilter");
		
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		
		String paramAcao = request.getParameter("acao");
		
		HttpSession sessao = request.getSession();
		boolean usuarioNaoLogado = (sessao.getAttribute("usuarioLogado") == null);
		boolean ehUmaAcaoProtegida = !(paramAcao.equals("Login") || paramAcao.equals("LoginForm"));
		
		if(ehUmaAcaoProtegida && usuarioNaoLogado) { // Se usu�rio n�o est� logado = true
			response.sendRedirect("entrada?acao=LoginForm");
			return; // Sai da execu��o do c�digo.
		}
		
		//executa a ac��o e chama o pr�ximo filtro.
		chain.doFilter(request, response);
	}


}
