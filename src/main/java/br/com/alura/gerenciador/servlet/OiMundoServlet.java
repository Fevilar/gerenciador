package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//oi
@WebServlet(urlPatterns = "/oi")
public class OiMundoServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter out = resp.getWriter();
		out.println("<html>");												// Inicio c�digo HTML
		out.println("<body>");												// In�cio do "corpo" do c�digo
		out.println("Oi mundo, parabens vc escreveu o primeiro servlets."); // C�digo
		out.println("</body>");												// Fim do "corpo"
		out.println("</html>");												// Fim do c�digo HTML
		
		
	}
	
}
