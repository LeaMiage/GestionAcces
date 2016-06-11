package GestionEntreeSortie;

/**
 * Interface definition : GestionSalaries
 * 
 * @author OpenORB Compiler
 */
public class GestionSalariesPOATie extends GestionSalariesPOA
{

    //
    // Private reference to implementation object
    //
    private GestionSalariesOperations _tie;

    //
    // Private reference to POA
    //
    private org.omg.PortableServer.POA _poa;

    /**
     * Constructor
     */
    public GestionSalariesPOATie(GestionSalariesOperations tieObject)
    {
        _tie = tieObject;
    }

    /**
     * Constructor
     */
    public GestionSalariesPOATie(GestionSalariesOperations tieObject, org.omg.PortableServer.POA poa)
    {
        _tie = tieObject;
        _poa = poa;
    }

    /**
     * Get the delegate
     */
    public GestionSalariesOperations _delegate()
    {
        return _tie;
    }

    /**
     * Set the delegate
     */
    public void _delegate(GestionSalariesOperations delegate_)
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
     * Operation rechercherSalarie
     */
    public GestionEntreeSortie.IdentiteCollaborateur rechercherSalarie(int idPersonne, String cleAPI)
        throws GestionEntreeSortie.PersonneInconnue, GestionEntreeSortie.CleInconnue
    {
        return _tie.rechercherSalarie( idPersonne,  cleAPI);
    }

    /**
     * Operation verifierPersonne
     */
    public int verifierPersonne(int idPersonne, String cleAPI)
        throws GestionEntreeSortie.PersonneInconnue, GestionEntreeSortie.CleInconnue
    {
        return _tie.verifierPersonne( idPersonne,  cleAPI);
    }

}
