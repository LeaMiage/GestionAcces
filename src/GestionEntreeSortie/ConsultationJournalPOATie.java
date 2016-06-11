package GestionEntreeSortie;

/**
 * Interface definition : ConsultationJournal
 * 
 * @author OpenORB Compiler
 */
public class ConsultationJournalPOATie extends ConsultationJournalPOA
{

    //
    // Private reference to implementation object
    //
    private ConsultationJournalOperations _tie;

    //
    // Private reference to POA
    //
    private org.omg.PortableServer.POA _poa;

    /**
     * Constructor
     */
    public ConsultationJournalPOATie(ConsultationJournalOperations tieObject)
    {
        _tie = tieObject;
    }

    /**
     * Constructor
     */
    public ConsultationJournalPOATie(ConsultationJournalOperations tieObject, org.omg.PortableServer.POA poa)
    {
        _tie = tieObject;
        _poa = poa;
    }

    /**
     * Get the delegate
     */
    public ConsultationJournalOperations _delegate()
    {
        return _tie;
    }

    /**
     * Set the delegate
     */
    public void _delegate(ConsultationJournalOperations delegate_)
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
     * Operation consulterJournal
     */
    public GestionEntreeSortie.EntreeJournal[] consulterJournal(String cleAPI)
        throws GestionEntreeSortie.CleInconnue
    {
        return _tie.consulterJournal( cleAPI);
    }

}
