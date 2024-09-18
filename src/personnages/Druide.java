package personnages;

import java.util.*;

public class Druide {

	private String nom;
	private int effetPotionMin;
	private int effetPotionMax;
	private int forcePotion = 1;

	public Druide(String nom, int effetPotionMin, int effetPotionMax) {
		this.nom = nom;
		this.effetPotionMin = effetPotionMin;
		this.effetPotionMax = effetPotionMax;
		parler("Bonjour, je suis le druide " + nom + " et ma potion peut aller d'une force " + effetPotionMin + " à "
				+ effetPotionMax + ".");

	}

	public String getNom() {
		return nom;
	}
	
	public void preparerPotion() {
		Random random;
		random = nextInt(effetPotionMax);
		if (random > 7) {
			parler("J'ai préparé une super potion de force ");
			System.out.println(random);
		} else {

		}
		
	}

	private void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");
	}

	private String prendreParole() {
		return "Le druide " + nom + " : "; 
	}

}
