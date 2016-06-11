package GestionEntreeSortie;

/**
 * Holder class for : GestionAutorisation
 * 
 * @author OpenORB Compiler
 */
final public class GestionAutorisationHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal GestionAutorisation value
     */
    public GestionEntreeSortie.GestionAutorisation value;

    /**
     * Default constructor
     */
    public GestionAutorisationHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public GestionAutorisationHolder(GestionEntreeSortie.GestionAutorisation initial)
    {
        value = initial;
    }

    /**
     * Read GestionAutorisation from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = GestionAutorisationHelper.read(istream);
    }

    /**
     * Write GestionAutorisation into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        GestionAutorisationHelper.write(ostream,value);
    }

    /**
     * Return the GestionAutorisation TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return GestionAutorisationHelper.type();
    }

}
