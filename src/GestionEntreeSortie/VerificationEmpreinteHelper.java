package GestionEntreeSortie;

/** 
 * Helper class for : VerificationEmpreinte
 *  
 * @author OpenORB Compiler
 */ 
public class VerificationEmpreinteHelper
{
    /**
     * Insert VerificationEmpreinte into an any
     * @param a an any
     * @param t VerificationEmpreinte value
     */
    public static void insert(org.omg.CORBA.Any a, GestionEntreeSortie.VerificationEmpreinte t)
    {
        a.insert_Object(t , type());
    }

    /**
     * Extract VerificationEmpreinte from an any
     * @param a an any
     * @return the extracted VerificationEmpreinte value
     */
    public static GestionEntreeSortie.VerificationEmpreinte extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        try {
            return GestionEntreeSortie.VerificationEmpreinteHelper.narrow(a.extract_Object());
        } catch (final org.omg.CORBA.BAD_PARAM e) {
            throw new org.omg.CORBA.MARSHAL(e.getMessage());
        }
    }

    //
    // Internal TypeCode value
    //
    private static org.omg.CORBA.TypeCode _tc = null;

    /**
     * Return the VerificationEmpreinte TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            _tc = orb.create_interface_tc(id(),"VerificationEmpreinte");
        }
        return _tc;
    }

    /**
     * Return the VerificationEmpreinte IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:GestionEntreeSortie/VerificationEmpreinte:1.0";

    /**
     * Read VerificationEmpreinte from a marshalled stream
     * @param istream the input stream
     * @return the readed VerificationEmpreinte value
     */
    public static GestionEntreeSortie.VerificationEmpreinte read(org.omg.CORBA.portable.InputStream istream)
    {
        return(GestionEntreeSortie.VerificationEmpreinte)istream.read_Object(GestionEntreeSortie._VerificationEmpreinteStub.class);
    }

    /**
     * Write VerificationEmpreinte into a marshalled stream
     * @param ostream the output stream
     * @param value VerificationEmpreinte value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, GestionEntreeSortie.VerificationEmpreinte value)
    {
        ostream.write_Object((org.omg.CORBA.portable.ObjectImpl)value);
    }

    /**
     * Narrow CORBA::Object to VerificationEmpreinte
     * @param obj the CORBA Object
     * @return VerificationEmpreinte Object
     */
    public static VerificationEmpreinte narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof VerificationEmpreinte)
            return (VerificationEmpreinte)obj;

        if (obj._is_a(id()))
        {
            _VerificationEmpreinteStub stub = new _VerificationEmpreinteStub();
            stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
            return stub;
        }

        throw new org.omg.CORBA.BAD_PARAM();
    }

    /**
     * Unchecked Narrow CORBA::Object to VerificationEmpreinte
     * @param obj the CORBA Object
     * @return VerificationEmpreinte Object
     */
    public static VerificationEmpreinte unchecked_narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof VerificationEmpreinte)
            return (VerificationEmpreinte)obj;

        _VerificationEmpreinteStub stub = new _VerificationEmpreinteStub();
        stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
        return stub;

    }

}
