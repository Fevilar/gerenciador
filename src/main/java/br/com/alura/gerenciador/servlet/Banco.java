package br.com.alura.gerenciador.servlet;

import java.util.ArrayList;
import java.util.List;

public class Banco {

	private static List<Empresa> lista = new ArrayList<>();
	
	//------------------------------------------------------
	// Esta parte foi incluida apenas para segurar as empresas 
	// cadastradas como exemplo e teste do código
	
	static {
		Empresa empresa = new Empresa();
		empresa.setNome("Alura");
		empresa.setCnpj("50212532/0001-54");
		Empresa empresa2 = new Empresa();
		empresa2.setNome("Caelum");
		empresa2.setCnpj("75125215/0001-08");
		lista.add(empresa);
		lista.add(empresa2);
	}
	
	//------------------------------------------------------
	
	public void adiciona(Empresa empresa) {
		Banco.lista.add(empresa);
	}
	
	public List<Empresa> getEmpresa() {
		return Banco.lista;
	}
	
}
