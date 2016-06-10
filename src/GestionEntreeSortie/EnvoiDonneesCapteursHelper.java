package GestionEntreeSortie;

/** 
 * Helper class for : EnvoiDonneesCapteurs
 *  
 * @author OpenORB Compiler
 */ 
public class EnvoiDonneesCapteursHelper
{
    /**
     * Insert EnvoiDonneesCapteurs into an any
     * @param a an any
     * @param t EnvoiDonneesCapteurs value
     */
    public static void insert(org.omg.CORBA.Any a, GestionEntreeSortie.EnvoiDonneesCapteurs t)
    {
        a.insert_Object(t , type());
    }

    /**
     * Extract EnvoiDonneesCapteurs from an any
     * @param a an any
     * @return the extracted EnvoiDonneesCapteurs value
     */
    public static GestionEntreeSortie.EnvoiDonneesCapteurs extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        try {
            return GestionEntreeSortie.EnvoiDonneesCapteursHelper.narrow(a.extract_Object());
        } catch (final org.omg.CORBA.BAD_PARAM e) {
            throw new org.omg.CORBA.MARSHAL(e.getMessage());
        }
    }

    //
    // Internal TypeCode value
    //
    private static org.omg.CORBA.TypeCode _tc = null;

    /**
     * Return the EnvoiDonneesCapteurs TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            _tc = orb.create_interface_tc(id(),"EnvoiDonneesCapteurs");
        }
        return _tc;
    }

    /**
     * Return the EnvoiDonneesCapteurs IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:GestionEntreeSortie/EnvoiDonneesCapteurs:1.0";

    /**
     * Read EnvoiDonneesCapteurs from a marshalled stream
     * @param istream the input stream
     * @return the readed EnvoiDonneesCapteurs value
     */
    public static GestionEntreeSortie.EnvoiDonneesCapteurs read(org.omg.CORBA.portable.InputStream istream)
    {
        return(GestionEntreeSortie.EnvoiDonneesCapteurs)istream.read_Object(GestionEntreeSortie._EnvoiDonneesCapteursStub.class);
    }

    /**
     * Write EnvoiDonneesCapteurs into a marshalled stream
     * @param ostream the output stream
     * @param value EnvoiDonneesCapteurs value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, GestionEntreeSortie.EnvoiDonneesCapteurs value)
    {
        ostream.write_Object((org.omg.CORBA.portable.ObjectImpl)value);
    }

    /**
     * Narrow CORBA::Object to EnvoiDonneesCapteurs
     * @param obj the CORBA Object
     * @return EnvoiDonneesCapteurs Object
     */
    public static EnvoiDonneesCapteurs narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof EnvoiDonneesCapteurs)
            return (EnvoiDonneesCapteurs)obj;

        if (obj._is_a(id()))
        {
            _EnvoiDonneesCapteursStub stub = new _EnvoiDonneesCapteursStub();
            stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
            return stub;
        }

        throw new org.omg.CORBA.BAD_PARAM();
    }

    /**
     * Unchecked Narrow CORBA::Object to EnvoiDonneesCapteurs
     * @param obj the CORBA Object
     * @return EnvoiDonneesCapteurs Object
     */
    public static EnvoiDonneesCapteurs unchecked_narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof EnvoiDonneesCapteurs)
            return (EnvoiDonneesCapteurs)obj;

        _EnvoiDonneesCapteursStub stub = new _EnvoiDonneesCapteursStub();
        stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
        return stub;

    }

}
