package histoire;

import personnages.Gaulois;
import personnages.Romain;
import personnages.Druide;

public class Scenario {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Gaulois axterix = new Gaulois("Axtérix",10);
		Romain minus = new Romain("Minus",8);
		Druide panoramix = new Druide("panoramix",5,10);
		panoramix.preparePotion();
		axterix.parler("Bonjour à tous");
		minus.parler("UN GAU... UNGAUGAU...");
		axterix.frapper(minus);
		axterix.frapper(minus);
		axterix.frapper(minus);
		
		
	}

}
