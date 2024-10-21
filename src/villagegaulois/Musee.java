package villagegaulois;

import personnages.Equipement;
import personnages.Gaulois;

public class Musee {
	private final static int MAX_TROPHEES = 200;
	private Trophee[] trophees = new Trophee[MAX_TROPHEES];
	private int nbTrophees = 0;

	
	public void donnerTrophees(Gaulois gaulois, Equipement equipement) {
		Trophee trophee = new Trophee(gaulois, equipement);
		trophees[nbTrophees] = trophee;
		nbTrophees++;
	}

	
	public String extraireInstructionsOCaml() {
		String texte = "let musee = [";
		for (int i = 0; i < trophees.length; i++) {
			if (trophees[i] != null) {
				if (i != 0) {
					texte += ";";
				}
				texte += "\n\t\"";
				texte += trophees[i].getGaulois().getNom();
				texte += "\", \"";
				texte += trophees[i].getEquipement().getNom();
				texte += "\"";
			}
		}
		texte += "\n]";
		return texte;
	}
}
