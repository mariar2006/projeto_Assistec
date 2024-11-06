package br.com.loja.assistec.model;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class UsuarioTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	private static final String[] colunas = { "ID", "Nome", "Telefone", "Login", "Perfil" };
	private ArrayList<Usuario> usuariosList;

	// Método construtor que recebe um arrayList de usuários
	public UsuarioTableModel(ArrayList<Usuario> usuarios) {
		this.usuariosList = usuarios;
	}

	//Método que retorna o número de linhas
	@Override
	public int getRowCount() {
		return usuariosList.size();
	}

	// Método que retorna o número de colunas
	@Override
	public int getColumnCount() {
		return colunas.length;
	}

	// Método para obter o valor da célula passando a linha e coluna
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Usuario usuario = usuariosList.get(rowIndex);
		if (columnIndex == 0) {
			return usuario.getIduser();
		} else if (columnIndex == 1) {
			return usuario.getNome();
		} else if (columnIndex == 2) {
			return usuario.getFone();
		} else if (columnIndex == 3) {
			return usuario.getLogin();
		} else if (columnIndex == 4) {
			return usuario.getPerfil();
		} else {
			return null;
		}
	}

	// Método para obter o nome da coluna
	@Override
	public String getColumnName(int column) {
		return colunas[column];
	}

	// Método para recarregar os dados do banco
	public void carregarDados(ArrayList<Usuario> novosUsuarios) {
		this.usuariosList = novosUsuarios; // Atualiza a lista
		fireTableDataChanged(); // Notifica a JTable que os dados mudaram
	}

}
