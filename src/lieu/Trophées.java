package lieu;
import personnages.Equipement;
import personnages.Gaulois;

public class Trophées {
		private Gaulois gaulois;
		private Equipement equipement;
		public Trophées(Gaulois gaulois, Equipement equipement) {
			this.gaulois = gaulois;
			this.equipement = equipement;
		}
		
		public Gaulois getGaulois() {
			return gaulois;
		}
		
		public Equipement getEquipement() {
			return equipement;
		}

		public String donneNom() {
			return getGaulois().getNom();
		}
}