package br.com.loja.assistec.view;

	import java.awt.EventQueue;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.sql.SQLException;

	import javax.swing.GroupLayout;
	import javax.swing.GroupLayout.Alignment;
	import javax.swing.JFrame;
	import javax.swing.JLabel;
	import javax.swing.JMenu;
	import javax.swing.JMenuBar;
	import javax.swing.JMenuItem;
	import javax.swing.JOptionPane;

	public class PrincipalView extends JFrame {

		private JMenuItem menuSair;
		private JMenuItem menuSobre;
		private JMenuItem menuUsuarios;
		

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
			
			menuSair = new JMenuItem("Sair");
			menuSair.setActionCommand("MenuSairAction");

			
			menuArquivo.add(menuSair);
			
			JMenu menuCadastro = new JMenu("Cadastro");
			menuCadastro.setEnabled(false);
			menuBar.add(menuCadastro);
			
			menuUsuarios = new JMenuItem("Usuários");
			menuUsuarios.setActionCommand("MenuUsuariosAction");
			
			
			
			menuCadastro.add(menuUsuarios);
			
			JMenu menuRelatorio = new JMenu("Relatórios");
			menuRelatorio.setEnabled(false);
			menuBar.add(menuRelatorio);
			
			JMenu menuAjuda = new JMenu("Ajuda");
			menuBar.add(menuAjuda);
			
			menuSobre = new JMenuItem("Sobre");
			menuSobre.setActionCommand("MenuSobreAction");
			
			menuAjuda.add(menuSobre);
			
			lblUsuario.setText(user);
			
			if("Admin".equalsIgnoreCase(perfil)) {
				menuCadastro.setEnabled(true);
				menuRelatorio.setEnabled(true);
			}

		}
		

		public void addPrincListener(ActionListener listener) {
	        menuSair.addActionListener(listener);
	        menuSobre.addActionListener(listener);
	        menuUsuarios.addActionListener(listener);
	    }
		
		public void mostrarMensagem(String mensagem, String tipo) {
			int messageType = switch (tipo) {
			case "Atenção" -> JOptionPane.WARNING_MESSAGE;
			case "Informação" -> JOptionPane.INFORMATION_MESSAGE;
			case "Erro" -> JOptionPane.ERROR_MESSAGE;
			default -> JOptionPane.PLAIN_MESSAGE;
			};
			JOptionPane.showMessageDialog(this, mensagem, tipo, messageType);
		}
		
		public int SairSistema() {
			int Sair = JOptionPane.showConfirmDialog(null, // tem que terum metodo pra sim e pra nao e tem que retornar inteiro
	                "Tem certeza que deseja sair?",
	                "Atenção", JOptionPane.YES_NO_OPTION);
			return Sair;
		}


}
