package AnnuaireSalaries;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;

import GestionEntreeSortie.CleInconnue;
import GestionEntreeSortie.Collaborateur;
import GestionEntreeSortie.IdentiteCollaborateur;
import GestionEntreeSortie.PersonneInconnue;

public class CreationCompteImpl extends GestionEntreeSortie.CreationComptePOA{

	@Override
	public int creerCP(String nomP, String prenomP, String mdp, String cleAPI) throws CleInconnue, PersonneInconnue {
		// TODO Auto-generated method stub
		
			Hashtable annuaire = Helpers.GestionFichiers.lireFichier("src/AnnuaireSalaries/BD_Salaries.txt");
			
			IdentiteCollaborateur collaborateur = new IdentiteCollaborateur(annuaire.size(), nomP, prenomP, "");
			
			annuaire.put(annuaire.size(), collaborateur);
			
			Helpers.GestionFichiers.ecrireFichier("src/AnnuaireSalaries/BD_Salaries.txt", annuaire);
			
			return collaborateur.idPersonne;
		
		
	}

	@Override
	public int creerCT(String nomP, String prenomP, String mdp, String cleAPI) throws CleInconnue, PersonneInconnue {
		// TODO Auto-generated method stub
		
					Hashtable annuaire = Helpers.GestionFichiers.lireFichier("src/AnnuaireSalaries/BD_Salaries.txt");
					
					IdentiteCollaborateur collaborateur = new IdentiteCollaborateur(annuaire.size(), nomP, prenomP, "");
					
					annuaire.put(annuaire.size(), collaborateur);
					
					Helpers.GestionFichiers.ecrireFichier("src/AnnuaireSalaries/BD_Salaries.txt", annuaire);
					
					return collaborateur.idPersonne;
			
				
	}

}
