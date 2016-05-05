package GestionEntreeSortie;

/**
 * Interface definition : CreationCompte
 * 
 * @author OpenORB Compiler
 */
public class CreationComptePOATie extends CreationComptePOA
{

    //
    // Private reference to implementation object
    //
    private CreationCompteOperations _tie;

    //
    // Private reference to POA
    //
    private org.omg.PortableServer.POA _poa;

    /**
     * Constructor
     */
    public CreationComptePOATie(CreationCompteOperations tieObject)
    {
        _tie = tieObject;
    }

    /**
     * Constructor
     */
    public CreationComptePOATie(CreationCompteOperations tieObject, org.omg.PortableServer.POA poa)
    {
        _tie = tieObject;
        _poa = poa;
    }

    /**
     * Get the delegate
     */
    public CreationCompteOperations _delegate()
    {
        return _tie;
    }

    /**
     * Set the delegate
     */
    public void _delegate(CreationCompteOperations delegate_)
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
     * Operation creerCP
     */
    public int creerCP(String nomP, String prenomP, String mdp, String cleAPI)
        throws GestionEntreeSortie.CleInconnue, GestionEntreeSortie.PersonneInconnue
    {
        return _tie.creerCP( nomP,  prenomP,  mdp,  cleAPI);
    }

    /**
     * Operation creerCT
     */
    public int creerCT(String nomP, String prenomP, String mdp, String cleAPI)
        throws GestionEntreeSortie.CleInconnue, GestionEntreeSortie.PersonneInconnue
    {
        return _tie.creerCT( nomP,  prenomP,  mdp,  cleAPI);
    }

}
