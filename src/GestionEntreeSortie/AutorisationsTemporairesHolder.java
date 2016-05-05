package GestionEntreeSortie;

/**
 * Holder class for : AutorisationsTemporaires
 * 
 * @author OpenORB Compiler
 */
final public class AutorisationsTemporairesHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal AutorisationsTemporaires value
     */
    public GestionEntreeSortie.AutorisationTemporaire[] value;

    /**
     * Default constructor
     */
    public AutorisationsTemporairesHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public AutorisationsTemporairesHolder(GestionEntreeSortie.AutorisationTemporaire[] initial)
    {
        value = initial;
    }

    /**
     * Read AutorisationsTemporaires from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = AutorisationsTemporairesHelper.read(istream);
    }

    /**
     * Write AutorisationsTemporaires into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        AutorisationsTemporairesHelper.write(ostream,value);
    }

    /**
     * Return the AutorisationsTemporaires TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return AutorisationsTemporairesHelper.type();
    }

}
