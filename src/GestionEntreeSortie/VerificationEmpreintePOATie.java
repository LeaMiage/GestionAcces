package GestionEntreeSortie;

/**
 * Interface definition : VerificationEmpreinte
 * 
 * @author OpenORB Compiler
 */
public class VerificationEmpreintePOATie extends VerificationEmpreintePOA
{

    //
    // Private reference to implementation object
    //
    private VerificationEmpreinteOperations _tie;

    //
    // Private reference to POA
    //
    private org.omg.PortableServer.POA _poa;

    /**
     * Constructor
     */
    public VerificationEmpreintePOATie(VerificationEmpreinteOperations tieObject)
    {
        _tie = tieObject;
    }

    /**
     * Constructor
     */
    public VerificationEmpreintePOATie(VerificationEmpreinteOperations tieObject, org.omg.PortableServer.POA poa)
    {
        _tie = tieObject;
        _poa = poa;
    }

    /**
     * Get the delegate
     */
    public VerificationEmpreinteOperations _delegate()
    {
        return _tie;
    }

    /**
     * Set the delegate
     */
    public void _delegate(VerificationEmpreinteOperations delegate_)
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
     * Operation verifierEmpreinte
     */
    public void verifierEmpreinte(int idPersonne, String empreinte, String cleAPI)
        throws GestionEntreeSortie.EmpreinteInconnue, GestionEntreeSortie.CleInconnue, GestionEntreeSortie.ChampVide
    {
        _tie.verifierEmpreinte( idPersonne,  empreinte,  cleAPI);
    }

}
