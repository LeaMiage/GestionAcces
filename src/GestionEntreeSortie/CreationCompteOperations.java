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
    public int creerCP(String nomP, String prenomP, String mdp, String cleAPI)
        throws GestionEntreeSortie.CleInconnue, GestionEntreeSortie.PersonneInconnue;

    /**
     * Operation creerCT
     */
    public int creerCT(String nomP, String prenomP, String mdp, String cleAPI)
        throws GestionEntreeSortie.CleInconnue, GestionEntreeSortie.PersonneInconnue;

}
