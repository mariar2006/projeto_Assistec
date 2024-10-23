package br.com.loja.assistec.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class PrincipalView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrincipalView frame = new PrincipalView(null, null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public PrincipalView(String user, String perfil) {
		setTitle("Sistema de Gestão ASSISTEC");
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblUsuario = new JLabel("");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblUsuario)
					.addContainerGap(378, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(214, Short.MAX_VALUE)
					.addComponent(lblUsuario)
					.addContainerGap())
		);
		getContentPane().setLayout(groupLayout);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menuArquivo = new JMenu("Arquivo");
		menuBar.add(menuArquivo);
		
		JMenuItem menuSair = new JMenuItem("Sair");
		menuSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int sair = JOptionPane.showConfirmDialog(null, 
						"Tem certeza que deseja sair?",
						"Atenção", JOptionPane.YES_NO_OPTION);
				if(sair == 0) {
					System.exit(0);
				}
			}
		});
		menuArquivo.add(menuSair);
		
		JMenu menuCadastro = new JMenu("Cadastro");
		menuCadastro.setEnabled(false);
		menuBar.add(menuCadastro);
		
		JMenuItem menuUsuarios = new JMenuItem("Usuários");
		menuUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listarUsuarios();
			}
		});
		menuCadastro.add(menuUsuarios);
		
		JMenu menuRelatorio = new JMenu("Relatórios");
		menuRelatorio.setEnabled(false);
		menuBar.add(menuRelatorio);
		
		JMenu menuAjuda = new JMenu("Ajuda");
		menuBar.add(menuAjuda);
		
		JMenuItem menuSobre = new JMenuItem("Sobre");
		menuSobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,
						"Sistema de gestão Assistec - Versão 1.0");
				
			}
		});
		menuAjuda.add(menuSobre);
		
		lblUsuario.setText(user);
		
		if("Admin".equalsIgnoreCase(perfil)) {
			menuCadastro.setEnabled(true);
			menuRelatorio.setEnabled(true);
		}

	}

	protected void listarUsuarios() {
		ListarUsuariosView frame = new ListarUsuariosView();
		frame.setLocationRelativeTo(frame);
		frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		frame.setVisible(true);
	}
}
