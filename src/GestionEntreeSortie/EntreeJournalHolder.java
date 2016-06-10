package GestionEntreeSortie;

/**
 * Holder class for : EntreeJournal
 * 
 * @author OpenORB Compiler
 */
final public class EntreeJournalHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal EntreeJournal value
     */
    public GestionEntreeSortie.EntreeJournal value;

    /**
     * Default constructor
     */
    public EntreeJournalHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public EntreeJournalHolder(GestionEntreeSortie.EntreeJournal initial)
    {
        value = initial;
    }

    /**
     * Read EntreeJournal from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = EntreeJournalHelper.read(istream);
    }

    /**
     * Write EntreeJournal into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        EntreeJournalHelper.write(ostream,value);
    }

    /**
     * Return the EntreeJournal TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return EntreeJournalHelper.type();
    }

}
