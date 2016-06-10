package GestionEntreeSortie;

/**
 * Interface definition : Authentification
 * 
 * @author OpenORB Compiler
 */
public class AuthentificationPOATie extends AuthentificationPOA
{

    //
    // Private reference to implementation object
    //
    private AuthentificationOperations _tie;

    //
    // Private reference to POA
    //
    private org.omg.PortableServer.POA _poa;

    /**
     * Constructor
     */
    public AuthentificationPOATie(AuthentificationOperations tieObject)
    {
        _tie = tieObject;
    }

    /**
     * Constructor
     */
    public AuthentificationPOATie(AuthentificationOperations tieObject, org.omg.PortableServer.POA poa)
    {
        _tie = tieObject;
        _poa = poa;
    }

    /**
     * Get the delegate
     */
    public AuthentificationOperations _delegate()
    {
        return _tie;
    }

    /**
     * Set the delegate
     */
    public void _delegate(AuthentificationOperations delegate_)
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
     * Operation authentifierCompte
     */
    public void authentifierCompte(int idPersonne, String mdp, String cleAPI)
        throws GestionEntreeSortie.ErreurAuthentification, GestionEntreeSortie.CleInconnue
    {
        _tie.authentifierCompte( idPersonne,  mdp,  cleAPI);
    }

    /**
     * Operation authentifierPersonne
     */
    public GestionEntreeSortie.IdentiteCollaborateur authentifierPersonne(String photoP, String cleAPI)
        throws GestionEntreeSortie.ErreurAuthentification, GestionEntreeSortie.CleInconnue
    {
        return _tie.authentifierPersonne( photoP,  cleAPI);
    }

}
