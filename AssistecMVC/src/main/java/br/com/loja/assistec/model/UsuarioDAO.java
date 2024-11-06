package br.com.loja.assistec.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UsuarioDAO extends GenericDAO {

	// Método para salvar usuarios
	public void salvar(Usuario usuario) throws SQLException {
		String insert = "INSERT INTO USUARIOS(nome, fone, login, senha, perfil) VALUES(?,?,?,?,?)";
		save(insert, usuario.getNome(), usuario.getFone(), usuario.getLogin(), usuario.getSenha(), usuario.getPerfil());
	}

	// Método para alterar usuarios
	public void alterar(Usuario usuario) throws SQLException {
		String update = "UPDATE USUARIOS " + "SET nome = ?, fone = ?, login = ?, senha = ?, perfil = ? "
				+ "WHERE IDUSER = ?";
		update(update, usuario.getIduser(), usuario.getNome(), usuario.getFone(), usuario.getLogin(),
				usuario.getSenha(), usuario.getPerfil());
	}

	// Método para excluir usuarios
	public void excluir(long id) throws SQLException {
		String delete = "DELETE FROM USUARIOS WHERE IDUSER = ?";
		delete(delete, id);
	}

	// Método para buscar usuários
	public ArrayList<Usuario> selecionarUsuarios() throws SQLException {
		ArrayList<Usuario> usuarios = new ArrayList<>();
		String sql = "SELECT * FROM USUARIOS";
		PreparedStatement pstm = conectarDAO().prepareStatement(sql);

		ResultSet rs = pstm.executeQuery();

		while (rs.next()) {
			Usuario usuario = new Usuario();
			usuario.setIduser(rs.getInt("iduser"));
			usuario.setNome(rs.getString("nome"));
			usuario.setFone(rs.getString("fone"));
			usuario.setLogin(rs.getString("login"));
			usuario.setSenha(rs.getString("senha"));
			usuario.setPerfil(rs.getString("perfil"));
			usuarios.add(usuario);
		}

		rs.close();
		pstm.close();
		conectarDAO().close();

		return usuarios;
	}

	// Método para buscar um usuário por ID
	public Usuario selecionarUsuario(Long iduser) throws SQLException {
		Usuario usuario = new Usuario();
		String sql = "SELECT * FROM USUARIOS WHERE IDUSER = ?";
		PreparedStatement pstm = conectarDAO().prepareStatement(sql);
		pstm.setLong(1, iduser);
		ResultSet rs = pstm.executeQuery();
		while (rs.next()) {
			usuario.setIduser(rs.getLong("iduser"));
			usuario.setNome(rs.getString("nome"));
			usuario.setFone(rs.getString("fone"));
			usuario.setLogin(rs.getString("login"));
			usuario.setSenha(rs.getString("senha"));
			usuario.setPerfil(rs.getString("perfil"));
		}

		rs.close();
		pstm.close();
		conectarDAO().close();

		return usuario;
	}

}
