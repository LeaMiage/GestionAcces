package GestionEntreeSortie;

/**
 * Holder class for : AutorisationTemporaire
 * 
 * @author OpenORB Compiler
 */
final public class AutorisationTemporaireHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal AutorisationTemporaire value
     */
    public GestionEntreeSortie.AutorisationTemporaire value;

    /**
     * Default constructor
     */
    public AutorisationTemporaireHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public AutorisationTemporaireHolder(GestionEntreeSortie.AutorisationTemporaire initial)
    {
        value = initial;
    }

    /**
     * Read AutorisationTemporaire from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = AutorisationTemporaireHelper.read(istream);
    }

    /**
     * Write AutorisationTemporaire into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        AutorisationTemporaireHelper.write(ostream,value);
    }

    /**
     * Return the AutorisationTemporaire TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return AutorisationTemporaireHelper.type();
    }

}
