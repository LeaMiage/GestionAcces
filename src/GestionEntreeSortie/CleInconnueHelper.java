package GestionEntreeSortie;

/** 
 * Helper class for : CleInconnue
 *  
 * @author OpenORB Compiler
 */ 
public class CleInconnueHelper
{
    private static final boolean HAS_OPENORB;
    static {
        boolean hasOpenORB = false;
        try {
            Thread.currentThread().getContextClassLoader().loadClass("org.openorb.CORBA.Any");
            hasOpenORB = true;
        }
        catch(ClassNotFoundException ex) {
        }
        HAS_OPENORB = hasOpenORB;
    }
    /**
     * Insert CleInconnue into an any
     * @param a an any
     * @param t CleInconnue value
     */
    public static void insert(org.omg.CORBA.Any a, GestionEntreeSortie.CleInconnue t)
    {
        a.insert_Streamable(new GestionEntreeSortie.CleInconnueHolder(t));
    }

    /**
     * Extract CleInconnue from an any
     * @param a an any
     * @return the extracted CleInconnue value
     */
    public static GestionEntreeSortie.CleInconnue extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        if (HAS_OPENORB && a instanceof org.openorb.CORBA.Any) {
            // streamable extraction. The jdk stubs incorrectly define the Any stub
            org.openorb.CORBA.Any any = (org.openorb.CORBA.Any)a;
            try {
                org.omg.CORBA.portable.Streamable s = any.extract_Streamable();
                if(s instanceof GestionEntreeSortie.CleInconnueHolder)
                    return ((GestionEntreeSortie.CleInconnueHolder)s).value;
            } catch (org.omg.CORBA.BAD_INV_ORDER ex) {
            }
            GestionEntreeSortie.CleInconnueHolder h = new GestionEntreeSortie.CleInconnueHolder(read(a.create_input_stream()));
            a.insert_Streamable(h);
            return h.value;
        }
        return read(a.create_input_stream());
    }

    //
    // Internal TypeCode value
    //
    private static org.omg.CORBA.TypeCode _tc = null;
    private static boolean _working = false;

    /**
     * Return the CleInconnue TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            synchronized(org.omg.CORBA.TypeCode.class) {
                if (_tc != null)
                    return _tc;
                if (_working)
                    return org.omg.CORBA.ORB.init().create_recursive_tc(id());
                _working = true;
                org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
                org.omg.CORBA.StructMember []_members = new org.omg.CORBA.StructMember[1];

                _members[0] = new org.omg.CORBA.StructMember();
                _members[0].name = "message";
                _members[0].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_string);
                _tc = orb.create_exception_tc(id(),"CleInconnue",_members);
                _working = false;
            }
        }
        return _tc;
    }

    /**
     * Return the CleInconnue IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:GestionEntreeSortie/CleInconnue:1.0";

    /**
     * Read CleInconnue from a marshalled stream
     * @param istream the input stream
     * @return the readed CleInconnue value
     */
    public static GestionEntreeSortie.CleInconnue read(org.omg.CORBA.portable.InputStream istream)
    {
        GestionEntreeSortie.CleInconnue new_one = new GestionEntreeSortie.CleInconnue();

        if (!istream.read_string().equals(id()))
         throw new org.omg.CORBA.MARSHAL();
        new_one.message = istream.read_string();

        return new_one;
    }

    /**
     * Write CleInconnue into a marshalled stream
     * @param ostream the output stream
     * @param value CleInconnue value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, GestionEntreeSortie.CleInconnue value)
    {
        ostream.write_string(id());
        ostream.write_string(value.message);
    }

}
