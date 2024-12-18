package br.com.loja.assistec.view;

import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
//import javax.swing.table.TableRowSorter;
//import br.com.loja.assistec.model.UsuarioTableModel;

import br.com.loja.assistec.model.Usuario;
import br.com.loja.assistec.model.UsuarioTableModel;

public class ListarUsuariosView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField txtLocalizar;
	private JButton btnCadastrar;
	private JButton btnFechar;
	private JTable tabela;
	private UsuarioTableModel usuarioTableModel;
//	private TableRowSorter<UsuarioTableModel> rowSorter;
	private JScrollPane scroolPane;

	
	public ListarUsuariosView() {
		inicializarComponentes();
		configurarJanela();
	}
	
	public void inicializarComponentes() {
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setActionCommand("BotaoCadastrarAction");
		btnCadastrar.setBounds(39, 34, 103, 33);
		
		txtLocalizar = new JTextField();
		txtLocalizar.setBounds(154, 34, 416, 33);
		
		btnFechar = new JButton("Fechar");
		btnFechar.setActionCommand("BotaoFecharAction");
		btnFechar.setBounds(269, 337, 89, 33);
		
		tabela = new JTable();
		scroolPane = new JScrollPane(tabela);
		scroolPane.setBounds(39,95,530,215);
		
		setLayout(null);
		add(btnCadastrar);
		add(btnFechar);
		add(txtLocalizar);
		add(scroolPane);
	}
	
	public void configurarJanela() {
		setTitle("Listagem de usuários");
		setBounds(100, 100, 650, 420);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void addListarUsuariosListener(ActionListener listener) {
		btnCadastrar.addActionListener(listener);
		btnFechar.addActionListener(listener);
	}

	public void mostrarUsuariosTabela(ArrayList<Usuario> listaUsuarios) {
		usuarioTableModel = new UsuarioTableModel(listaUsuarios);
		tabela.setModel(usuarioTableModel);
	}
	
	//Adiciona um listener para os eventos do clique na tabela
	public void addTabelaMouseListener(MouseListener listener) {
		tabela.addMouseListener(listener);
	}
	
	//Retorna a linha selecionada no JTable
	public int getLinhaSelecionada() {
		return tabela.getSelectedRow();
	}
	
	public Object getValorLinhaColuna(int linha, int coluna) {
		return tabela.getValueAt(linha, coluna);
	}

	public void atualizarTabelaUsuarios(ArrayList<Usuario> novosUsuarios) {
		usuarioTableModel.carregarDados(novosUsuarios);
		
	}
	
	
	
	
	
	
	

	
	}