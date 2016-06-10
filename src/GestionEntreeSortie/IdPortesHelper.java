package GestionEntreeSortie;

/** 
 * Helper class for : IdPortes
 *  
 * @author OpenORB Compiler
 */ 
public class IdPortesHelper
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
     * Insert IdPortes into an any
     * @param a an any
     * @param t IdPortes value
     */
    public static void insert(org.omg.CORBA.Any a, int[] t)
    {
        a.insert_Streamable(new GestionEntreeSortie.IdPortesHolder(t));
    }

    /**
     * Extract IdPortes from an any
     * @param a an any
     * @return the extracted IdPortes value
     */
    public static int[] extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        if(HAS_OPENORB && a instanceof org.openorb.CORBA.Any) {
            // streamable extraction. The jdk stubs incorrectly define the Any stub
            org.openorb.CORBA.Any any = (org.openorb.CORBA.Any)a;
            try {
                org.omg.CORBA.portable.Streamable s = any.extract_Streamable();
                if(s instanceof GestionEntreeSortie.IdPortesHolder)
                    return ((GestionEntreeSortie.IdPortesHolder)s).value;
            } catch (org.omg.CORBA.BAD_INV_ORDER ex) {
            }
            GestionEntreeSortie.IdPortesHolder h = new GestionEntreeSortie.IdPortesHolder(read(a.create_input_stream()));
            a.insert_Streamable(h);
            return h.value;
        }
        return read(a.create_input_stream());
    }

    //
    // Internal TypeCode value
    //
    private static org.omg.CORBA.TypeCode _tc = null;

    /**
     * Return the IdPortes TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            _tc = orb.create_alias_tc(id(),"IdPortes",orb.create_sequence_tc(0,orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_long)));
        }
        return _tc;
    }

    /**
     * Return the IdPortes IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:GestionEntreeSortie/IdPortes:1.0";

    /**
     * Read IdPortes from a marshalled stream
     * @param istream the input stream
     * @return the readed IdPortes value
     */
    public static int[] read(org.omg.CORBA.portable.InputStream istream)
    {
        int[] new_one;
        {
        int size7 = istream.read_ulong();
        new_one = new int[size7];
        istream.read_long_array(new_one, 0, new_one.length);
        }

        return new_one;
    }

    /**
     * Write IdPortes into a marshalled stream
     * @param ostream the output stream
     * @param value IdPortes value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, int[] value)
    {
        ostream.write_ulong(value.length);
        ostream.write_long_array(value, 0,value.length);
    }

}
