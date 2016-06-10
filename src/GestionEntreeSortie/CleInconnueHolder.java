package GestionEntreeSortie;

/**
 * Holder class for : CleInconnue
 * 
 * @author OpenORB Compiler
 */
final public class CleInconnueHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal CleInconnue value
     */
    public GestionEntreeSortie.CleInconnue value;

    /**
     * Default constructor
     */
    public CleInconnueHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public CleInconnueHolder(GestionEntreeSortie.CleInconnue initial)
    {
        value = initial;
    }

    /**
     * Read CleInconnue from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = CleInconnueHelper.read(istream);
    }

    /**
     * Write CleInconnue into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        CleInconnueHelper.write(ostream,value);
    }

    /**
     * Return the CleInconnue TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return CleInconnueHelper.type();
    }

}
