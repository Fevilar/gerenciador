package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

//@WebServlet("/listaEmpresas")
public class ListaEmpresasServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		Banco banco = new Banco();
		List<Empresa> lista = banco.getEmpresas();
		
		request.setAttribute("empresas", lista);
		
		RequestDispatcher rd = request.getRequestDispatcher("/listaEmpresas.jsp");
//		request.setAttribute("empresa", empresas.getNome()); // Inclui um atributo para envio ao jsp
//		request.setAttribute("cnpj", empresas.getCnpj());
		rd.forward(request, response);
		
		// Resposta HTML
//		PrintWriter out = response.getWriter();
//		out.println("<html><body>");
//		out.println("<ul>");
//		out.println("LISTA DE EMPRESAS CADASTRADAS <br>");	// <br> pula uma linha		
//		for (Empresa empresa : lista) {
//			out.println("<li>" + empresa.getNome() + " - CNPJ: " + empresa.getCnpj() + "</li>");
//		}
//		out.println("</ul>");
//		out.println("</body></html>");
		
	}

}
