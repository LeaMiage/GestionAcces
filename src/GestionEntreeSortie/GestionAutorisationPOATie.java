package GestionEntreeSortie;

/**
 * Interface definition : GestionAutorisation
 * 
 * @author OpenORB Compiler
 */
public class GestionAutorisationPOATie extends GestionAutorisationPOA
{

    //
    // Private reference to implementation object
    //
    private GestionAutorisationOperations _tie;

    //
    // Private reference to POA
    //
    private org.omg.PortableServer.POA _poa;

    /**
     * Constructor
     */
    public GestionAutorisationPOATie(GestionAutorisationOperations tieObject)
    {
        _tie = tieObject;
    }

    /**
     * Constructor
     */
    public GestionAutorisationPOATie(GestionAutorisationOperations tieObject, org.omg.PortableServer.POA poa)
    {
        _tie = tieObject;
        _poa = poa;
    }

    /**
     * Get the delegate
     */
    public GestionAutorisationOperations _delegate()
    {
        return _tie;
    }

    /**
     * Set the delegate
     */
    public void _delegate(GestionAutorisationOperations delegate_)
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
     * Operation ajouterAutorisationPermanente
     */
    public void ajouterAutorisationPermanente(GestionEntreeSortie.AutorisationPermanente ap, String cleAPI)
        throws GestionEntreeSortie.AutorisationInconnue, GestionEntreeSortie.AutorisationExistante, GestionEntreeSortie.PersonneInconnue, GestionEntreeSortie.AjoutAPImpossible, GestionEntreeSortie.CleInconnue
    {
        _tie.ajouterAutorisationPermanente( ap,  cleAPI);
    }

    /**
     * Operation modifierAutorisationPermanente
     */
    public void modifierAutorisationPermanente(GestionEntreeSortie.AutorisationPermanente ap, GestionEntreeSortie.AutorisationPermanente np, String cleAPI)
        throws GestionEntreeSortie.AutorisationInconnue, GestionEntreeSortie.PersonneInconnue, GestionEntreeSortie.CleInconnue
    {
        _tie.modifierAutorisationPermanente( ap,  np,  cleAPI);
    }

    /**
     * Operation supprimerAutorisationPermanente
     */
    public void supprimerAutorisationPermanente(GestionEntreeSortie.AutorisationPermanente ap, String cleAPI)
        throws GestionEntreeSortie.AutorisationInconnue, GestionEntreeSortie.PersonneInconnue, GestionEntreeSortie.CleInconnue
    {
        _tie.supprimerAutorisationPermanente( ap,  cleAPI);
    }

    /**
     * Operation ajouterAutorisationTemporaire
     */
    public void ajouterAutorisationTemporaire(GestionEntreeSortie.AutorisationTemporaire at, String cleAPI)
        throws GestionEntreeSortie.AutorisationInconnue, GestionEntreeSortie.AutorisationExistante, GestionEntreeSortie.PersonneInconnue, GestionEntreeSortie.CleInconnue
    {
        _tie.ajouterAutorisationTemporaire( at,  cleAPI);
    }

    /**
     * Operation modifierAutorisationTemporaire
     */
    public void modifierAutorisationTemporaire(GestionEntreeSortie.AutorisationTemporaire at, GestionEntreeSortie.AutorisationTemporaire nt, String cleAPI)
        throws GestionEntreeSortie.AutorisationInconnue, GestionEntreeSortie.PersonneInconnue, GestionEntreeSortie.CleInconnue
    {
        _tie.modifierAutorisationTemporaire( at,  nt,  cleAPI);
    }

    /**
     * Operation supprimerAutorisationTemporaire
     */
    public void supprimerAutorisationTemporaire(GestionEntreeSortie.AutorisationTemporaire at, String cleAPI)
        throws GestionEntreeSortie.AutorisationInconnue, GestionEntreeSortie.PersonneInconnue, GestionEntreeSortie.CleInconnue
    {
        _tie.supprimerAutorisationTemporaire( at,  cleAPI);
    }

    /**
     * Operation listeAutorisationsPerm
     */
    public GestionEntreeSortie.AutorisationPermanente[] listeAutorisationsPerm(int idZone, String cleAPI)
        throws GestionEntreeSortie.ZoneInconnue, GestionEntreeSortie.CleInconnue
    {
        return _tie.listeAutorisationsPerm( idZone,  cleAPI);
    }

    /**
     * Operation listeAutorisationsTemp
     */
    public GestionEntreeSortie.AutorisationTemporaire[] listeAutorisationsTemp(int idZone, String cleAPI)
        throws GestionEntreeSortie.ZoneInconnue, GestionEntreeSortie.CleInconnue
    {
        return _tie.listeAutorisationsTemp( idZone,  cleAPI);
    }

    /**
     * Operation listeAutorisationsPermPersonne
     */
    public GestionEntreeSortie.AutorisationPermanente[] listeAutorisationsPermPersonne(int idPersonne, String cleAPI)
        throws GestionEntreeSortie.CleInconnue
    {
        return _tie.listeAutorisationsPermPersonne( idPersonne,  cleAPI);
    }

    /**
     * Operation listeAutorisationsTempPersonne
     */
    public GestionEntreeSortie.AutorisationTemporaire[] listeAutorisationsTempPersonne(int idPersonne, String cleAPI)
        throws GestionEntreeSortie.CleInconnue
    {
        return _tie.listeAutorisationsTempPersonne( idPersonne,  cleAPI);
    }

}
