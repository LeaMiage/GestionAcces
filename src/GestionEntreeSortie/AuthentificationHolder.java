package GestionEntreeSortie;

/**
 * Holder class for : Authentification
 * 
 * @author OpenORB Compiler
 */
final public class AuthentificationHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal Authentification value
     */
    public GestionEntreeSortie.Authentification value;

    /**
     * Default constructor
     */
    public AuthentificationHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public AuthentificationHolder(GestionEntreeSortie.Authentification initial)
    {
        value = initial;
    }

    /**
     * Read Authentification from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = AuthentificationHelper.read(istream);
    }

    /**
     * Write Authentification into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        AuthentificationHelper.write(ostream,value);
    }

    /**
     * Return the Authentification TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return AuthentificationHelper.type();
    }

}
