package personnages;
import villagegaulois.Musee;

public class Gaulois {

	private String nom;
	private int force;
	private int nbtrophees;
	private int effetPotion = 1;
	private Equipement[] trophees = new Equipement[100];

	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "� " + texte + "�");
	}

//	private String prendreParole() {
//		return "Le gaulois " + nom + ":";
//	}

	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}

//	public void frapper(Romain romain) {
//		System.out.println(nom + " envoie un grand coup dans la m�choire de " + romain.getNom());
//		romain.recevoirCoup((force / 3) * effetPotion);
//	}

	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la m�choire de " + romain.getNom());
		Equipement[] troph = romain.recevoirCoup((force / 3) * effetPotion);
		for (int i = 0; troph != null && i < troph.length; i++, nbtrophees++) {
			this.trophees[nbtrophees] = troph[i];
		}
	}

	public void boirePotion(int forcePotion) {
		effetPotion = forcePotion;
		parler("Merci Druide, je sens que ma force est " + forcePotion + " fois d�cupl�e.");
	}

//	@Override
//	public String toString() {
//		return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";
//	}
	
	public void faireUneDonation(Musee musee) {
		if (nbtrophees > 0) {
			String texte = "Je donne au musee tous mes trophees :";
			while (nbtrophees > 0) {
				nbtrophees--;
				musee.donnerTrophees(this, trophees[nbtrophees]);
				texte += "\n - " + trophees[nbtrophees];
				trophees[nbtrophees] = null;
			}
			parler(texte);
		}
	}


	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Ast�rix", 8);
		Romain minus = new Romain("Minus", 8);
		asterix.parler("test");
		asterix.prendreParole();
		asterix.frapper(minus);
		System.out.println(asterix);

	}
}
