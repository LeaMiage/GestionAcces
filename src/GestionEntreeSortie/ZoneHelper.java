package GestionEntreeSortie;

/** 
 * Helper class for : Zone
 *  
 * @author OpenORB Compiler
 */ 
public class ZoneHelper
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
     * Insert Zone into an any
     * @param a an any
     * @param t Zone value
     */
    public static void insert(org.omg.CORBA.Any a, GestionEntreeSortie.Zone t)
    {
        a.insert_Streamable(new GestionEntreeSortie.ZoneHolder(t));
    }

    /**
     * Extract Zone from an any
     * @param a an any
     * @return the extracted Zone value
     */
    public static GestionEntreeSortie.Zone extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        if (HAS_OPENORB && a instanceof org.openorb.CORBA.Any) {
            // streamable extraction. The jdk stubs incorrectly define the Any stub
            org.openorb.CORBA.Any any = (org.openorb.CORBA.Any)a;
            try {
                org.omg.CORBA.portable.Streamable s = any.extract_Streamable();
                if(s instanceof GestionEntreeSortie.ZoneHolder)
                    return ((GestionEntreeSortie.ZoneHolder)s).value;
            } catch (org.omg.CORBA.BAD_INV_ORDER ex) {
            }
            GestionEntreeSortie.ZoneHolder h = new GestionEntreeSortie.ZoneHolder(read(a.create_input_stream()));
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
     * Return the Zone TypeCode
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
                org.omg.CORBA.StructMember []_members = new org.omg.CORBA.StructMember[3];

                _members[0] = new org.omg.CORBA.StructMember();
                _members[0].name = "idZone";
                _members[0].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_long);
                _members[1] = new org.omg.CORBA.StructMember();
                _members[1].name = "libelleZone";
                _members[1].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_string);
                _members[2] = new org.omg.CORBA.StructMember();
                _members[2].name = "listeIdPortes";
                _members[2].type = GestionEntreeSortie.IdPortesHelper.type();
                _tc = orb.create_struct_tc(id(),"Zone",_members);
                _working = false;
            }
        }
        return _tc;
    }

    /**
     * Return the Zone IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:GestionEntreeSortie/Zone:1.0";

    /**
     * Read Zone from a marshalled stream
     * @param istream the input stream
     * @return the readed Zone value
     */
    public static GestionEntreeSortie.Zone read(org.omg.CORBA.portable.InputStream istream)
    {
        GestionEntreeSortie.Zone new_one = new GestionEntreeSortie.Zone();

        new_one.idZone = istream.read_long();
        new_one.libelleZone = istream.read_string();
        new_one.listeIdPortes = GestionEntreeSortie.IdPortesHelper.read(istream);

        return new_one;
    }

    /**
     * Write Zone into a marshalled stream
     * @param ostream the output stream
     * @param value Zone value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, GestionEntreeSortie.Zone value)
    {
        ostream.write_long(value.idZone);
        ostream.write_string(value.libelleZone);
        GestionEntreeSortie.IdPortesHelper.write(ostream,value.listeIdPortes);
    }

}
