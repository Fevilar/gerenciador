package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thoughtworks.xstream.XStream;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;


@WebServlet("/empresas")
public class EmpresasService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// http://localhost:8080/gerenciador/empresas
		
		List<Empresa> empresas = new Banco().getEmpresas();
		
				
		/*---------XML------------------------------
		 * Usando a Biblioteca XStream, para envio de respostas do tipo "xml"
		 * lib xmlpull-1.1.3.1.jar e xstream-1.4.18.jar
		 */ 
		XStream xstream = new XStream();
		xstream.alias("empresa", Empresa.class);
		String xml = xstream.toXML(empresas); 

		response.setContentType("application/xml");
		response.getWriter().print(xml);
		
		
		
		/*---------JSON------------------------------
		 * Usando a Biblioteca Gson (Google), para envio de respostas do tipo "json"
		 * Outra biblioteca popular é a Jaxson
		 * lib qson-2.8.5.jar
		 */ 
//		Gson gson = new Gson();
//		String json = gson.toJson(empresas);
//		
//		// Definido o tipo de conteudo
//		response.setContentType("application/json");
//		// Recebe as strings para enviar para a saída (json)
//		response.getWriter().print(json);
				
		
	}

}
