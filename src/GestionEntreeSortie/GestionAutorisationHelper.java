package GestionEntreeSortie;

/** 
 * Helper class for : GestionAutorisation
 *  
 * @author OpenORB Compiler
 */ 
public class GestionAutorisationHelper
{
    /**
     * Insert GestionAutorisation into an any
     * @param a an any
     * @param t GestionAutorisation value
     */
    public static void insert(org.omg.CORBA.Any a, GestionEntreeSortie.GestionAutorisation t)
    {
        a.insert_Object(t , type());
    }

    /**
     * Extract GestionAutorisation from an any
     * @param a an any
     * @return the extracted GestionAutorisation value
     */
    public static GestionEntreeSortie.GestionAutorisation extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        try {
            return GestionEntreeSortie.GestionAutorisationHelper.narrow(a.extract_Object());
        } catch (final org.omg.CORBA.BAD_PARAM e) {
            throw new org.omg.CORBA.MARSHAL(e.getMessage());
        }
    }

    //
    // Internal TypeCode value
    //
    private static org.omg.CORBA.TypeCode _tc = null;

    /**
     * Return the GestionAutorisation TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            _tc = orb.create_interface_tc(id(),"GestionAutorisation");
        }
        return _tc;
    }

    /**
     * Return the GestionAutorisation IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:GestionEntreeSortie/GestionAutorisation:1.0";

    /**
     * Read GestionAutorisation from a marshalled stream
     * @param istream the input stream
     * @return the readed GestionAutorisation value
     */
    public static GestionEntreeSortie.GestionAutorisation read(org.omg.CORBA.portable.InputStream istream)
    {
        return(GestionEntreeSortie.GestionAutorisation)istream.read_Object(GestionEntreeSortie._GestionAutorisationStub.class);
    }

    /**
     * Write GestionAutorisation into a marshalled stream
     * @param ostream the output stream
     * @param value GestionAutorisation value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, GestionEntreeSortie.GestionAutorisation value)
    {
        ostream.write_Object((org.omg.CORBA.portable.ObjectImpl)value);
    }

    /**
     * Narrow CORBA::Object to GestionAutorisation
     * @param obj the CORBA Object
     * @return GestionAutorisation Object
     */
    public static GestionAutorisation narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof GestionAutorisation)
            return (GestionAutorisation)obj;

        if (obj._is_a(id()))
        {
            _GestionAutorisationStub stub = new _GestionAutorisationStub();
            stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
            return stub;
        }

        throw new org.omg.CORBA.BAD_PARAM();
    }

    /**
     * Unchecked Narrow CORBA::Object to GestionAutorisation
     * @param obj the CORBA Object
     * @return GestionAutorisation Object
     */
    public static GestionAutorisation unchecked_narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof GestionAutorisation)
            return (GestionAutorisation)obj;

        _GestionAutorisationStub stub = new _GestionAutorisationStub();
        stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
        return stub;

    }

}
