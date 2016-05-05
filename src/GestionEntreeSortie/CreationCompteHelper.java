package GestionEntreeSortie;

/** 
 * Helper class for : CreationCompte
 *  
 * @author OpenORB Compiler
 */ 
public class CreationCompteHelper
{
    /**
     * Insert CreationCompte into an any
     * @param a an any
     * @param t CreationCompte value
     */
    public static void insert(org.omg.CORBA.Any a, GestionEntreeSortie.CreationCompte t)
    {
        a.insert_Object(t , type());
    }

    /**
     * Extract CreationCompte from an any
     * @param a an any
     * @return the extracted CreationCompte value
     */
    public static GestionEntreeSortie.CreationCompte extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        try {
            return GestionEntreeSortie.CreationCompteHelper.narrow(a.extract_Object());
        } catch (final org.omg.CORBA.BAD_PARAM e) {
            throw new org.omg.CORBA.MARSHAL(e.getMessage());
        }
    }

    //
    // Internal TypeCode value
    //
    private static org.omg.CORBA.TypeCode _tc = null;

    /**
     * Return the CreationCompte TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            _tc = orb.create_interface_tc(id(),"CreationCompte");
        }
        return _tc;
    }

    /**
     * Return the CreationCompte IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:GestionEntreeSortie/CreationCompte:1.0";

    /**
     * Read CreationCompte from a marshalled stream
     * @param istream the input stream
     * @return the readed CreationCompte value
     */
    public static GestionEntreeSortie.CreationCompte read(org.omg.CORBA.portable.InputStream istream)
    {
        return(GestionEntreeSortie.CreationCompte)istream.read_Object(GestionEntreeSortie._CreationCompteStub.class);
    }

    /**
     * Write CreationCompte into a marshalled stream
     * @param ostream the output stream
     * @param value CreationCompte value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, GestionEntreeSortie.CreationCompte value)
    {
        ostream.write_Object((org.omg.CORBA.portable.ObjectImpl)value);
    }

    /**
     * Narrow CORBA::Object to CreationCompte
     * @param obj the CORBA Object
     * @return CreationCompte Object
     */
    public static CreationCompte narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof CreationCompte)
            return (CreationCompte)obj;

        if (obj._is_a(id()))
        {
            _CreationCompteStub stub = new _CreationCompteStub();
            stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
            return stub;
        }

        throw new org.omg.CORBA.BAD_PARAM();
    }

    /**
     * Unchecked Narrow CORBA::Object to CreationCompte
     * @param obj the CORBA Object
     * @return CreationCompte Object
     */
    public static CreationCompte unchecked_narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof CreationCompte)
            return (CreationCompte)obj;

        _CreationCompteStub stub = new _CreationCompteStub();
        stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
        return stub;

    }

}
