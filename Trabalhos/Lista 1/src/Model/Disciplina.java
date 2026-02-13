package Model;

public class Disciplina {
	private String nome;
	private int cargahoraria;
	Professor professor;
	
	public Disciplina(String nome, int cargahoraria, Professor professor) {
		this.nome = nome;
		this.cargahoraria = cargahoraria;
		this.professor = professor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCargahoraria() {
		return cargahoraria;
	}

	public void setCargahoraria(int cargahoraria) {
		this.cargahoraria = cargahoraria;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}


	
}
