package GestionEntreeSortie;

/** 
 * Helper class for : Journalisation
 *  
 * @author OpenORB Compiler
 */ 
public class JournalisationHelper
{
    /**
     * Insert Journalisation into an any
     * @param a an any
     * @param t Journalisation value
     */
    public static void insert(org.omg.CORBA.Any a, GestionEntreeSortie.Journalisation t)
    {
        a.insert_Object(t , type());
    }

    /**
     * Extract Journalisation from an any
     * @param a an any
     * @return the extracted Journalisation value
     */
    public static GestionEntreeSortie.Journalisation extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        try {
            return GestionEntreeSortie.JournalisationHelper.narrow(a.extract_Object());
        } catch (final org.omg.CORBA.BAD_PARAM e) {
            throw new org.omg.CORBA.MARSHAL(e.getMessage());
        }
    }

    //
    // Internal TypeCode value
    //
    private static org.omg.CORBA.TypeCode _tc = null;

    /**
     * Return the Journalisation TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            _tc = orb.create_interface_tc(id(),"Journalisation");
        }
        return _tc;
    }

    /**
     * Return the Journalisation IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:GestionEntreeSortie/Journalisation:1.0";

    /**
     * Read Journalisation from a marshalled stream
     * @param istream the input stream
     * @return the readed Journalisation value
     */
    public static GestionEntreeSortie.Journalisation read(org.omg.CORBA.portable.InputStream istream)
    {
        return(GestionEntreeSortie.Journalisation)istream.read_Object(GestionEntreeSortie._JournalisationStub.class);
    }

    /**
     * Write Journalisation into a marshalled stream
     * @param ostream the output stream
     * @param value Journalisation value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, GestionEntreeSortie.Journalisation value)
    {
        ostream.write_Object((org.omg.CORBA.portable.ObjectImpl)value);
    }

    /**
     * Narrow CORBA::Object to Journalisation
     * @param obj the CORBA Object
     * @return Journalisation Object
     */
    public static Journalisation narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof Journalisation)
            return (Journalisation)obj;

        if (obj._is_a(id()))
        {
            _JournalisationStub stub = new _JournalisationStub();
            stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
            return stub;
        }

        throw new org.omg.CORBA.BAD_PARAM();
    }

    /**
     * Unchecked Narrow CORBA::Object to Journalisation
     * @param obj the CORBA Object
     * @return Journalisation Object
     */
    public static Journalisation unchecked_narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof Journalisation)
            return (Journalisation)obj;

        _JournalisationStub stub = new _JournalisationStub();
        stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
        return stub;

    }

}
