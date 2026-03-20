package teste;

import Personagem.Humano;
import Personagem.Majin;
import Personagem.Personagem;

public class teste {

	public static void main(String[] args) {
		Personagem p1 = new Humano("Kuririn", "Branco,", 1000);
		p1.golpear();
		
		p1 = new Majin("Boo", "Rosa", 800);
		p1.golpear();
		
		
	}

}
