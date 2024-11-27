package br.com.loja.assistec.view;

import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField txtLogin;
	private JPasswordField txtSenha;
	private JButton btnLogin;
	private JLabel lblStatus;
	private JLabel lblLogin;
	private JLabel lblSenha;

	public LoginView() {
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("ASSISTEC - LOGIN");

		lblLogin = new JLabel("Login");
		lblLogin.setBounds(102, 63, 53, 14);
		lblSenha = new JLabel("Senha");
		lblSenha.setBounds(102, 102, 64, 14);
		txtLogin = new JTextField();
		txtLogin.setBounds(176, 60, 127, 20);
		txtSenha = new JPasswordField();
		txtSenha.setBounds(176, 98, 128, 22);
		btnLogin = new JButton("Entrar");
		btnLogin.setActionCommand("BotaoLoginAction");
		btnLogin.setBounds(179, 155, 76, 23);

		lblStatus = new JLabel();
		lblStatus.setBounds(10, 213, 63, 37);

		getRootPane().setDefaultButton(btnLogin);
		getContentPane().setLayout(null);
		getContentPane().add(lblStatus);
		getContentPane().add(btnLogin);
		getContentPane().add(lblSenha);
		getContentPane().add(lblLogin);
		getContentPane().add(txtSenha);
		getContentPane().add(txtLogin);
	}

	public void addLoginListener(ActionListener listener) {
		btnLogin.addActionListener(listener);
	}

	public void mostrarBancoOnline(Boolean online) {
		String iconPath = online ? "/br/com/loja/assistec/icones/dbok.png" : "/br/com/loja/assistec/icones/dberror.png";
		lblStatus.setIcon(new ImageIcon(getClass().getResource(iconPath)));
	}

	public String getLogin() {
		return txtLogin.getText();
	}

	public String getSenha() {
		return new String(txtSenha.getPassword());
	}

	/*public void mostrarMensagem(String mensagem, String tipo) {
		int messageType = switch (tipo) {
		case "Atenção" -> JOptionPane.WARNING_MESSAGE;
		case "Informação" -> JOptionPane.INFORMATION_MESSAGE;
		case "Erro" -> JOptionPane.ERROR_MESSAGE;
		default -> JOptionPane.PLAIN_MESSAGE;
		};
		JOptionPane.showMessageDialog(this, mensagem, tipo, messageType);
	}*/
}
