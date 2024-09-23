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

	public static void main(String[] args) {
		Village village= new Village("Village des irreductibles", 30);
		//Gaulois gaulois = village.trouverHabitant(30); 
		//Le tableau est de taille 30, donc il n'y a pas de villageois indexe a 30
	}
	
}
