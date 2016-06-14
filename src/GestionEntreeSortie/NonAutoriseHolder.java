package GestionEntreeSortie;

/**
 * Holder class for : NonAutorise
 * 
 * @author OpenORB Compiler
 */
final public class NonAutoriseHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal NonAutorise value
     */
    public GestionEntreeSortie.NonAutorise value;

    /**
     * Default constructor
     */
    public NonAutoriseHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public NonAutoriseHolder(GestionEntreeSortie.NonAutorise initial)
    {
        value = initial;
    }

    /**
     * Read NonAutorise from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = NonAutoriseHelper.read(istream);
    }

    /**
     * Write NonAutorise into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        NonAutoriseHelper.write(ostream,value);
    }

    /**
     * Return the NonAutorise TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return NonAutoriseHelper.type();
    }

}
