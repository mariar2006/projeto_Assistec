package br.com.loja.Assistec.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.loja.Assistec.model.LoginDAO;
import br.com.loja.Assistec.model.Usuario;

public class LoginController {

	public LoginController() {
		
	}
	
	// método para vrificar se o banco está online
	public Boolean verificarBancoOnline() throws SQLException {
		LoginDAO dao = new LoginDAO();
		
		return dao.bancoOnline();
	}
	
	// método qu faz autenticação
	public ArrayList<String> autenticar(String login, String senha) throws SQLException{
		ArrayList<String> listaDados = new ArrayList<>();
		LoginDAO dao = new LoginDAO();
		Usuario user = dao.autenticar(login, senha);
		listaDados.add(0, user.getLogin());
		listaDados.add(1, user.getSenha());
		
		
		return listaDados;
	}
}