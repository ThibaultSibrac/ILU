package personnages;
import java.util.Random;
public class Druide {
	private String nom;
	private int effetPotionMin;
	private int effetPotionMax;
	private int forcePotion=1;

	public Druide(String nom, int effetPotionMin, int effetPotionMax) {
		this.nom = nom;
		this.effetPotionMin = effetPotionMin;
		this.effetPotionMax = effetPotionMax;
		parler("Bonjour, je suis le druide " + nom + " et ma potion peut allerd'une force " + effetPotionMin + " � "
				+ effetPotionMax + ".");
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "� " + texte + "�");
	}

	private String prendreParole() {
		return "Le druide " + nom + " : ";
	}
	public void preparePotion() {
		Random random = new Random();
		forcePotion = effetPotionMin + random.nextInt(effetPotionMax - effetPotionMin);
		if (forcePotion > 7) {
			parler("J'ai pr�par� une super potion de force " + forcePotion );
		} else {
			parler(" Je n'ai pas trouv� tous les ingr�dients, ma potion est  seulement de force " + forcePotion);
		}
	public void booster(Gaulois nom , int effetPotion) {
		if (nom.getNom() == "Obelix") {
			parler("Non, Ob�lix !... Tu n�auras pas de potion magique !");
			nom.parler(" Par B�l�nos, ce n'est pas juste !");
		}
		else {
			nom.boirePotion(effetPotion);
		}
		
	}
	public static void main(String[] args) { 
		Druide panoramix = new Druide("Panoramix",5,10);
		Gaulois axterix = new Gaulois("Axt�rix",8);
		axterix.booster(axterix,3);
			
			
	}
	}
	//
}