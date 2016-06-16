package GestionEntreeSortie;

/**
 * Holder class for : AjoutAPImpossible
 * 
 * @author OpenORB Compiler
 */
final public class AjoutAPImpossibleHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal AjoutAPImpossible value
     */
    public GestionEntreeSortie.AjoutAPImpossible value;

    /**
     * Default constructor
     */
    public AjoutAPImpossibleHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public AjoutAPImpossibleHolder(GestionEntreeSortie.AjoutAPImpossible initial)
    {
        value = initial;
    }

    /**
     * Read AjoutAPImpossible from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = AjoutAPImpossibleHelper.read(istream);
    }

    /**
     * Write AjoutAPImpossible into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        AjoutAPImpossibleHelper.write(ostream,value);
    }

    /**
     * Return the AjoutAPImpossible TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return AjoutAPImpossibleHelper.type();
    }

}
