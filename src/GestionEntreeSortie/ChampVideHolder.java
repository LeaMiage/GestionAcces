package GestionEntreeSortie;

/**
 * Holder class for : ChampVide
 * 
 * @author OpenORB Compiler
 */
final public class ChampVideHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal ChampVide value
     */
    public GestionEntreeSortie.ChampVide value;

    /**
     * Default constructor
     */
    public ChampVideHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public ChampVideHolder(GestionEntreeSortie.ChampVide initial)
    {
        value = initial;
    }

    /**
     * Read ChampVide from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = ChampVideHelper.read(istream);
    }

    /**
     * Write ChampVide into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        ChampVideHelper.write(ostream,value);
    }

    /**
     * Return the ChampVide TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return ChampVideHelper.type();
    }

}
