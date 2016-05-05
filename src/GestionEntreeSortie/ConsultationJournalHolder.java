package GestionEntreeSortie;

/**
 * Holder class for : ConsultationJournal
 * 
 * @author OpenORB Compiler
 */
final public class ConsultationJournalHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal ConsultationJournal value
     */
    public GestionEntreeSortie.ConsultationJournal value;

    /**
     * Default constructor
     */
    public ConsultationJournalHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public ConsultationJournalHolder(GestionEntreeSortie.ConsultationJournal initial)
    {
        value = initial;
    }

    /**
     * Read ConsultationJournal from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = ConsultationJournalHelper.read(istream);
    }

    /**
     * Write ConsultationJournal into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        ConsultationJournalHelper.write(ostream,value);
    }

    /**
     * Return the ConsultationJournal TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return ConsultationJournalHelper.type();
    }

}
