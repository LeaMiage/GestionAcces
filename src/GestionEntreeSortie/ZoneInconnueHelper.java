package GestionEntreeSortie;

/** 
 * Helper class for : ZoneInconnue
 *  
 * @author OpenORB Compiler
 */ 
public class ZoneInconnueHelper
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
     * Insert ZoneInconnue into an any
     * @param a an any
     * @param t ZoneInconnue value
     */
    public static void insert(org.omg.CORBA.Any a, GestionEntreeSortie.ZoneInconnue t)
    {
        a.insert_Streamable(new GestionEntreeSortie.ZoneInconnueHolder(t));
    }

    /**
     * Extract ZoneInconnue from an any
     * @param a an any
     * @return the extracted ZoneInconnue value
     */
    public static GestionEntreeSortie.ZoneInconnue extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        if (HAS_OPENORB && a instanceof org.openorb.CORBA.Any) {
            // streamable extraction. The jdk stubs incorrectly define the Any stub
            org.openorb.CORBA.Any any = (org.openorb.CORBA.Any)a;
            try {
                org.omg.CORBA.portable.Streamable s = any.extract_Streamable();
                if(s instanceof GestionEntreeSortie.ZoneInconnueHolder)
                    return ((GestionEntreeSortie.ZoneInconnueHolder)s).value;
            } catch (org.omg.CORBA.BAD_INV_ORDER ex) {
            }
            GestionEntreeSortie.ZoneInconnueHolder h = new GestionEntreeSortie.ZoneInconnueHolder(read(a.create_input_stream()));
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
     * Return the ZoneInconnue TypeCode
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
                _tc = orb.create_exception_tc(id(),"ZoneInconnue",_members);
                _working = false;
            }
        }
        return _tc;
    }

    /**
     * Return the ZoneInconnue IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:GestionEntreeSortie/ZoneInconnue:1.0";

    /**
     * Read ZoneInconnue from a marshalled stream
     * @param istream the input stream
     * @return the readed ZoneInconnue value
     */
    public static GestionEntreeSortie.ZoneInconnue read(org.omg.CORBA.portable.InputStream istream)
    {
        GestionEntreeSortie.ZoneInconnue new_one = new GestionEntreeSortie.ZoneInconnue();

        if (!istream.read_string().equals(id()))
         throw new org.omg.CORBA.MARSHAL();
        new_one.message = istream.read_string();

        return new_one;
    }

    /**
     * Write ZoneInconnue into a marshalled stream
     * @param ostream the output stream
     * @param value ZoneInconnue value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, GestionEntreeSortie.ZoneInconnue value)
    {
        ostream.write_string(id());
        ostream.write_string(value.message);
    }

}
