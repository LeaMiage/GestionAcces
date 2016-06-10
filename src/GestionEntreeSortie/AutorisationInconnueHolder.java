package GestionEntreeSortie;

/**
 * Holder class for : AutorisationInconnue
 * 
 * @author OpenORB Compiler
 */
final public class AutorisationInconnueHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal AutorisationInconnue value
     */
    public GestionEntreeSortie.AutorisationInconnue value;

    /**
     * Default constructor
     */
    public AutorisationInconnueHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public AutorisationInconnueHolder(GestionEntreeSortie.AutorisationInconnue initial)
    {
        value = initial;
    }

    /**
     * Read AutorisationInconnue from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = AutorisationInconnueHelper.read(istream);
    }

    /**
     * Write AutorisationInconnue into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        AutorisationInconnueHelper.write(ostream,value);
    }

    /**
     * Return the AutorisationInconnue TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return AutorisationInconnueHelper.type();
    }

}
