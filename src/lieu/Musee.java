package lieu;
import personnages.Equipement;
import personnages.Gaulois;


public class Musee {
	protected Troph�es reserve[] = new Troph�es[200];
	protected int nbTrophee;

	public Troph�es[] getReserve() {
		return reserve;
	}

	public int getNbTrophee() {
		return nbTrophee;
	}

	public void donnerTrophees(Gaulois gaulois, Equipement equipDonne) {
		reserve[nbTrophee] = new Troph�es(gaulois, equipDonne); 
		nbTrophee++;
	}
	
	public void extraireInstructionsCaml() {
		String texte = "let musee = [";
		for(int i = 0; i < nbTrophee; i++) {
			if(i == nbTrophee-1) {
				texte = texte + "\n	\""+ reserve[i].donneNom() +"\", \"" + reserve[i].getEquipement() + "\"\n";
			}
			else {
				texte = texte + "\n	\""+ reserve[i].donneNom() +"\", \"" + reserve[i].getEquipement() + "\";";
			}
		}
		texte = texte + "]";
		System.out.println(texte);
	}

}
