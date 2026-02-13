package Main;

import Model.Aluno;
import Model.Disciplina;
import Model.Matricula;
import Model.Professor;

public class teste {

	public static void main(String[] args) {
		
		Aluno aluno = new Aluno("João", "1245", "1");
		System.out.println("Aluno: " + aluno.getNome());
		
		Professor professor = new Professor("Maria", "9898", "mestre");
		System.out.println("Professor: " + professor.getNome());
		
		Disciplina disciplina = new Disciplina("Java", 10, professor);
		System.out.println("Disciplina: " + disciplina.getNome());

		Matricula matricula = new Matricula(aluno, disciplina, 3, 5);
		System.out.println("Status: " + matricula.getAprovacao());
		System.out.println("Status: " + matricula.calcularMedia());
	}
	

}
