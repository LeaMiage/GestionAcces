package GestionEntreeSortie;

/** 
 * Helper class for : GestionSalaries
 *  
 * @author OpenORB Compiler
 */ 
public class GestionSalariesHelper
{
    /**
     * Insert GestionSalaries into an any
     * @param a an any
     * @param t GestionSalaries value
     */
    public static void insert(org.omg.CORBA.Any a, GestionEntreeSortie.GestionSalaries t)
    {
        a.insert_Object(t , type());
    }

    /**
     * Extract GestionSalaries from an any
     * @param a an any
     * @return the extracted GestionSalaries value
     */
    public static GestionEntreeSortie.GestionSalaries extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        try {
            return GestionEntreeSortie.GestionSalariesHelper.narrow(a.extract_Object());
        } catch (final org.omg.CORBA.BAD_PARAM e) {
            throw new org.omg.CORBA.MARSHAL(e.getMessage());
        }
    }

    //
    // Internal TypeCode value
    //
    private static org.omg.CORBA.TypeCode _tc = null;

    /**
     * Return the GestionSalaries TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            _tc = orb.create_interface_tc(id(),"GestionSalaries");
        }
        return _tc;
    }

    /**
     * Return the GestionSalaries IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:GestionEntreeSortie/GestionSalaries:1.0";

    /**
     * Read GestionSalaries from a marshalled stream
     * @param istream the input stream
     * @return the readed GestionSalaries value
     */
    public static GestionEntreeSortie.GestionSalaries read(org.omg.CORBA.portable.InputStream istream)
    {
        return(GestionEntreeSortie.GestionSalaries)istream.read_Object(GestionEntreeSortie._GestionSalariesStub.class);
    }

    /**
     * Write GestionSalaries into a marshalled stream
     * @param ostream the output stream
     * @param value GestionSalaries value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, GestionEntreeSortie.GestionSalaries value)
    {
        ostream.write_Object((org.omg.CORBA.portable.ObjectImpl)value);
    }

    /**
     * Narrow CORBA::Object to GestionSalaries
     * @param obj the CORBA Object
     * @return GestionSalaries Object
     */
    public static GestionSalaries narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof GestionSalaries)
            return (GestionSalaries)obj;

        if (obj._is_a(id()))
        {
            _GestionSalariesStub stub = new _GestionSalariesStub();
            stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
            return stub;
        }

        throw new org.omg.CORBA.BAD_PARAM();
    }

    /**
     * Unchecked Narrow CORBA::Object to GestionSalaries
     * @param obj the CORBA Object
     * @return GestionSalaries Object
     */
    public static GestionSalaries unchecked_narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof GestionSalaries)
            return (GestionSalaries)obj;

        _GestionSalariesStub stub = new _GestionSalariesStub();
        stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
        return stub;

    }

}
