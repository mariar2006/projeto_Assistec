package br.com.loja.assistec.model;

public class Usuario {
	private long iduser;
	private String nome;
	private String fone;
	private String login;
	private String senha;
	private String perfil;

	public Usuario(String nome, String fone, String login, String senha, String perfil) {
		this.nome = nome;
		this.fone = fone;
		this.login = login;
		this.senha = senha;
		this.perfil = perfil;
	}

	public long getIduser() {
		return iduser;
	}

	public void setIduser(long iduser) {
		this.iduser = iduser;
	}

	public Usuario(String login, String senha, String perfil) {
		this.login = login;
		this.senha = senha;
		this.perfil = perfil;
	}

	public Usuario() {

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getFone() {
		return fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

}
