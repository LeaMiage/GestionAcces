package GestionEntreeSortie;

/**
 * Holder class for : CreationCompte
 * 
 * @author OpenORB Compiler
 */
final public class CreationCompteHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal CreationCompte value
     */
    public GestionEntreeSortie.CreationCompte value;

    /**
     * Default constructor
     */
    public CreationCompteHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public CreationCompteHolder(GestionEntreeSortie.CreationCompte initial)
    {
        value = initial;
    }

    /**
     * Read CreationCompte from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = CreationCompteHelper.read(istream);
    }

    /**
     * Write CreationCompte into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        CreationCompteHelper.write(ostream,value);
    }

    /**
     * Return the CreationCompte TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return CreationCompteHelper.type();
    }

}
