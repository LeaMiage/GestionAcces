package GestionEntreeSortie;

/**
 * Holder class for : Journalisation
 * 
 * @author OpenORB Compiler
 */
final public class JournalisationHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal Journalisation value
     */
    public GestionEntreeSortie.Journalisation value;

    /**
     * Default constructor
     */
    public JournalisationHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public JournalisationHolder(GestionEntreeSortie.Journalisation initial)
    {
        value = initial;
    }

    /**
     * Read Journalisation from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = JournalisationHelper.read(istream);
    }

    /**
     * Write Journalisation into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        JournalisationHelper.write(ostream,value);
    }

    /**
     * Return the Journalisation TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return JournalisationHelper.type();
    }

}
