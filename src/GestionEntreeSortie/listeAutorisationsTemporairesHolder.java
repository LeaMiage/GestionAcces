package GestionEntreeSortie;

/**
 * Holder class for : listeAutorisationsTemporaires
 * 
 * @author OpenORB Compiler
 */
final public class listeAutorisationsTemporairesHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal listeAutorisationsTemporaires value
     */
    public GestionEntreeSortie.AutorisationTemporaire[] value;

    /**
     * Default constructor
     */
    public listeAutorisationsTemporairesHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public listeAutorisationsTemporairesHolder(GestionEntreeSortie.AutorisationTemporaire[] initial)
    {
        value = initial;
    }

    /**
     * Read listeAutorisationsTemporaires from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = listeAutorisationsTemporairesHelper.read(istream);
    }

    /**
     * Write listeAutorisationsTemporaires into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        listeAutorisationsTemporairesHelper.write(ostream,value);
    }

    /**
     * Return the listeAutorisationsTemporaires TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return listeAutorisationsTemporairesHelper.type();
    }

}
