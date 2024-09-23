package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements = new Equipement[2];
	private int nbEquipements = 0;

	public Romain(String nom, int force) {
		if (force < 0) {
			throw new IllegalArgumentException("force negative");
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
		if (force < 0) {
			throw new IllegalArgumentException("force negative");
		}
		int force1 = force;
		force -= forceCoup;
		if (force > 0) {
			parler("Aïe");
		} else {
			parler("J'abandonne...");
		}
		if (force > force1) {
			throw new IllegalArgumentException("force ne change pas");
		}
	}

	public void sEquiper(Equipement equipement) {
		switch(nbEquipements) {
		case 0:
			System.out.println("Le soldat " + nom + " s'equipe avec un " + equipement + " ! ");
			equipements[0]= equipement;
			nbEquipements++;
			break;
		case 1:
			if (equipements[0]!=null && equipement.equals(equipements[0])) {
				System.out.println("Le soldat " + nom + " possede deja un " + equipement + " ! ");
			}
			else {
				System.out.println("Le soldat " + nom + " s'equipe avec un " + equipement + " ! ");
				equipements[1]= equipement;
				nbEquipements++;
			}
			break;
		case 2:
			System.out.println("Le soldat " + nom + " est deja bien protege !");
			break;
		default : 
			break;
		}
	}

	public static void main(String[] args) {
		Romain minus = new Romain("Minus", 8);
		minus.parler("test");
		minus.recevoirCoup(6);
		;
		Equipement casque = Equipement.CASQUE;
		System.out.println(casque);
		Equipement bouclier = Equipement.BOUCLIER;
		System.out.println(bouclier);
		minus.sEquiper(casque);
		minus.sEquiper(casque);
		minus.sEquiper(bouclier);
		minus.sEquiper(bouclier);
		
		
	}

}
