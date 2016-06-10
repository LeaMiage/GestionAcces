package GestionEntreeSortie;

/**
 * Holder class for : IdentiteCollaborateur
 * 
 * @author OpenORB Compiler
 */
final public class IdentiteCollaborateurHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal IdentiteCollaborateur value
     */
    public GestionEntreeSortie.IdentiteCollaborateur value;

    /**
     * Default constructor
     */
    public IdentiteCollaborateurHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public IdentiteCollaborateurHolder(GestionEntreeSortie.IdentiteCollaborateur initial)
    {
        value = initial;
    }

    /**
     * Read IdentiteCollaborateur from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = IdentiteCollaborateurHelper.read(istream);
    }

    /**
     * Write IdentiteCollaborateur into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        IdentiteCollaborateurHelper.write(ostream,value);
    }

    /**
     * Return the IdentiteCollaborateur TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return IdentiteCollaborateurHelper.type();
    }

}
