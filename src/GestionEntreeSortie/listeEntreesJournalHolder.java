package GestionEntreeSortie;

/**
 * Holder class for : listeEntreesJournal
 * 
 * @author OpenORB Compiler
 */
final public class listeEntreesJournalHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal listeEntreesJournal value
     */
    public GestionEntreeSortie.EntreeJournal[] value;

    /**
     * Default constructor
     */
    public listeEntreesJournalHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public listeEntreesJournalHolder(GestionEntreeSortie.EntreeJournal[] initial)
    {
        value = initial;
    }

    /**
     * Read listeEntreesJournal from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = listeEntreesJournalHelper.read(istream);
    }

    /**
     * Write listeEntreesJournal into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        listeEntreesJournalHelper.write(ostream,value);
    }

    /**
     * Return the listeEntreesJournal TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return listeEntreesJournalHelper.type();
    }

}
