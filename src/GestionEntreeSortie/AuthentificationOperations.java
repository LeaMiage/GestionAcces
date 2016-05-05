package GestionEntreeSortie;

/**
 * Interface definition : Authentification
 * 
 * @author OpenORB Compiler
 */
public interface AuthentificationOperations
{
    /**
     * Operation authentifierCompte
     */
    public void authentifierCompte(int idPersonne, String mdp, String cleAPI)
        throws GestionEntreeSortie.ErreurAuthentification, GestionEntreeSortie.CleInconnue;

    /**
     * Operation authentifierPersonne
     */
    public GestionEntreeSortie.IdentiteCollaborateur authentifierPersonne(String photoP, String cleAPI)
        throws GestionEntreeSortie.ErreurAuthentification, GestionEntreeSortie.CleInconnue;

}
