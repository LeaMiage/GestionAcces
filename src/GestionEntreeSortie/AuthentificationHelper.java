package GestionEntreeSortie;

/** 
 * Helper class for : Authentification
 *  
 * @author OpenORB Compiler
 */ 
public class AuthentificationHelper
{
    /**
     * Insert Authentification into an any
     * @param a an any
     * @param t Authentification value
     */
    public static void insert(org.omg.CORBA.Any a, GestionEntreeSortie.Authentification t)
    {
        a.insert_Object(t , type());
    }

    /**
     * Extract Authentification from an any
     * @param a an any
     * @return the extracted Authentification value
     */
    public static GestionEntreeSortie.Authentification extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        try {
            return GestionEntreeSortie.AuthentificationHelper.narrow(a.extract_Object());
        } catch (final org.omg.CORBA.BAD_PARAM e) {
            throw new org.omg.CORBA.MARSHAL(e.getMessage());
        }
    }

    //
    // Internal TypeCode value
    //
    private static org.omg.CORBA.TypeCode _tc = null;

    /**
     * Return the Authentification TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            _tc = orb.create_interface_tc(id(),"Authentification");
        }
        return _tc;
    }

    /**
     * Return the Authentification IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:GestionEntreeSortie/Authentification:1.0";

    /**
     * Read Authentification from a marshalled stream
     * @param istream the input stream
     * @return the readed Authentification value
     */
    public static GestionEntreeSortie.Authentification read(org.omg.CORBA.portable.InputStream istream)
    {
        return(GestionEntreeSortie.Authentification)istream.read_Object(GestionEntreeSortie._AuthentificationStub.class);
    }

    /**
     * Write Authentification into a marshalled stream
     * @param ostream the output stream
     * @param value Authentification value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, GestionEntreeSortie.Authentification value)
    {
        ostream.write_Object((org.omg.CORBA.portable.ObjectImpl)value);
    }

    /**
     * Narrow CORBA::Object to Authentification
     * @param obj the CORBA Object
     * @return Authentification Object
     */
    public static Authentification narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof Authentification)
            return (Authentification)obj;

        if (obj._is_a(id()))
        {
            _AuthentificationStub stub = new _AuthentificationStub();
            stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
            return stub;
        }

        throw new org.omg.CORBA.BAD_PARAM();
    }

    /**
     * Unchecked Narrow CORBA::Object to Authentification
     * @param obj the CORBA Object
     * @return Authentification Object
     */
    public static Authentification unchecked_narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof Authentification)
            return (Authentification)obj;

        _AuthentificationStub stub = new _AuthentificationStub();
        stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
        return stub;

    }

}
