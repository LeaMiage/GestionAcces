package Administration;

import java.util.Vector;

public class Zone {

	private long idZone;
	
	private long nbPortes;
	
	private Vector<Long> listePortes;

	
	public Zone(long idZone){
		this.idZone=idZone;
	}
	
	public Zone(long idZone, Vector<Long> listePortes){
		this.idZone=idZone;
		this.listePortes=listePortes;
	}
	
	
	public long getIdZone() {
		return idZone;
	}

	public void setIdZone(long idZone) {
		this.idZone = idZone;
	}

	public long getNbPortes() {
		return nbPortes;
	}

	public void setNbPortes(long nbPortes) {
		this.nbPortes = nbPortes;
	}

	public Vector<Long> getListePortes() {
		return listePortes;
	}

	public void setListePortes(Vector<Long> listePortes) {
		this.listePortes = listePortes;
	}
	
	
	public void ajouterPorte(long idPorte){
		listePortes.addElement(idPorte);
	}
	
	public void supprimerPorte(long idPorte){
		listePortes.removeElement(idPorte);
	}
	
	
	
}
