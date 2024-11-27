package br.com.loja.assistec.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import br.com.loja.assistec.controller.UsuarioController;

public class CadastrarUsuariosView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField txtNome;
	private JTextField txtFone;
	private JTextField txtLogin;
	private JLabel lblNewLabel_1;
	private JPasswordField txtSenha;
	public JComboBox<String> cbPerfil;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarUsuariosView frame = new CadastrarUsuariosView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CadastrarUsuariosView() {
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel painelSuperior = new JPanel();
		getContentPane().add(painelSuperior, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Cadastro de usuários");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		painelSuperior.add(lblNewLabel);
		
		JPanel painelInferior = new JPanel();
		getContentPane().add(painelInferior, BorderLayout.SOUTH);
		
		JButton btnIncluir = new JButton("Incluir");
		btnIncluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (!"".equalsIgnoreCase(txtLogin.getText())
						&& !"".equalsIgnoreCase(new String(txtSenha.getPassword()))) {
					UsuarioController uc = new UsuarioController();
					try {
						String perfil = (String) cbPerfil.getSelectedItem();
						uc.salvar(txtNome.getText(), txtFone.getText(), txtLogin.getText(),
								new String(txtSenha.getPassword()), perfil);
						JOptionPane.showMessageDialog(null, "Contato salvo com sucesso!", "Mensagem",
								JOptionPane.INFORMATION_MESSAGE);
						// Recria o arraylist de usuarios após salvar
//						ArrayList<Usuario> novosUsuarios = uc.listarUsuarios();
						// Pede para a Tabela ser atualizada
//						listarUsuariosView.atualizarTabela(novosUsuarios);
//						limparCampos();
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(null, "Nao foi possivel salvar contato!n" + e1.getMessage());

					}
				} else {
					JOptionPane.showMessageDialog(null, "Confira os campos Login e Senha");
				}
				
			}
		});
		painelInferior.add(btnIncluir);
		
		JButton btnExcluir = new JButton("Excluir");
		painelInferior.add(btnExcluir);
		
		JButton btnFechar = new JButton("Fechar");
		painelInferior.add(btnFechar);
		
		JPanel painelCentral = new JPanel();
		getContentPane().add(painelCentral, BorderLayout.CENTER);
		painelCentral.setLayout(new GridLayout(6, 2, 0, 0));
		
		lblNewLabel_1 = new JLabel("Nome");
		painelCentral.add(lblNewLabel_1);
		
		txtNome = new JTextField();
		painelCentral.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Fone");
		painelCentral.add(lblNewLabel_5);
		
		txtFone = new JTextField();
		painelCentral.add(txtFone);
		txtFone.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Login");
		painelCentral.add(lblNewLabel_4);
		
		txtLogin = new JTextField();
		painelCentral.add(txtLogin);
		txtLogin.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Senha");
		painelCentral.add(lblNewLabel_3);
		
		txtSenha = new JPasswordField();
		painelCentral.add(txtSenha);
		
		JLabel lblNewLabel_2 = new JLabel("Perfil");
		painelCentral.add(lblNewLabel_2);
		
		cbPerfil = new JComboBox<>(new String[] { "User", "Admin" });
		
		painelCentral.add(cbPerfil);

	}

}