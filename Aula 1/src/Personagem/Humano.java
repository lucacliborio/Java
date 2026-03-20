package Personagem;

public class Humano extends Personagem{

	public Humano(String nome, String cor, int forca) {
		super(nome, cor, forca);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void golpear() {
		System.out.println("Humano golpeando");
		
	}

	@Override
	public void defender() {
		System.out.println("Humano defendendo");
		
	}

}
