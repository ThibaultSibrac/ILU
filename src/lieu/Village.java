package lieu;

import personnages.Chef;
import personnages.Gaulois;

public class Village {
	private String nom;
	private int nbVillageois = 0;
	private Chef chef;
	private Gaulois[] villageois;
	public Village(String nom, int nbVillageoisMaximum) {
		this.nom = nom;
		this.villageois = new Gaulois[nbVillageoisMaximum];
	}
	
	public void setChef(Chef chef) {
		this.chef = chef;
	}
	
	
	public String getNom() {
		return nom;
	}
	
	public Gaulois[] ajouterHabitant(Gaulois gaulois, int nbVillageoisMaximum){
		if(nbVillageois < nbVillageoisMaximum) {
			villageois[nbVillageois] = gaulois;
			nbVillageois ++;
		}
		return villageois;
	}
	
	public Gaulois trouverHabitant(int numHabitant) {
		return villageois[numHabitant-1];
	}
	
	public void afficherVillageois() {
		System.out.println("Dans "+ getNom() + " du chef " + chef.getNom() + " vivent les legendaires gaulois :");
		for(int i  = 0; nbVillageois > i; i++) {
			System.out.println("- "+ villageois[i].getNom());
		}
	}
	
//	public static void main(String[] args) {
////		Village village1 = new Village("village des irreductible", 30);
////		Gaulois gaulois = village1.trouverHabitant(30);
////		// Variable not used
////		//Car gaulois n'est pas utilisé
//		Village village1 = new Village("village des irreductibles", 30);
//		Chef chef1 = new Chef("Abraracourcix", 6, village1);
//		Gaulois asterix = new Gaulois("Asterix", 8);
//		Gaulois obelix = new Gaulois("Obelix", 25);
//		village1.setChef(chef1);
//		village1.ajouterHabitant(asterix, 1);
//		village1.ajouterHabitant(obelix, 2);
//		village1.afficherVillageois();
////		Gaulois gaulois = village1.trouverHabitant(1);
////		System.out.println(gaulois);
//		// On obtient : Gaulois [nom=Asterix, force=8, effetPotion=1]
//		
//	}
}