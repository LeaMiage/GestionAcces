package GestionEntreeSortie;

/** 
 * Helper class for : GestionEmpreinte
 *  
 * @author OpenORB Compiler
 */ 
public class GestionEmpreinteHelper
{
    /**
     * Insert GestionEmpreinte into an any
     * @param a an any
     * @param t GestionEmpreinte value
     */
    public static void insert(org.omg.CORBA.Any a, GestionEntreeSortie.GestionEmpreinte t)
    {
        a.insert_Object(t , type());
    }

    /**
     * Extract GestionEmpreinte from an any
     * @param a an any
     * @return the extracted GestionEmpreinte value
     */
    public static GestionEntreeSortie.GestionEmpreinte extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        try {
            return GestionEntreeSortie.GestionEmpreinteHelper.narrow(a.extract_Object());
        } catch (final org.omg.CORBA.BAD_PARAM e) {
            throw new org.omg.CORBA.MARSHAL(e.getMessage());
        }
    }

    //
    // Internal TypeCode value
    //
    private static org.omg.CORBA.TypeCode _tc = null;

    /**
     * Return the GestionEmpreinte TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            _tc = orb.create_interface_tc(id(),"GestionEmpreinte");
        }
        return _tc;
    }

    /**
     * Return the GestionEmpreinte IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:GestionEntreeSortie/GestionEmpreinte:1.0";

    /**
     * Read GestionEmpreinte from a marshalled stream
     * @param istream the input stream
     * @return the readed GestionEmpreinte value
     */
    public static GestionEntreeSortie.GestionEmpreinte read(org.omg.CORBA.portable.InputStream istream)
    {
        return(GestionEntreeSortie.GestionEmpreinte)istream.read_Object(GestionEntreeSortie._GestionEmpreinteStub.class);
    }

    /**
     * Write GestionEmpreinte into a marshalled stream
     * @param ostream the output stream
     * @param value GestionEmpreinte value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, GestionEntreeSortie.GestionEmpreinte value)
    {
        ostream.write_Object((org.omg.CORBA.portable.ObjectImpl)value);
    }

    /**
     * Narrow CORBA::Object to GestionEmpreinte
     * @param obj the CORBA Object
     * @return GestionEmpreinte Object
     */
    public static GestionEmpreinte narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof GestionEmpreinte)
            return (GestionEmpreinte)obj;

        if (obj._is_a(id()))
        {
            _GestionEmpreinteStub stub = new _GestionEmpreinteStub();
            stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
            return stub;
        }

        throw new org.omg.CORBA.BAD_PARAM();
    }

    /**
     * Unchecked Narrow CORBA::Object to GestionEmpreinte
     * @param obj the CORBA Object
     * @return GestionEmpreinte Object
     */
    public static GestionEmpreinte unchecked_narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof GestionEmpreinte)
            return (GestionEmpreinte)obj;

        _GestionEmpreinteStub stub = new _GestionEmpreinteStub();
        stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
        return stub;

    }

}
