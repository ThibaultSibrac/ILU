package personnages;

public class Gaulois {
	private int force;
	private String nom;
	private int effetPotion = 1;
	
	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");
	}
	
	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}
	
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de "
				+ romain.getNom());
		romain.recevoirCoup((force / 3)*3);
	}
	
	public int getEffetPotion() {
		return effetPotion;
	}

	public void setEffetPotion(int effetPotion) {
		this.effetPotion = effetPotion;
	}
	
	@Override
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force
				+ ", effetPotion=" + effetPotion + "]";
	}
	public void boirePotion(int effetPotion) {
		if (effetPotion == 3) {
			System.out.println("« Merci Druide, je sens que ma force est 3 fois décuplée. ");
		}
		
	}
	
	public static void main(String[] args) {
		Gaulois axterix = new Gaulois("Axtérix",8);
		Romain jules = new Romain("Jules",6);
		System.out.println(axterix.toString());
		axterix.parler("Bonjour");
		System.out.println(axterix.prendreParole());
		axterix.boirePotion(2);
		axterix.frapper(jules);
		
	}
	

	
} 
//