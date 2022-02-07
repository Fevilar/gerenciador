package br.com.alura.gerenciador.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Banco {

	private static List<Empresa> lista = new ArrayList<>();
	private static List<Usuario> listaUsuarios = new ArrayList<>();

	// provisório, pois não tem o banco de dados (Sql, Oracle, etc).
	private static Integer chaveSequencial = 1;

	// ------------------------------------------------------
	// Esta parte foi incluida apenas para segurar as empresas
	// cadastradas como exemplo e teste do código

	static {
		//Incluindo Empresas para Teste
		Empresa empresa = new Empresa();
		empresa.setId(chaveSequencial++);
		empresa.setNome("Alura");
		empresa.setCnpj("50212532/0001-54");
		Empresa empresa2 = new Empresa();
		empresa2.setId(chaveSequencial++);
		empresa2.setNome("Caelum");
		empresa2.setCnpj("75125215/0001-08");
		lista.add(empresa);
		lista.add(empresa2);
		
		//Incluindo Usuários para Teste
		Usuario u1 = new Usuario();
		u1.setLogin("felipe");
		u1.setSenha("123456");
		Usuario u2 = new Usuario();
		u2.setLogin("user");
		u2.setSenha("123456");
		listaUsuarios.add(u1);
		listaUsuarios.add(u2);
		
	}

	// ------------------------------------------------------

	public void adiciona(Empresa empresa) {
		empresa.setId(Banco.chaveSequencial++);
		Banco.lista.add(empresa);
	}

	public List<Empresa> getEmpresas() {
		return Banco.lista;
	}

	public void removeEmpresa(Integer id) {

		Iterator<Empresa> it = lista.iterator();

		while (it.hasNext()) {
			Empresa emp = it.next();

			if (emp.getId() == id) {
				it.remove();
			}
		}
	}

	public Empresa buscaEmpresaPelaId(Integer id) {
		for (Empresa empresa : lista) {
			if (empresa.getId() == id) {
				return empresa;
			}
		}
		return null;
	}

	public Usuario existeUsuario(String login, String senha) {
	    for(Usuario usuario : listaUsuarios) {
	        if(usuario.ehIgual(login, senha)) {
	            return usuario;
	        }
	    }
	    return null;
	}
	
	

}
