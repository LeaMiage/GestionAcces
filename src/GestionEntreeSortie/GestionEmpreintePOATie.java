package GestionEntreeSortie;

/**
 * Interface definition : GestionEmpreinte
 * 
 * @author OpenORB Compiler
 */
public class GestionEmpreintePOATie extends GestionEmpreintePOA
{

    //
    // Private reference to implementation object
    //
    private GestionEmpreinteOperations _tie;

    //
    // Private reference to POA
    //
    private org.omg.PortableServer.POA _poa;

    /**
     * Constructor
     */
    public GestionEmpreintePOATie(GestionEmpreinteOperations tieObject)
    {
        _tie = tieObject;
    }

    /**
     * Constructor
     */
    public GestionEmpreintePOATie(GestionEmpreinteOperations tieObject, org.omg.PortableServer.POA poa)
    {
        _tie = tieObject;
        _poa = poa;
    }

    /**
     * Get the delegate
     */
    public GestionEmpreinteOperations _delegate()
    {
        return _tie;
    }

    /**
     * Set the delegate
     */
    public void _delegate(GestionEmpreinteOperations delegate_)
    {
        _tie = delegate_;
    }

    /**
     * _default_POA method
     */
    public org.omg.PortableServer.POA _default_POA()
    {
        if (_poa != null)
            return _poa;
        else
            return super._default_POA();
    }

    /**
     * Operation ajouterEmpreinte
     */
    public void ajouterEmpreinte(int idPersonne, String empreinte, String cleAPI)
        throws GestionEntreeSortie.EmpreinteExistante, GestionEntreeSortie.CleInconnue, GestionEntreeSortie.ChampVide
    {
        _tie.ajouterEmpreinte( idPersonne,  empreinte,  cleAPI);
    }

    /**
     * Operation modifierEmpreinte
     */
    public void modifierEmpreinte(int idPersonne, String empreinte, String cleAPI)
        throws GestionEntreeSortie.PersonneInconnue, GestionEntreeSortie.CleInconnue, GestionEntreeSortie.ChampVide
    {
        _tie.modifierEmpreinte( idPersonne,  empreinte,  cleAPI);
    }

    /**
     * Operation supprimerEmpreinte
     */
    public void supprimerEmpreinte(int idPersonne, String cleAPI)
        throws GestionEntreeSortie.PersonneInconnue, GestionEntreeSortie.CleInconnue
    {
        _tie.supprimerEmpreinte( idPersonne,  cleAPI);
    }

}
