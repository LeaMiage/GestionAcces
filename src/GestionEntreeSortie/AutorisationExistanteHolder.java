package GestionEntreeSortie;

/**
 * Holder class for : AutorisationExistante
 * 
 * @author OpenORB Compiler
 */
final public class AutorisationExistanteHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal AutorisationExistante value
     */
    public GestionEntreeSortie.AutorisationExistante value;

    /**
     * Default constructor
     */
    public AutorisationExistanteHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public AutorisationExistanteHolder(GestionEntreeSortie.AutorisationExistante initial)
    {
        value = initial;
    }

    /**
     * Read AutorisationExistante from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = AutorisationExistanteHelper.read(istream);
    }

    /**
     * Write AutorisationExistante into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        AutorisationExistanteHelper.write(ostream,value);
    }

    /**
     * Return the AutorisationExistante TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return AutorisationExistanteHelper.type();
    }

}
