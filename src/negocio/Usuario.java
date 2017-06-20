package negocio;

import java.util.List;

public class Usuario {

	private int id;
	private String nome;
	private String login;
	private String senha;
	private String email;
	private List<Usuario> amigos;
	
	public Usuario(int id, String nome, String login, String senha, String email) {
		this(nome, email, login, senha);
		this.id = id;
		this.email = email;
	}
	public Usuario(String nome, String email, String login, String senha) {
		this(login,senha);
		this.setNome(nome);
		this.setEmail(email);
	}
	public Usuario(String login, String senha) {
		this.setLogin(login);
		this.setSenha(senha);
	}
	public Usuario(int id, String email){
		this.setId(id);
		this.setEmail(email);
	}
	public Usuario() {
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<Usuario> getAmigos() {
		return amigos;
	}
	public void setAmigos(List<Usuario> amigos) {
		this.amigos = amigos;
	}
}
