package GestionEntreeSortie;

/**
 * Holder class for : AutorisationPermanente
 * 
 * @author OpenORB Compiler
 */
final public class AutorisationPermanenteHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal AutorisationPermanente value
     */
    public GestionEntreeSortie.AutorisationPermanente value;

    /**
     * Default constructor
     */
    public AutorisationPermanenteHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public AutorisationPermanenteHolder(GestionEntreeSortie.AutorisationPermanente initial)
    {
        value = initial;
    }

    /**
     * Read AutorisationPermanente from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = AutorisationPermanenteHelper.read(istream);
    }

    /**
     * Write AutorisationPermanente into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        AutorisationPermanenteHelper.write(ostream,value);
    }

    /**
     * Return the AutorisationPermanente TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return AutorisationPermanenteHelper.type();
    }

}
