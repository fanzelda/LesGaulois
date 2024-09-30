package personnages;


public class Village {
	private String nom;
	private Chef chef;
	private Gaulois[] villageois;
	private int nbVillageois = 0;

	public Village(String nom, int nbVillageoisMaximum) {
		this.nom = nom;
		villageois = new Gaulois[nbVillageoisMaximum];
	}

	public void setChef(Chef chef) {
		this.chef = chef;
	}

	public String getNom() {
		return nom;
	}
	
	public void ajouterHabitant(Gaulois gaulois) {
		villageois[nbVillageois]=gaulois;
		nbVillageois++;
	}
	
	public Gaulois trouverHabitant(int place) {
		return villageois[place];
	}
	
	public void afficherVillageois(Village village) {
		System.out.println("Dans village du chef " + village.chef.getNom() + "vivent les legendaires gaulois : ");
		for (int i = 0; i < villageois.length; i++) {
			if (villageois[i] != null) {
				System.out.println(villageois[i].getNom());
			}
		}
		System.out.println("");
	}

	public static void main(String[] args) {
		Village village= new Village("Village des irreductibles", 30);
		//Gaulois gaulois = village.trouverHabitant(30); 
		//Le tableau est de taille 30, donc il n'y a pas de villageois indexe a 30
		Chef abraracoursix = new Chef("Abraracoursix", 8 , village);
		village.setChef(abraracoursix);
		Gaulois asterix = new Gaulois("Asterix", 8);
		village.ajouterHabitant(asterix);
		Gaulois obelix = new Gaulois("Obelix", 25);
		village.ajouterHabitant(obelix);
		village.afficherVillageois(village);
		//Gaulois gaulois = village.trouverHabitant(1); 
		//System.out.println(gaulois); 
		//Le village ne contient qu'un habitant a l'indice 0 et non a l'indice 1 
	}
	
}
