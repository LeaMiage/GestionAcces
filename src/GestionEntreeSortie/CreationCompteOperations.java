package GestionEntreeSortie;

/**
 * Interface definition : CreationCompte
 * 
 * @author OpenORB Compiler
 */
public interface CreationCompteOperations
{
    /**
     * Operation creerCP
     */
    public int creerCP(String nomP, String prenomP, String mdp, String photoP, String cleAPI)
        throws GestionEntreeSortie.CleInconnue, GestionEntreeSortie.PersonneExistante, GestionEntreeSortie.ChampVide;

    /**
     * Operation creerCT
     */
    public int creerCT(String nomP, String prenomP, String mdp, String photoP, String cleAPI)
        throws GestionEntreeSortie.CleInconnue, GestionEntreeSortie.PersonneExistante, GestionEntreeSortie.ChampVide;

}
