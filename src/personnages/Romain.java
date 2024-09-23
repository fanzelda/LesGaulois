package personnages;

public class Romain {
	private String nom;
	private int force;

	public Romain(String nom, int force) {
		if (force<0) {
			throw new IllegalArgumentException("force negative") ;
		}
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");
	}

	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}

	public void recevoirCoup(int forceCoup) {
		if (force<0) {
			throw new IllegalArgumentException("force negative") ;
		}
		int force1 = force;
		force -= forceCoup;
		if (force > 0) {
			parler("Aïe");
		} else {
			parler("J'abandonne...");
		}
		if (force == force1) {
			throw new IllegalArgumentException("force ne change pas") ;
		}
	}
	
	public static void main(String[] args) {
		Romain minus = new Romain("Minus", 8);
		minus.parler("test");
		minus.recevoirCoup(6);;

	}

}
