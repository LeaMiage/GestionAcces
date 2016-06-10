package GestionEntreeSortie;

/**
 * Holder class for : ErreurEnvoi
 * 
 * @author OpenORB Compiler
 */
final public class ErreurEnvoiHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal ErreurEnvoi value
     */
    public GestionEntreeSortie.ErreurEnvoi value;

    /**
     * Default constructor
     */
    public ErreurEnvoiHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public ErreurEnvoiHolder(GestionEntreeSortie.ErreurEnvoi initial)
    {
        value = initial;
    }

    /**
     * Read ErreurEnvoi from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = ErreurEnvoiHelper.read(istream);
    }

    /**
     * Write ErreurEnvoi into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        ErreurEnvoiHelper.write(ostream,value);
    }

    /**
     * Return the ErreurEnvoi TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return ErreurEnvoiHelper.type();
    }

}
