package GestionEntreeSortie;

/**
 * Interface definition : GestionAutorisation
 * 
 * @author OpenORB Compiler
 */
public interface GestionAutorisationOperations
{
    /**
     * Operation ajouterAutorisationPermanente
     */
    public void ajouterAutorisationPermanente(GestionEntreeSortie.AutorisationPermanente ap, String cleAPI)
        throws GestionEntreeSortie.AutorisationInconnue, GestionEntreeSortie.CleInconnue;

    /**
     * Operation modifierAutorisationPermanente
     */
    public void modifierAutorisationPermanente(GestionEntreeSortie.AutorisationPermanente ap, GestionEntreeSortie.AutorisationPermanente np, String cleAPI)
        throws GestionEntreeSortie.AutorisationInconnue, GestionEntreeSortie.CleInconnue;

    /**
     * Operation supprimerAutorisationPermanente
     */
    public void supprimerAutorisationPermanente(GestionEntreeSortie.AutorisationPermanente ap, String cleAPI)
        throws GestionEntreeSortie.AutorisationInconnue, GestionEntreeSortie.CleInconnue;

    /**
     * Operation ajouterAutorisationTemporaire
     */
    public void ajouterAutorisationTemporaire(GestionEntreeSortie.AutorisationTemporaire at, String cleAPI)
        throws GestionEntreeSortie.AutorisationInconnue, GestionEntreeSortie.CleInconnue;

    /**
     * Operation modifierAutorisationTemporaire
     */
    public void modifierAutorisationTemporaire(GestionEntreeSortie.AutorisationTemporaire at, GestionEntreeSortie.AutorisationTemporaire nt, String cleAPI)
        throws GestionEntreeSortie.AutorisationInconnue, GestionEntreeSortie.CleInconnue;

    /**
     * Operation supprimerAutorisationTemporaire
     */
    public void supprimerAutorisationTemporaire(GestionEntreeSortie.AutorisationTemporaire at, String cleAPI)
        throws GestionEntreeSortie.AutorisationInconnue, GestionEntreeSortie.CleInconnue;

}
