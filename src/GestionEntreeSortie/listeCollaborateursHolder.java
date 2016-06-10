package GestionEntreeSortie;

/**
 * Holder class for : listeCollaborateurs
 * 
 * @author OpenORB Compiler
 */
final public class listeCollaborateursHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal listeCollaborateurs value
     */
    public GestionEntreeSortie.Collaborateur[] value;

    /**
     * Default constructor
     */
    public listeCollaborateursHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public listeCollaborateursHolder(GestionEntreeSortie.Collaborateur[] initial)
    {
        value = initial;
    }

    /**
     * Read listeCollaborateurs from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = listeCollaborateursHelper.read(istream);
    }

    /**
     * Write listeCollaborateurs into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        listeCollaborateursHelper.write(ostream,value);
    }

    /**
     * Return the listeCollaborateurs TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return listeCollaborateursHelper.type();
    }

}
