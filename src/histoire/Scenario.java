package histoire;

import personnages.Druide;
import personnages.Equipement;
import personnages.Gaulois;
import personnages.Romain;
import lieu.Musee;
public class Scenario {
	public static void main(String[] args) {
		Druide druide = new Druide("Panoramix", 5, 10);
		druide.parler("Je vais aller préparer une petite potion...");
		druide.preparePotion();
		Gaulois obelix = new Gaulois("Obélix", 25);
		Gaulois asterix = new Gaulois("Astérix", 8);
		druide.booster(obelix);
		obelix.parler("Par Bélénos, ce n'est pas juste !");
		druide.booster(asterix);
		asterix.parler("Bonjour");
		Romain minus = new Romain("Minus", 6);
		Romain milexcus = new Romain("Milexcus", 8);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
		milexcus.sEquiper(Equipement.CASQUE);
		int i=5;
		minus.parler("UN GAU... UN GAUGAU...");
		while (minus.getForce() > 0 && i>0) {
			asterix.frapper(minus);
			i-=1;
		}
		milexcus.parler("UN GAU... UN GAUGAU...");
		while (milexcus.getForce() > 0 && i>0) {
			asterix.frapper(milexcus);
			i-=1;
		}
		
//		Partie a decommenter
		
		Musee musee = new Musee();
		asterix.faireUneDonnation(musee);
		musee.extraireInstructionsCaml();

	}
}
