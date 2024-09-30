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
		assert verifierforce();
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

//	public void recevoirCoup(int forceCoup) {
//		int force1 = force;
//		force -= forceCoup;
//      assert verifierforce();
//		if (force > 0) {
//			parler("Aïe");
//		} else {
//			parler("J'abandonne...");
//		}
//		assert (force1 < force);

	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		// précondition
		int oldForce = force;
		forceCoup = calculResistanceEquipement(forceCoup);
		if (forceCoup >= 0) {
			force -= forceCoup;
		}
		assert verifierforce();
		 if (force > 0) {
		 parler("Aïe");
		 } else {
		 equipementEjecte = ejecterEquipement();
		 parler("J'abandonne...");
		 }
		// post condition la force a diminuée
		assert force < oldForce;
		return equipementEjecte;
	}

	public boolean verifierforce() {
		return (force >= 0);
	}

	private int calculResistanceEquipement(int forceCoup) {
		String texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
		int resistanceEquipement = 0;
		if (nbEquipements != 0) {
			for (int i = 0; i < nbEquipements; i++) {
				if ((equipements[i] != null && equipements[i].equals(Equipement.BOUCLIER))) {
					resistanceEquipement += 8;
				} else {
					System.out.println("Equipement casque");
					resistanceEquipement += 5;
				}

			}
			texte = texte + "\nMais heureusement, grace à mon équipement sa force est diminué de "
					+ resistanceEquipement + "!";
		}
		parler(texte);
		forceCoup -= resistanceEquipement;
		return forceCoup;

	}

	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipements];
		System.out.println("L'équipement de " + nom + " s'envole sous la force du coup.");
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipements; i++) {
			if (equipements[i] != null) {
				equipementEjecte[nbEquipementEjecte] = equipements[i];
				nbEquipementEjecte++;
				equipements[i] = null;
			}
		}
		return equipementEjecte;
	}

	private static final String SOLDAT = "Le soldat ";

	public void sEquiper(Equipement equipement) {
		switch (nbEquipements) {
		case 0:
			ajouterEquipement(equipement);
			break;
		case 1:
			if (equipements[0] != null && equipement.equals(equipements[0])) {
				System.out.println(SOLDAT + nom + " possede deja un " + equipement + " ! ");
			} else {
				ajouterEquipement(equipement);
			}
			break;
		case 2:
			System.out.println(SOLDAT + nom + " est deja bien protege !");
			break;
		default:
			break;
		}
	}

	private void ajouterEquipement(Equipement equipement) {
		System.out.println(SOLDAT + nom + " s'equipe avec un " + equipement + " ! ");
		equipements[nbEquipements] = equipement;
		nbEquipements++;
	}

	public static void main(String[] args) {
		Romain minus = new Romain("Minus", 8);
		minus.parler("test");
		minus.recevoirCoup(6);
		Equipement casque = Equipement.CASQUE;
		System.out.println(casque);
		Equipement bouclier = Equipement.BOUCLIER;
		System.out.println(bouclier);
		minus.sEquiper(casque);
		minus.sEquiper(casque);
		minus.sEquiper(bouclier);
		minus.sEquiper(bouclier);

	}

	public int getForce() {
		return force;
	}

}
