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
    public String accederZone(String empreinte, String photoP, String cleAPI)
        throws GestionEntreeSortie.ErreurEnvoi, GestionEntreeSortie.ErreurAuthentification, GestionEntreeSortie.EmpreinteInconnue, GestionEntreeSortie.NonAutorise, GestionEntreeSortie.ChampVide, GestionEntreeSortie.CleInconnue
    {
        return _tie.accederZone( empreinte,  photoP,  cleAPI);
    }

    /**
     * Operation sortirZone
     */
    public String sortirZone(String empreinte, String photoP, String cleAPI)
        throws GestionEntreeSortie.ErreurEnvoi, GestionEntreeSortie.ErreurAuthentification, GestionEntreeSortie.EmpreinteInconnue, GestionEntreeSortie.NonAutorise, GestionEntreeSortie.ChampVide, GestionEntreeSortie.CleInconnue
    {
        return _tie.sortirZone( empreinte,  photoP,  cleAPI);
    }

}
