package GestionEntreeSortie;

/** 
 * Helper class for : AutorisationTemporaire
 *  
 * @author OpenORB Compiler
 */ 
public class AutorisationTemporaireHelper
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
     * Insert AutorisationTemporaire into an any
     * @param a an any
     * @param t AutorisationTemporaire value
     */
    public static void insert(org.omg.CORBA.Any a, GestionEntreeSortie.AutorisationTemporaire t)
    {
        a.insert_Streamable(new GestionEntreeSortie.AutorisationTemporaireHolder(t));
    }

    /**
     * Extract AutorisationTemporaire from an any
     * @param a an any
     * @return the extracted AutorisationTemporaire value
     */
    public static GestionEntreeSortie.AutorisationTemporaire extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        if (HAS_OPENORB && a instanceof org.openorb.CORBA.Any) {
            // streamable extraction. The jdk stubs incorrectly define the Any stub
            org.openorb.CORBA.Any any = (org.openorb.CORBA.Any)a;
            try {
                org.omg.CORBA.portable.Streamable s = any.extract_Streamable();
                if(s instanceof GestionEntreeSortie.AutorisationTemporaireHolder)
                    return ((GestionEntreeSortie.AutorisationTemporaireHolder)s).value;
            } catch (org.omg.CORBA.BAD_INV_ORDER ex) {
            }
            GestionEntreeSortie.AutorisationTemporaireHolder h = new GestionEntreeSortie.AutorisationTemporaireHolder(read(a.create_input_stream()));
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
     * Return the AutorisationTemporaire TypeCode
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
                org.omg.CORBA.StructMember []_members = new org.omg.CORBA.StructMember[4];

                _members[0] = new org.omg.CORBA.StructMember();
                _members[0].name = "heureDebut";
                _members[0].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_string);
                _members[1] = new org.omg.CORBA.StructMember();
                _members[1].name = "heureFin";
                _members[1].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_string);
                _members[2] = new org.omg.CORBA.StructMember();
                _members[2].name = "jourDebut";
                _members[2].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_string);
                _members[3] = new org.omg.CORBA.StructMember();
                _members[3].name = "jourFin";
                _members[3].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_string);
                _tc = orb.create_struct_tc(id(),"AutorisationTemporaire",_members);
                _working = false;
            }
        }
        return _tc;
    }

    /**
     * Return the AutorisationTemporaire IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:GestionEntreeSortie/AutorisationTemporaire:1.0";

    /**
     * Read AutorisationTemporaire from a marshalled stream
     * @param istream the input stream
     * @return the readed AutorisationTemporaire value
     */
    public static GestionEntreeSortie.AutorisationTemporaire read(org.omg.CORBA.portable.InputStream istream)
    {
        GestionEntreeSortie.AutorisationTemporaire new_one = new GestionEntreeSortie.AutorisationTemporaire();

        new_one.heureDebut = istream.read_string();
        new_one.heureFin = istream.read_string();
        new_one.jourDebut = istream.read_string();
        new_one.jourFin = istream.read_string();

        return new_one;
    }

    /**
     * Write AutorisationTemporaire into a marshalled stream
     * @param ostream the output stream
     * @param value AutorisationTemporaire value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, GestionEntreeSortie.AutorisationTemporaire value)
    {
        ostream.write_string(value.heureDebut);
        ostream.write_string(value.heureFin);
        ostream.write_string(value.jourDebut);
        ostream.write_string(value.jourFin);
    }

}
