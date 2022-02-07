package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * Aprendemos que o Tomcat só instancia a servlet quando realmente 
 * ocorre uma requisição. Isso é o comportamento padrão que podemos
 * alterar facilmente! 
 * A anotação @WebServlet possui um atributo loadOnStartup que muda
 * esse comportamento:
 * 
 * Ao reiniciar o Tomcat será criado o objeto da servlet OiMundoServlet e
 * consequentemente aparece no console a mensagem definida no construtor. 
 * Ou seja, o Tomcat não é tão preguiçoso não :)
 */

//oi
@WebServlet(urlPatterns= {"/oi"})
public class OiMundoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	// Construtor padrão (não necessário) alterado para demostração do loadOnStartup
	public OiMundoServlet() {
        System.out.println("Criando Oi Mundo Servlet");
    }

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter out = resp.getWriter();
		out.println("<html>");												// Inicio código HTML
		out.println("<body>");												// Início do "corpo" do código
		out.println("Oi mundo, parabens vc escreveu o primeiro servlets."); // Código
		out.println("</body>");												// Fim do "corpo"
		out.println("</html>");												// Fim do código HTML
		
		
	}
	
}
