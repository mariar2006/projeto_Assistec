package br.com.loja.assistec.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListarUsuariosView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField txtLocalizar;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListarUsuariosView frame = new ListarUsuariosView();
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
	public ListarUsuariosView() {
		setTitle("Listagem de usuários");
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastrarUsuariosView cadUser = 
						new CadastrarUsuariosView();
				cadUser.setLocationRelativeTo(cadUser);
				cadUser.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				cadUser.setVisible(true);
			}
		});
		btnCadastrar.setBounds(10, 38, 117, 23);
		getContentPane().add(btnCadastrar);
		
		txtLocalizar = new JTextField();
		txtLocalizar.setBounds(139, 39, 252, 20);
		getContentPane().add(txtLocalizar);
		txtLocalizar.setColumns(10);
		
		JButton btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnFechar.setBounds(189, 216, 89, 23);
		getContentPane().add(btnFechar);

	}
}
