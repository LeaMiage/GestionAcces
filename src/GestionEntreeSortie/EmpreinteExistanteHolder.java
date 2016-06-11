package GestionEntreeSortie;

/**
 * Holder class for : EmpreinteExistante
 * 
 * @author OpenORB Compiler
 */
final public class EmpreinteExistanteHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal EmpreinteExistante value
     */
    public GestionEntreeSortie.EmpreinteExistante value;

    /**
     * Default constructor
     */
    public EmpreinteExistanteHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public EmpreinteExistanteHolder(GestionEntreeSortie.EmpreinteExistante initial)
    {
        value = initial;
    }

    /**
     * Read EmpreinteExistante from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = EmpreinteExistanteHelper.read(istream);
    }

    /**
     * Write EmpreinteExistante into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        EmpreinteExistanteHelper.write(ostream,value);
    }

    /**
     * Return the EmpreinteExistante TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return EmpreinteExistanteHelper.type();
    }

}
