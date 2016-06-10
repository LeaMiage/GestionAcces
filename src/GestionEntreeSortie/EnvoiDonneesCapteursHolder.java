package GestionEntreeSortie;

/**
 * Holder class for : EnvoiDonneesCapteurs
 * 
 * @author OpenORB Compiler
 */
final public class EnvoiDonneesCapteursHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal EnvoiDonneesCapteurs value
     */
    public GestionEntreeSortie.EnvoiDonneesCapteurs value;

    /**
     * Default constructor
     */
    public EnvoiDonneesCapteursHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public EnvoiDonneesCapteursHolder(GestionEntreeSortie.EnvoiDonneesCapteurs initial)
    {
        value = initial;
    }

    /**
     * Read EnvoiDonneesCapteurs from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = EnvoiDonneesCapteursHelper.read(istream);
    }

    /**
     * Write EnvoiDonneesCapteurs into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        EnvoiDonneesCapteursHelper.write(ostream,value);
    }

    /**
     * Return the EnvoiDonneesCapteurs TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return EnvoiDonneesCapteursHelper.type();
    }

}
