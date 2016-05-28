package GestionEntreeSortie;

/**
 * Interface definition : GestionEmpreinte
 * 
 * @author OpenORB Compiler
 */
public interface GestionEmpreinteOperations
{
    /**
     * Operation modifierEmpreinte
     */
    public void modifierEmpreinte(int idPersonne, String empreinte, String cleAPI)
        throws GestionEntreeSortie.PersonneInconnue, GestionEntreeSortie.CleInconnue, GestionEntreeSortie.ChampVide;

    /**
     * Operation supprimerEmpreinte
     */
    public void supprimerEmpreinte(int idPersonne, String cleAPI)
        throws GestionEntreeSortie.PersonneInconnue, GestionEntreeSortie.CleInconnue;

}
