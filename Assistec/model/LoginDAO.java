package br.com.loja.assistec.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO extends GenericDAO{
	
	//Método para verificar se o banco esta online
	public Boolean bancoOnline()  {
		Connection valor = conectarDAO();
		if (valor != null){
			try {
				conectarDAO().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return true;
		} else
			return false;
	}
	
	
	// Método para autenticar usuários
	public Usuario autenticar(String login, String senha) throws SQLException {
		String sql = "SELECT * FROM USUARIOS WHERE login=? AND senha=?";
		Usuario usuario = null;
		PreparedStatement stmt = conectarDAO().prepareStatement(sql);

		stmt.setString(1, login);
		stmt.setString(2, senha);
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			usuario = new Usuario();
			usuario.setIduser(rs.getInt("iduser"));
			usuario.setNome(rs.getString("nome"));
			usuario.setFone(rs.getString("fone"));
			usuario.setLogin(rs.getString("login"));
			usuario.setSenha(rs.getString("senha"));
			usuario.setPerfil(rs.getString("perfil"));
		}

		rs.close();
		stmt.close();
		conectarDAO().close();

		return usuario;
	}
}
