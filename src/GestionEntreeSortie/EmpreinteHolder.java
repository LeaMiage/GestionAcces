package GestionEntreeSortie;

/**
 * Holder class for : Empreinte
 * 
 * @author OpenORB Compiler
 */
final public class EmpreinteHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal Empreinte value
     */
    public GestionEntreeSortie.Empreinte value;

    /**
     * Default constructor
     */
    public EmpreinteHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public EmpreinteHolder(GestionEntreeSortie.Empreinte initial)
    {
        value = initial;
    }

    /**
     * Read Empreinte from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = EmpreinteHelper.read(istream);
    }

    /**
     * Write Empreinte into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        EmpreinteHelper.write(ostream,value);
    }

    /**
     * Return the Empreinte TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return EmpreinteHelper.type();
    }

}
