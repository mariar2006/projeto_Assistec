package br.com.loja.assistec.view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.com.loja.assistec.model.Usuario;

public class CadastrarUsuariosView extends JFrame {
    private static final long serialVersionUID = 1L;
    private JButton btnFechar;
    private JButton btnIncluir;
    private JButton btnExcluir;
    private JTextField txtNome;
    private JTextField txtFone;
    private JTextField txtLogin;
    private JPasswordField txtSenha;
    private JComboBox<String> cbPerfil;

    public CadastrarUsuariosView(Usuario usuarioSelecionado) {
    	// Definindo os textos dos botões
        setTitle("Cadastro de Usuários");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        setLocationRelativeTo(null);
        initComponents();
    }

    private void initComponents() {
        JPanel contentPane = new JPanel(new BorderLayout());
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        JLabel lblTitulo = new JLabel("Cadastro de Usuários", JLabel.CENTER);
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 14));
        contentPane.add(lblTitulo, BorderLayout.NORTH);

        JPanel panelCampos = new JPanel(new GridLayout(6, 2));
        txtNome = new JTextField(20);
        txtFone = new JTextField(20);
        txtLogin = new JTextField(20);
        txtSenha = new JPasswordField(20);
        cbPerfil = new JComboBox<>(new String[]{"User", "Admin"});

        panelCampos.add(new JLabel("Nome:"));
        panelCampos.add(txtNome);
        panelCampos.add(new JLabel("Fone:"));
        panelCampos.add(txtFone);
        panelCampos.add(new JLabel("Login:"));
        panelCampos.add(txtLogin);
        panelCampos.add(new JLabel("Senha:"));
        panelCampos.add(txtSenha);
        panelCampos.add(new JLabel("Perfil:"));
        panelCampos.add(cbPerfil);
        contentPane.add(panelCampos, BorderLayout.CENTER);

        JPanel panelBotoes = new JPanel();
        btnIncluir = new JButton("Incluir");
        btnIncluir.setActionCommand("BotaoIncluirAction");
        btnExcluir = new JButton("Excluir");
        btnExcluir.setActionCommand("BotaoExcluirAction");
        btnExcluir.setVisible(false);
        btnFechar = new JButton("Fechar");
        btnFechar.setActionCommand("BotaoFecharAction");

        panelBotoes.add(btnIncluir);
        panelBotoes.add(btnExcluir);
        panelBotoes.add(btnFechar);
        contentPane.add(panelBotoes, BorderLayout.SOUTH);
        pack();
    }

    public void addCadastrarUsuariosListener(ActionListener listener) {
    	btnIncluir.addActionListener(listener);
    	btnExcluir.addActionListener(listener);
    	btnFechar.addActionListener(listener);
    }

    public void preencherCampos(Usuario usuarioSelecionado) {
        txtNome.setText(usuarioSelecionado.getNome());
        txtFone.setText(usuarioSelecionado.getFone());
        txtLogin.setText(usuarioSelecionado.getLogin());
        txtSenha.setText(usuarioSelecionado.getSenha());
        cbPerfil.setSelectedItem(usuarioSelecionado.getPerfil());
    }

    public void limparCampos() {
        txtNome.setText("");
        txtFone.setText("");
        txtLogin.setText("");
        txtSenha.setText("");
        cbPerfil.setSelectedItem("User");
    }

   
    public String getLogin() {
        return txtLogin.getText();
    }

    public String getSenha() {
        return new String(txtSenha.getPassword());
    }

    public String getNome() {
        return txtNome.getText();
    }

    public String getFone() {
        return txtFone.getText();
    }




}



