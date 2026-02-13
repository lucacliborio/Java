package Model;

public class Matricula {
	Aluno aluno;
	Disciplina disciplina;
	private int n1;
	private int n2;
	
	public Matricula(Aluno aluno, Disciplina disciplina, int n1, int n2) {
		this.aluno = aluno;
		this.disciplina = disciplina;
		this.n1 = n1;
		this.n2 = n2;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public int getN1() {
		return n1;
	}

	public void setN1(int n1) {
		this.n1 = n1;
	}

	public int getN2() {
		return n2;
	}

	public void setN2(int n2) {
		this.n2 = n2;
	}
	
	//metodo
	public double calcularMedia() {
	    return (n1 + n2) / 2;
	}
	
	public String getAprovacao() {
	    if (calcularMedia() >= 7) {
	        return "Aprovado";
	    } else {
	        return "Reprovado";
	    }
	}


	
	

}
