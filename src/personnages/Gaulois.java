package personnages;
import lieu.Musee;

public class Gaulois {
	private int force;
	private String nom;
	private int effetPotion = 1;
	private int nb_trophees;
	private Equipement trophees[] = new Equipement[100];

	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}
	
	public int getForce() {
		return force;
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");
	}

	public String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}
//	private String prendreParole() {
//		String texte = "Le gaulois " + nom + " : ";
//		return texte;
//	}

//	public void frapper(Romain romain) {
//		System.out.println(nom + " envoie un grand coup dans la mâchoire de "
//				+ romain.getNom());
//		romain.recevoirCoup((force / 3)*3);
//	}
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		Equipement trophees[] = romain.recevoirCoup((force / 3) * effetPotion);
		for (int i = 0; trophees != null && i < trophees.length; i++, nb_trophees++) {
			this.trophees[nb_trophees] = trophees[i];
		}
		return;
	}

	public int getEffetPotion() {
		return effetPotion;
	}

	public void setEffetPotion(int effetPotion) {
		this.effetPotion = effetPotion;
	}

	@Override
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";
	}

	public void boirePotion(int forcePotion) {
		effetPotion = forcePotion;
		{
			System.out.println("« Merci Druide, je sens que ma force est " + forcePotion + " fois décuplée. ");
		}

	}
	
	public void faireUneDonnation(Musee musee) {
		if(nb_trophees > 0) {
			System.out.println(" « Je donne au musee tous mes trophees :");
			for(int i = 0; i < nb_trophees; i++ ) {
				if(i == nb_trophees-1) {
					//musee.getReserve()[musee.getNbTrophee()].getGaulois()
					musee.donnerTrophees(this, trophees[i]);
					System.out.println("- " + trophees[i] + " »");
				}
				else {
					musee.donnerTrophees(this, trophees[i]);
					System.out.println("- " + trophees[i]);
				}
			}
		}
		
	}
	
	

	public static void main(String[] args) {
		Gaulois axterix = new Gaulois("Axtérix", 8);
		Romain jules = new Romain("Jules", 6);
		System.out.println(axterix.toString());
		axterix.parler("Bonjour");
		System.out.println(axterix.prendreParole());
		axterix.boirePotion(2);
		axterix.frapper(jules);

	}

}
//