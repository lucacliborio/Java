package Model;

public class Professor {
	private String nome;
	private String cpf;
	private String titulo;
	
	public Professor(String nome, String cpf, String titulo) {
		this.nome = nome;
		this.cpf = cpf;
		this.titulo = titulo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	
}
