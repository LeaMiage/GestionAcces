package GestionEntreeSortie;

/**
 * Holder class for : JournalisationImpossible
 * 
 * @author OpenORB Compiler
 */
final public class JournalisationImpossibleHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal JournalisationImpossible value
     */
    public GestionEntreeSortie.JournalisationImpossible value;

    /**
     * Default constructor
     */
    public JournalisationImpossibleHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public JournalisationImpossibleHolder(GestionEntreeSortie.JournalisationImpossible initial)
    {
        value = initial;
    }

    /**
     * Read JournalisationImpossible from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = JournalisationImpossibleHelper.read(istream);
    }

    /**
     * Write JournalisationImpossible into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        JournalisationImpossibleHelper.write(ostream,value);
    }

    /**
     * Return the JournalisationImpossible TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return JournalisationImpossibleHelper.type();
    }

}
