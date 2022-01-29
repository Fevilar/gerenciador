package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ListaEmpresasServlet
 */
@WebServlet("/listaEmpresas")
public class ListaEmpresasServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		Banco banco = new Banco();
		List<Empresa> lista = banco.getEmpresa();
		
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
