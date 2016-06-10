package GestionEntreeSortie;

/**
 * Holder class for : GestionEmpreinte
 * 
 * @author OpenORB Compiler
 */
final public class GestionEmpreinteHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal GestionEmpreinte value
     */
    public GestionEntreeSortie.GestionEmpreinte value;

    /**
     * Default constructor
     */
    public GestionEmpreinteHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public GestionEmpreinteHolder(GestionEntreeSortie.GestionEmpreinte initial)
    {
        value = initial;
    }

    /**
     * Read GestionEmpreinte from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = GestionEmpreinteHelper.read(istream);
    }

    /**
     * Write GestionEmpreinte into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        GestionEmpreinteHelper.write(ostream,value);
    }

    /**
     * Return the GestionEmpreinte TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return GestionEmpreinteHelper.type();
    }

}
