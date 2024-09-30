package villagegaulois;

import personnages.Equipement;
import personnages.Gaulois;

public class Trophee {
	private Gaulois gaulois;
	private Equipement equipement;

	public Trophee(Gaulois gaulois, Equipement equipement) {
		super();
		this.gaulois = gaulois;
		this.equipement = equipement;
	}

	public Gaulois getGaulois() {
		return gaulois;
	}

	public Equipement getEquipement() {
		return equipement;
	}

}
