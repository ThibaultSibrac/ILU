package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements = new Equipement[2];
	private int nbEquipement = 0;
	private String texte;

	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		assert force > 0;
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "� " + texte + "�");
	}

	public String prendreParole() {
		return "Le romain " + nom + " : ";
	}

//	public void recevoirCoup(int forceCoup) {
//		assert force > 0 ;
//		int forceNonDim = force;
//		force -= forceCoup;
//		if (force > 0) {
//				parler("A�e");
//		} else {
//			parler("J'abandonne...");
//		}
//		assert forceNonDim > force ;
//	}

	public Equipement[] recevoirCoup(int forceCoup) {
		if (force < 0) {
			System.out.println("Le romain est d�ja � terre");
		}
		Equipement[] equipementEjecte = null;
		// pr�condition
		assert force > 0;
		int oldForce = force;
		forceCoup = CalculResistanceEquipement(forceCoup);
		force -= forceCoup;
		if (force > 0) {
			parler("A�e");
		} else {
			equipementEjecte = ejecterEquipement();
			parler("J'abandonne...");
		}
		// post condition la force � diminuer
		assert force < oldForce;
		return equipementEjecte;
	}

	private int CalculResistanceEquipement(int forceCoup) {
		texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
		int resistanceEquipement = 0;
		if (!(nbEquipement == 0)) {
			texte += "\nMais heureusement, grace � mon �quipement sa force est diminu� de ";
			for (int i = 0; i < nbEquipement;) {
				if ((equipements[i] != null && equipements[i].equals(Equipement.BOUCLIER)) == true) {
					resistanceEquipement += 8;
					System.out.println("Equipement bouclier");
				} else {
					System.out.println("Equipement casque");
					resistanceEquipement += 5;
				}
				i++;
			}
			texte = texte + resistanceEquipement + "!";
		}
		parler(texte);
		forceCoup -= resistanceEquipement;
		if (forceCoup > 0) {
			return forceCoup;
		}
		return 0;
	}

	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'�quipement de " + nom.toString() + "s'envole sous la force du coup.");
		// TODO
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
			if (equipements[i] == null) {
				continue;
			} else {
				equipementEjecte[nbEquipementEjecte] = equipements[i];
				nbEquipementEjecte++;
				equipements[i] = null;
			}
		}
		return equipementEjecte;
	}

	public void sEquiper(Equipement equipement) {
		switch (nbEquipement) {

		case 2:
			System.out.println("Le soldat " + getNom() + " est d�j� bien prot�g� !");
			break;

		case 1:
			if (equipements[0] == equipement || equipements[1] == equipement) {
				System.out.println("Le soldat " + getNom() + " poss�de d�j� un " + equipement.toString() + " !");
			} else {
				if (equipements[0].toString() == "") {
					equipements[0] = equipement;
					System.out.println("Le soldat " + getNom() + " s'�quipe avec un " + equipement.toString() + " !");
					nbEquipement++;
				} else if (equipements[1] == null) {
					equipements[1] = equipement;
					System.out.println("Le soldat " + getNom() + " s'�quipe avec un " + equipement.toString() + " !");
					nbEquipement++;
				}
			}
			break;

		default:
			equipements[0] = equipement;
			System.out.println("Le soldat " + getNom() + " s'�quipe avec un " + equipement.toString() + " !");
			nbEquipement++;
			break;
		}
	}

	public static void main(String[] args) {
		Romain minus = new Romain("Minus", 6);
//		minus.sEquiper(Equipement.CASQUE);
//		minus.sEquiper(Equipement.CASQUE);
//		minus.sEquiper(Equipement.BOUCLIER);
//		minus.sEquiper(Equipement.CASQUE);

		minus.prendreParole();
		minus.parler("Ave");
		minus.recevoirCoup(5);
		minus.recevoirCoup(9);
		// System.out.println(Equipement.CASQUE + " " + Equipement.BOUCLIER);
	}
}