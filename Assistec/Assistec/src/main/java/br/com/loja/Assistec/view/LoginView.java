package br.com.loja.Assistec.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import br.com.loja.Assistec.controller.LoginController;

public class LoginView extends JFrame {

	private static final long serialVersionUID = 1L;
	public JTextField txtLogin;
	public JPasswordField txtSenha;
	public JButton btnLogin;
	public JLabel lblStatus;
	private JLabel lblUsuario;
	private JLabel lblSenha;

	public LoginView() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				LoginController lc = new LoginController();
				
				try {
					if (lc.verificarBancoOnline()) {
//					 System.out.println("conectado");
//		            view.lblStatus.setText("Conectado!");
						lblStatus.setIcon(new ImageIcon(getClass().getResource("/br/com/loja/Assistec/icones/dbok.png")));
					} else {
//			        	System.out.println("conectado");
//			            view.lblStatus.setText("Não Conectado!");
						lblStatus.setIcon(new ImageIcon(getClass().getResource("/br/com/loja/Assistec/icones/dberror.png")));
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		initComponents();
	}

	public void initComponents() {
		lblUsuario = new JLabel();
		lblSenha = new JLabel();
		txtLogin = new JTextField();
		txtSenha = new JPasswordField();
		btnLogin = new JButton();
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					onClickBtnLogin();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		lblStatus = new JLabel();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setTitle("CRUD - LOGIN");
		setResizable(false);
		getRootPane().setDefaultButton(btnLogin);

		lblUsuario.setText("Usuário");

		lblSenha.setText("Senha");

		btnLogin.setText("Login");

		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(37)
							.addComponent(lblStatus))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(189)
							.addComponent(btnLogin))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(130)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblSenha, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblUsuario))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(txtSenha, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtLogin, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(180, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(60, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUsuario)
						.addComponent(txtLogin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSenha)
						.addComponent(txtSenha, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
					.addGap(35)
					.addComponent(btnLogin)
					.addGap(22)
					.addComponent(lblStatus)
					.addGap(61))
		);
		getContentPane().setLayout(groupLayout);
		pack();
		setLocationRelativeTo(null);
	}

	// método para clicar no btão e acionar o método autenticar()
	protected void onClickBtnLogin() throws SQLException {
		ArrayList<String> autenticado = new ArrayList<>();
		
		// pre validação
		if(txtLogin.getText() != null && 
				!txtLogin.getText().isEmpty() &&
				String.valueOf(txtSenha.getPassword()) != null &&
				!String .valueOf(txtSenha.getPassword()).isEmpty()){
			LoginController lc = new LoginController();
			
			// chamar o m´todo do controle (autenticar)
			try {
				autenticado = lc.autenticar(txtLogin.getText(), new String (txtSenha.getPassword()));
				if(autenticado.get(0) != null) {
					JOptionPane.showMessageDialog(this, "Bem Vindo " + autenticado.get(0) + "acesso liberado!", "Atnção", JOptionPane.INFORMATION_MESSAGE);
					dispose();
					//PrincipalView prinipal = new PrincipalView(user, perfil );
					
					}
			} catch (NullPointerException n) {
				JOptionPane.showMessageDialog(this, "Erro");
				n.printStackTrace();
			}
					
				}
			
		else {
			
		}
	}
}