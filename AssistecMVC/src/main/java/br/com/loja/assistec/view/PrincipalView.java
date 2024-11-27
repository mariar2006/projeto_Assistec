package br.com.loja.assistec.view;

import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;

import java.awt.Font;

public class PrincipalView extends javax.swing.JFrame {
	private static final long serialVersionUID = 1L;
	private JMenu menuRelatorio;
	private JMenu menuCadastro;
	private JLabel lblUsuario;
	private JMenuBar menuBar;
	private JMenu menuArquivo;
	private JMenuItem menuSair;
	private JMenu menuAjuda;
	private JMenuItem menuSobre;
	private JMenuItem menuUsuarios;
	private JPanel panel;

	public PrincipalView() {
		// Definindo os textos dos botões
        UIManager.put("OptionPane.yesButtonText", "Sim");
        UIManager.put("OptionPane.noButtonText", "Não");

		inicializarComponentes();
		configurarJanela();
		configurarLayout();
	}

	// Inicializa e configura os componentes da interface
	private void inicializarComponentes() {
		// Configurando barra de menu
		menuBar = new JMenuBar();

		// Menu "Arquivo"
		menuArquivo = new JMenu("Arquivo");
		menuSair = new JMenuItem("Sair");
		menuSair.setActionCommand("MenuSairAction");
		menuArquivo.add(menuSair);
		menuBar.add(menuArquivo);

		// Menu "Cadastro"
		menuCadastro = new JMenu("Cadastro");
		menuCadastro.setEnabled(false); // Desabilitado para usuários não administradores
		menuUsuarios = new JMenuItem("Usuários");
		menuUsuarios.setActionCommand("MenuUsuariosAction");
		menuCadastro.add(menuUsuarios);
		menuBar.add(menuCadastro);

		// Menu "Relatórios"
		menuRelatorio = new JMenu("Relatórios");
		menuRelatorio.setEnabled(false); // Desabilitado para usuários não administradores
		menuBar.add(menuRelatorio);

		// Menu "Ajuda"
		menuAjuda = new JMenu("Ajuda");
		menuSobre = new JMenuItem("Sobre");
		menuSobre.setActionCommand("MenuSobreAction");
		menuAjuda.add(menuSobre);
		menuBar.add(menuAjuda);

		setJMenuBar(menuBar);

		// Painel para exibir o nome do usuário
		panel = new JPanel();
		lblUsuario = new JLabel();
		lblUsuario.setFont(new Font("Verdana", Font.PLAIN, 14)); // Estilo de fonte
		lblUsuario.setText("Usuário");
		panel.add(lblUsuario);
	}

	// Configura as propriedades da janela
	private void configurarJanela() {
		setTitle("Sistema de Gestão - Tela Principal");
		setBounds(100, 100, 600, 400);
	}

	// Configura o layout da janela
	private void configurarLayout() {
//		JPanel panel = new JPanel();
		GroupLayout layout = new GroupLayout(getContentPane());
		layout.setHorizontalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
					.addContainerGap())
		);
		layout.setVerticalGroup(
			layout.createParallelGroup(Alignment.TRAILING)
				.addGroup(layout.createSequentialGroup()
					.addContainerGap(332, Short.MAX_VALUE)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		getContentPane().setLayout(layout);
	}

	// Adiciona listeners aos itens de menu
	public void addPrincipalViewListener(ActionListener listener) {
		menuUsuarios.addActionListener(listener);
		menuSair.addActionListener(listener);
		menuSobre.addActionListener(listener);
	}

	// Exibe uma confirmação para fechar o sistema
	public int confirmarFecharSistema() {
		return JOptionPane.showConfirmDialog(this, "Tem certeza que deseja sair?", "Atenção",
				JOptionPane.YES_NO_OPTION);
	}

	// Exibe informações sobre o sistema
	public void mostrarSobre() {
		JOptionPane.showMessageDialog(this, "Sistema de Gestão Assistec - Versão 1.0");
	}

	// Personaliza a interface conforme o perfil do usuário
	public void configurarPerfilUsuario(String login, ArrayList<String> permissoes) {
		lblUsuario.setText(login);
		for (String permissao : permissoes) {
			switch (permissao) {
			case "MenuRelatorio":
				menuRelatorio.setEnabled(true);
				break;
			case "MenuCadastro":
				menuCadastro.setEnabled(true);
				break;
			default:
				break;
			}
		}
	}

}