package GestionEntreeSortie;

/**
 * Holder class for : GestionSalaries
 * 
 * @author OpenORB Compiler
 */
final public class GestionSalariesHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal GestionSalaries value
     */
    public GestionEntreeSortie.GestionSalaries value;

    /**
     * Default constructor
     */
    public GestionSalariesHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public GestionSalariesHolder(GestionEntreeSortie.GestionSalaries initial)
    {
        value = initial;
    }

    /**
     * Read GestionSalaries from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = GestionSalariesHelper.read(istream);
    }

    /**
     * Write GestionSalaries into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        GestionSalariesHelper.write(ostream,value);
    }

    /**
     * Return the GestionSalaries TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return GestionSalariesHelper.type();
    }

}
