package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NovaEmpresaServlet
 */
@WebServlet("/novaEmpresa")
public class NovaEmpresaServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	/*  No browser - (Chrome, Internet Explorer, etc.)
	 * http://localhost:8080/gerenciador/novaEmpresa?nome=Alura&cnpj=50218654000123
	 */ 
	
	/* O m�todo service d� suporte para ambos m�todos (GET e POST)
	 * O m�todo doPost s� � capaz de lidar com requisi��es do tipo post.
	 * O m�todo doGet s� � capaz de lidar com requisi��es do tipo get.
	 * Os m�todos service e doPost tem a mesma assinatura (mesmo retorno, mesmos par�metros, mesmas exce��es).
	 */
	
//	protected void service(HttpServletRequest request, HttpServletResponse response) 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("Cadastrando Nova Empresa!");
		
		String nomeEmpresa = request.getParameter("nome");
		String cnpj = request.getParameter("cnpj");
		Empresa empresa = new Empresa();
		empresa.setNome(nomeEmpresa);
		empresa.setCnpj(cnpj);
		
		// Simulando um banco de dados
		Banco banco = new Banco();
		banco.adiciona(empresa);
		
		//chamar o JSP
		RequestDispatcher rd = request.getRequestDispatcher("/novaEmpresaCriada.jsp");
		request.setAttribute("empresa", empresa.getNome());
		request.setAttribute("cnpj", empresa.getCnpj());
		rd.forward(request, response);
		
		
				
	}

}
