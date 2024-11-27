package br.com.loja.assistec.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import br.com.loja.assistec.model.Usuario;
import br.com.loja.assistec.view.ListarUsuariosView;

public class ListarUsuarioController {
	public ListarUsuariosView viewL;

	public ListarUsuarioController() {
		viewL = new ListarUsuariosView();
		viewL.setLocationRelativeTo(null);
		viewL.setVisible(true);
		configurarListeners();
		carregarUsuarios();
	}

	private void configurarListeners() {

		viewL.addListarUsuariosListeners(new ListarUsuariosListener());
		viewL.addWindowListener(new JanelaAberturaListener());
	}

	private void carregarUsuarios() {

	}

	
	private class ListarUsuariosListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String comando = e.getActionCommand();
			switch(comando) {
			case "BotaoCadastrarAction":
				abrirCadastroUsuario(null);
				break;
			case "BotaoFecharAction":
				viewL.dispose();
				
			default:
				break;
			}
		}
	}


	public void abrirCadastroUsuario(Usuario usuarioSelecionado) {
		//new CadastrarUsuaioController(this, usuarioSlecionado);
	}
	
	public class JanelaAberturaListener extends WindowAdapter{
		public void windowOpened(WindowEvent e) {
			carregarUsuarios();
		}
	}
}
