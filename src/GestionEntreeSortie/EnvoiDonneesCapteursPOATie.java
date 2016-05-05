package GestionEntreeSortie;

/**
 * Interface definition : EnvoiDonneesCapteurs
 * 
 * @author OpenORB Compiler
 */
public class EnvoiDonneesCapteursPOATie extends EnvoiDonneesCapteursPOA
{

    //
    // Private reference to implementation object
    //
    private EnvoiDonneesCapteursOperations _tie;

    //
    // Private reference to POA
    //
    private org.omg.PortableServer.POA _poa;

    /**
     * Constructor
     */
    public EnvoiDonneesCapteursPOATie(EnvoiDonneesCapteursOperations tieObject)
    {
        _tie = tieObject;
    }

    /**
     * Constructor
     */
    public EnvoiDonneesCapteursPOATie(EnvoiDonneesCapteursOperations tieObject, org.omg.PortableServer.POA poa)
    {
        _tie = tieObject;
        _poa = poa;
    }

    /**
     * Get the delegate
     */
    public EnvoiDonneesCapteursOperations _delegate()
    {
        return _tie;
    }

    /**
     * Set the delegate
     */
    public void _delegate(EnvoiDonneesCapteursOperations delegate_)
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
     * Operation accederZone
     */
    public void accederZone(String empreinte, String photoP, String cleAPI)
        throws GestionEntreeSortie.ErreurEnvoi, GestionEntreeSortie.CleInconnue
    {
        _tie.accederZone( empreinte,  photoP,  cleAPI);
    }

    /**
     * Operation sortirZone
     */
    public void sortirZone(String empreinte, String photoP, String cleAPI)
        throws GestionEntreeSortie.ErreurEnvoi, GestionEntreeSortie.CleInconnue
    {
        _tie.sortirZone( empreinte,  photoP,  cleAPI);
    }

}
