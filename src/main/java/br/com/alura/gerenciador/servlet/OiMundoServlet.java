package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * Aprendemos que o Tomcat s� instancia a servlet quando realmente 
 * ocorre uma requisi��o. Isso � o comportamento padr�o que podemos
 * alterar facilmente! 
 * A anota��o @WebServlet possui um atributo loadOnStartup que muda
 * esse comportamento:
 * 
 * Ao reiniciar o Tomcat ser� criado o objeto da servlet OiMundoServlet e
 * consequentemente aparece no console a mensagem definida no construtor. 
 * Ou seja, o Tomcat n�o � t�o pregui�oso n�o :)
 */

//oi
@WebServlet(urlPatterns= {"/oi"})
public class OiMundoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	// Construtor padr�o (n�o necess�rio) alterado para demostra��o do loadOnStartup
	public OiMundoServlet() {
        System.out.println("Criando Oi Mundo Servlet");
    }

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
