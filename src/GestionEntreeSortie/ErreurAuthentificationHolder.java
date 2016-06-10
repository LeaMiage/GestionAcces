package GestionEntreeSortie;

/**
 * Holder class for : ErreurAuthentification
 * 
 * @author OpenORB Compiler
 */
final public class ErreurAuthentificationHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal ErreurAuthentification value
     */
    public GestionEntreeSortie.ErreurAuthentification value;

    /**
     * Default constructor
     */
    public ErreurAuthentificationHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public ErreurAuthentificationHolder(GestionEntreeSortie.ErreurAuthentification initial)
    {
        value = initial;
    }

    /**
     * Read ErreurAuthentification from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = ErreurAuthentificationHelper.read(istream);
    }

    /**
     * Write ErreurAuthentification into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        ErreurAuthentificationHelper.write(ostream,value);
    }

    /**
     * Return the ErreurAuthentification TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return ErreurAuthentificationHelper.type();
    }

}
