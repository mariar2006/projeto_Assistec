package br.com.loja.Assistec.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class PrincipalView extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;
	public JMenu MenuRelatorio;
	public JMenu MenuUsuarios;
	public JLabel lblUsuario;
	private JMenuBar menuBar;
	private JMenu menuArquivo;
	private JMenuItem menuSair;
	private JMenu menuAjuda;
	private JMenuItem menuSobre;
	private JMenuItem menuUsuariosCadastrar;

	public PrincipalView(String user, String perfil) {
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("Sistema de Gestão - Tela Principal");
		setBounds(100, 100, 541, 358);
		setResizable(false);

		lblUsuario = new javax.swing.JLabel();
		menuBar = new javax.swing.JMenuBar();
		menuArquivo = new javax.swing.JMenu();
		menuSair = new javax.swing.JMenuItem();
		MenuUsuarios = new javax.swing.JMenu();

		MenuRelatorio = new javax.swing.JMenu();
		menuAjuda = new javax.swing.JMenu();
		menuSobre = new javax.swing.JMenuItem();

		lblUsuario.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		lblUsuario.setText("Usuário");

		// Configurando Menu "Arquivo"
		menuArquivo.setText("Arquivo");

		menuSair.setText("Sair");
		menuSair.addActionListener(evt -> menuSairActionPerformed(evt));
		menuArquivo.add(menuSair);

		menuBar.add(menuArquivo);

		// Configurando Menu "Cadastro de Usuários"
		MenuUsuarios.setText("Usuarios");
		MenuUsuarios.setEnabled(false); // Desabilitado por padrão para usuários não administradores
		menuBar.add(MenuUsuarios);

		menuUsuariosCadastrar = new JMenuItem("Cadastrar");
		MenuUsuarios.add(menuUsuariosCadastrar);

		// Configurando Menu "Relatórios"
		MenuRelatorio.setText("Relatórios");
		MenuRelatorio.setEnabled(false); // Desabilitado por padrão para usuários não administradores
		menuBar.add(MenuRelatorio);

		// Configurando Menu "Ajuda"
		menuAjuda.setText("Ajuda");

		menuSobre.setText("Sobre");
		menuSobre.addActionListener(evt -> menuSobreActionPerformed(evt));
		menuAjuda.add(menuSobre);

		menuBar.add(menuAjuda);

		setJMenuBar(menuBar);
		
		lblUsuario.setText(user);
		if("Admin.".equalsIgnoreCase(perfil)) {
			MenuUsuarios.setEnabled(true);
			MenuRelatorio.setEnabled(true);
			
		}

		// Layout do JFrame
		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(30, 30, 30).addComponent(lblUsuario)
						.addContainerGap(330, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(30, 30, 30).addComponent(lblUsuario)
						.addContainerGap(250, Short.MAX_VALUE)));

		pack();

		


	}



	private void menuSairActionPerformed(java.awt.event.ActionEvent evt) {
		int sair = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja sair?", "Atenção",
				JOptionPane.YES_NO_OPTION);
		if (sair == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}

	private void menuSobreActionPerformed(java.awt.event.ActionEvent evt) {
		JOptionPane.showMessageDialog(null, "Sistema de Gestão Assistec - Versão 1.0");
	}
	
	protected void listarUsuarios() {
		ListarUsuariosView frame = new ListarUsuariosView(); {
			frame.setLocationRelativeTo(frame);
			frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			frame.setVisible(true);
		}				
	}

}