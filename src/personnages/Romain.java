package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements = new Equipement[2];
	private int nbEquipement =0;
	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		assert force > 0 ;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");
	}
	
	public String prendreParole() {
		return "Le romain " + nom + " : ";
	}
	
	public void recevoirCoup(int forceCoup) {
		assert force > 0 ;
		int forceNonDim = force;
		force -= forceCoup;
		if (force > 0) {
				parler("Aïe");
		} else {
			parler("J'abandonne...");
		}
		assert forceNonDim > force ;
	}
	
	public void sEquiper (Equipement equipement) {
		   switch(nbEquipement){
		   
	       case 2: 
	           System.out.println("Le soldat " + getNom() + " est déjà bien protégé !");
	           break;
	   
	       case 1:
	    	   if(equipements[0] == equipement || equipements[1] == equipement) {
	    		   System.out.println("Le soldat " + getNom() + " possède déjà un " + equipement.toString() + " !");
	    	   }
	    	   else {
	    		   if(equipements[0].toString() == "") {
	    			   equipements[0] = equipement;
	    			   System.out.println("Le soldat " + getNom() + " s'équipe avec un " + equipement.toString() + " !");
	    			   nbEquipement++;
	    		   }
	    		   else if (equipements[1] == null){
	    			   equipements[1] = equipement;
	    			   System.out.println("Le soldat " + getNom() + " s'équipe avec un " + equipement.toString() + " !");
	    			   nbEquipement++;
	    		   }
	    	   }
	           break;
	   
	       default:
	           equipements[0] = equipement; 
	           System.out.println("Le soldat " + getNom() + " s'équipe avec un " + equipement.toString() + " !");
	           nbEquipement++;
	           break;
		   }
	}
	
	public static void main(String[] args) {
		Romain minus = new Romain("Minus", 6);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
		
		minus.prendreParole();
		minus.parler("Ave");
		minus.recevoirCoup(5);
		minus.recevoirCoup(9);
		System.out.println(Equipement.CASQUE + " " + Equipement.BOUCLIER);
	}
}