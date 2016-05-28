package GestionEntreeSortie;

/**
 * Interface definition : VerificationEmpreinte
 * 
 * @author OpenORB Compiler
 */
public interface VerificationEmpreinteOperations
{
    /**
     * Operation verifierEmpreinte
     */
    public void verifierEmpreinte(int idPersonne, String empreinte, String cleAPI)
        throws GestionEntreeSortie.EmpreinteInconnue, GestionEntreeSortie.CleInconnue, GestionEntreeSortie.ChampVide;

}
