package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

//@WebFilter("/entrada") //Transferido para web.xml para ordenar a entrada
public class MonitoramentoFilter implements Filter{


	/* Aqui pode monitorar o app com:
	 * - Tempo de execução;
	 * - Quem esta logando; etc.
	 */
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		System.out.println("MonitoramentoFilter");
		
		long antes = System.currentTimeMillis();
		
		String acao = request.getParameter("acao"); // Pega o nome da ação que está executando no momento
		
		//executa a acção e chama o próximo filtro.
		chain.doFilter(request, response);
		
		long depois = System.currentTimeMillis();		
		System.out.println("Tempo de execução da ação: " + acao + " -> " + (depois - antes));
		
	}

}
