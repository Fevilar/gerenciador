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

	/* Anotações não nos permitem definir a ordem dos filtros, 
	 * para isso precisamos utilizar o web.xml. Ou seja, quando 
	 * precisamos definir uma ordem de aplicação dos filtros,
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
		
		if(ehUmaAcaoProtegida && usuarioNaoLogado) { // Se usuário não está logado = true
			response.sendRedirect("entrada?acao=LoginForm");
			return; // Sai da execução do código.
		}
		
		//executa a acção e chama o próximo filtro.
		chain.doFilter(request, response);
	}


}
