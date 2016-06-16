package GestionEntreeSortie;

/**
 * Holder class for : listeAutorisationsPermanentes
 * 
 * @author OpenORB Compiler
 */
final public class listeAutorisationsPermanentesHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal listeAutorisationsPermanentes value
     */
    public GestionEntreeSortie.AutorisationPermanente[] value;

    /**
     * Default constructor
     */
    public listeAutorisationsPermanentesHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public listeAutorisationsPermanentesHolder(GestionEntreeSortie.AutorisationPermanente[] initial)
    {
        value = initial;
    }

    /**
     * Read listeAutorisationsPermanentes from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = listeAutorisationsPermanentesHelper.read(istream);
    }

    /**
     * Write listeAutorisationsPermanentes into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        listeAutorisationsPermanentesHelper.write(ostream,value);
    }

    /**
     * Return the listeAutorisationsPermanentes TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return listeAutorisationsPermanentesHelper.type();
    }

}
