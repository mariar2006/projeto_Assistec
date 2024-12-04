package br.com.loja.assistec.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.loja.assistec.model.Usuario;
import br.com.loja.assistec.model.UsuarioDAO;
import br.com.loja.assistec.view.ListarUsuariosView;
import br.com.loja.assistec.view.MensagemView;

public class ListarUsuarioController {
	private ListarUsuariosView listarView;
	
	public ListarUsuarioController() throws SQLException {
		listarView = new ListarUsuariosView();
		listarView.setLocationRelativeTo(null);
		listarView.setVisible(true);
		configurarListeners();
		carregarUsuarios();
	}
	
	public void configurarListeners() {
		listarView.addListarUsuariosListener(new ListarUsuariosListener());
		listarView.addWindowListener(new JanelaAberturaListener());
		listarView.addTabelaMouseListener(new TabelaMouseClickListener());
	}

	public void carregarUsuarios() throws SQLException {
		try {
		ArrayList<Usuario> listaUsuarios = listarUsuarios();
		if(!listaUsuarios.isEmpty()) {
			listarView.mostrarUsuariosTabela(listaUsuarios);
		}
	} catch (SQLException e) {
		new MensagemView("Erro ao carregar usuários!",0);
	}
	}
	
	public ArrayList<Usuario> listarUsuarios() throws SQLException{
		UsuarioDAO dao = new UsuarioDAO();
		return dao.selecionarUsuarios();
	}
	
	//Classe que trata o evento do clique na tabela
	private class TabelaMouseClickListener extends MouseAdapter{
		
		public void mouseClicked(MouseEvent e) {
			if (e.getButton() == MouseEvent.BUTTON1) {
				//Selecionar o usuario
				System.out.println("clicado no botao esquerdo do mouse");
			}
		}
	}
	
	//Classe que trata os eventos de botao
	private class ListarUsuariosListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String comando = e.getActionCommand();
			switch (comando) {
			case "BotaoCadastrarAction": 
				abrirCadastroUsuario(null);
				break;
			case "BotaoFecharAction":
				listarView.dispose();
				break;
			default:
				break;
			}
		}
		
	}
	
	public void abrirCadastroUsuario(Usuario usuarioSelecionado) {
		new CadastrarUsuarioController(this, usuarioSelecionado);
	}
	
	private class JanelaAberturaListener extends WindowAdapter{
		public void windowOpened(WindowEvent e) {
			try {
				carregarUsuarios();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
}
