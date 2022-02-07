package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.acao.Acao;

@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/*
	 * CONTROLLER - A função do controlador é receber as requisições e delegar as
	 * chamadas para as ações correspondentes.
	 */

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// http://localhost:8080/gerenciador/entrada?acao=ListaEmpresas
		String paramAcao = request.getParameter("acao");

		String nomeDaClasse = "br.com.alura.gerenciador.acao." + paramAcao;
		
		// ** Atenção ** newIstance() está riscado pois possivelmente pode ser eliminado ou substituido no Java.
		String nome;
		try {
			Class classe = Class.forName(nomeDaClasse); //Carrega a classe com o nome do parâmetro que está contido em "nomeDaClasse"
			Acao acao = (Acao) classe.newInstance(); 	// classe usa teu construtor para criar uma nova instância.
			nome = acao.executa(request, response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | ServletException| IOException e) {
			throw new ServletException(e);
		}
		
		String[] tipoEEndereco = nome.split(":");
		if(tipoEEndereco[0].equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + tipoEEndereco[1]);
			rd.forward(request, response);
		}else {
			response.sendRedirect(tipoEEndereco[1]);
		}
		
//		String nome = null;
//		if (paramAcao.equals("ListaEmpresas")) {
//			ListaEmpresas acao = new ListaEmpresas();
//			nome = acao.executa(request, response);
//		} else if (paramAcao.equals("RemoveEmpresa")) {
//			RemoveEmpresa acao = new RemoveEmpresa();
//			nome = acao.executa(request, response);
//		} else if (paramAcao.equals("MostraEmpresa")) {
//			MostraEmpresa acao = new MostraEmpresa();
//			nome = acao.executa(request, response);
//		} else if (paramAcao.equals("AlteraEmpresa")) {
//			AlteraEmpresa acao = new AlteraEmpresa();
//			nome = acao.executa(request, response);
//		} else if (paramAcao.equals("NovaEmpresa")) {
//			NovaEmpresa acao = new NovaEmpresa();
//			nome = acao.executa(request, response);
//		} else if (paramAcao.equals("NovaEmpresaForm")) {
//			NovaEmpresaForm acao = new NovaEmpresaForm();
//			nome = acao.executa(request, response);
//		}
		
		/* "split" separa o "nome" pelo caractere informado ":" ficando uma parte [0] e outra parte [1]
		 * no caso de listaEmpresa que recebe uma String "foward:listaEmpresa.jsp",
		 * fica assim: [0]=forward e [1]=listaEmpresa.jsp 
		 */
		

	}

}
