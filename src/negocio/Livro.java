package negocio;

public class Livro {
	private int id;
	private String nome;
	private int qtde;
	
	
	public Livro(int id, String nome, int _qtde) {
		this(nome);
		this.setId(id);
		this.setQtde(_qtde);
	}

	public Livro(String nome, int _qtde) {
		this(nome);
		this.setQtde(_qtde);
	}
	public Livro(String nome) {
		this();
		this.setNome(nome);
	}
	
	public Livro() {
		this.setQtde(1);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getQtde() {
		return qtde;
	}
	public void setQtde(int qtde) {
		this.qtde = qtde;
	}
	
}
