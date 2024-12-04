package br.com.loja.assistec.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.com.loja.assistec.model.Usuario;
import br.com.loja.assistec.view.CadastrarUsuariosView;

public class CadastrarUsuarioController {
	private CadastrarUsuariosView cadastrarView;
	private ListarUsuarioController listarController;
	private Usuario usuarioSelecionado;
	
	public CadastrarUsuarioController(
			ListarUsuarioController listarUsuariosController,
			Usuario user) {
		this.usuarioSelecionado = user;
		this.listarController = listarUsuariosController;
		cadastrarView = new CadastrarUsuariosView(user);
		cadastrarView.setLocationRelativeTo(null);
		cadastrarView.setVisible(true);
		configurarListeners();
	}

	private void configurarListeners() {
		cadastrarView.addCadastrarUsuariosListener(new CadastrarUsuariosListener());
	}
	
	private class CadastrarUsuariosListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			switch(e.getActionCommand()) {
			case "BotaoFecharAction":
				cadastrarView.dispose();
				break;
			case "BotaoExcluirAction":
//				metodoExcluir();
				break;
			case "BotaoIncluirAction":
//				metodoAlterarOuIncluir();
				break;
			default:
				break;
			}
		}
		
	}

}
