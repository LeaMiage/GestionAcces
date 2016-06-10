package GestionEntreeSortie;

/**
 * Holder class for : PersonneExistante
 * 
 * @author OpenORB Compiler
 */
final public class PersonneExistanteHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal PersonneExistante value
     */
    public GestionEntreeSortie.PersonneExistante value;

    /**
     * Default constructor
     */
    public PersonneExistanteHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public PersonneExistanteHolder(GestionEntreeSortie.PersonneExistante initial)
    {
        value = initial;
    }

    /**
     * Read PersonneExistante from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = PersonneExistanteHelper.read(istream);
    }

    /**
     * Write PersonneExistante into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        PersonneExistanteHelper.write(ostream,value);
    }

    /**
     * Return the PersonneExistante TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return PersonneExistanteHelper.type();
    }

}
