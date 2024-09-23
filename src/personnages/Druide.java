package personnages;

import java.util.*;

public class Druide {

	private String nom;
	private int effetPotionMin;
	private int effetPotionMax;
	private int forcePotion = 1;
	private Random rand = new Random();

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
		Random rando = rand;
		int random = rando.nextInt(effetPotionMax - effetPotionMin + 1) + effetPotionMin;
		if (random > 7) {
			parler("J'ai préparé une super potion de force " + random + ".");
		} else {
			parler("Je n'ai pas trouvé tous les ingrédients, ma potion est seulement de force "
					+ random + ".");
		}
		forcePotion = random;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");
	}

	private String prendreParole() {
		return "Le druide " + nom + " : ";
	}

	public void booster(Gaulois gaulois) {
		if ("Obélix".equals(gaulois.getNom())) {
			parler("Non, Obélix !... Tu n’auras pas de potion magique !");
		} else {
			gaulois.boirePotion(forcePotion);
		}
	}
	
	public static void main(String[] args) {
		Druide panoramix = new Druide("Panoramix", 5, 10);
		panoramix.preparerPotion();
		panoramix.preparerPotion();
		panoramix.preparerPotion();
		panoramix.preparerPotion();
		panoramix.preparerPotion();

	}

}
