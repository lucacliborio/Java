package Personagem;

public class Majin extends Personagem {

	public Majin(String nome, String cor, int forca) {
		super(nome, cor, forca);
		
	}
	
	public void transformarEmChocolate() {
		System.out.println("Transformar em chocolate");
	}

	@Override
	public void golpear() {
		System.out.println("Majin golpeando");
		
	}

	@Override
	public void defender() {
		System.out.println("Majin defendendo");
		
	}

}
