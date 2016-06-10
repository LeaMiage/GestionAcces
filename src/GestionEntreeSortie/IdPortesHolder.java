package GestionEntreeSortie;

/**
 * Holder class for : IdPortes
 * 
 * @author OpenORB Compiler
 */
final public class IdPortesHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal IdPortes value
     */
    public int[] value;

    /**
     * Default constructor
     */
    public IdPortesHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public IdPortesHolder(int[] initial)
    {
        value = initial;
    }

    /**
     * Read IdPortes from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = IdPortesHelper.read(istream);
    }

    /**
     * Write IdPortes into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        IdPortesHelper.write(ostream,value);
    }

    /**
     * Return the IdPortes TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return IdPortesHelper.type();
    }

}
