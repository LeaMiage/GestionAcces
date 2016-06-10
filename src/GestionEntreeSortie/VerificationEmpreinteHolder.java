package GestionEntreeSortie;

/**
 * Holder class for : VerificationEmpreinte
 * 
 * @author OpenORB Compiler
 */
final public class VerificationEmpreinteHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal VerificationEmpreinte value
     */
    public GestionEntreeSortie.VerificationEmpreinte value;

    /**
     * Default constructor
     */
    public VerificationEmpreinteHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public VerificationEmpreinteHolder(GestionEntreeSortie.VerificationEmpreinte initial)
    {
        value = initial;
    }

    /**
     * Read VerificationEmpreinte from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = VerificationEmpreinteHelper.read(istream);
    }

    /**
     * Write VerificationEmpreinte into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        VerificationEmpreinteHelper.write(ostream,value);
    }

    /**
     * Return the VerificationEmpreinte TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return VerificationEmpreinteHelper.type();
    }

}
