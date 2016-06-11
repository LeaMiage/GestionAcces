package GestionEntreeSortie;

/** 
 * Helper class for : Autorisation
 *  
 * @author OpenORB Compiler
 */ 
public class AutorisationHelper
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
     * Insert Autorisation into an any
     * @param a an any
     * @param t Autorisation value
     */
    public static void insert(org.omg.CORBA.Any a, GestionEntreeSortie.Autorisation t)
    {
        a.insert_Streamable(new GestionEntreeSortie.AutorisationHolder(t));
    }

    /**
     * Extract Autorisation from an any
     * @param a an any
     * @return the extracted Autorisation value
     */
    public static GestionEntreeSortie.Autorisation extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        if (HAS_OPENORB && a instanceof org.openorb.CORBA.Any) {
            // streamable extraction. The jdk stubs incorrectly define the Any stub
            org.openorb.CORBA.Any any = (org.openorb.CORBA.Any)a;
            try {
                org.omg.CORBA.portable.Streamable s = any.extract_Streamable();
                if(s instanceof GestionEntreeSortie.AutorisationHolder)
                    return ((GestionEntreeSortie.AutorisationHolder)s).value;
            } catch (org.omg.CORBA.BAD_INV_ORDER ex) {
            }
            GestionEntreeSortie.AutorisationHolder h = new GestionEntreeSortie.AutorisationHolder(read(a.create_input_stream()));
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
     * Return the Autorisation TypeCode
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
                _members[0].name = "idPersonne";
                _members[0].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_long);
                _members[1] = new org.omg.CORBA.StructMember();
                _members[1].name = "heureDebut";
                _members[1].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_string);
                _members[2] = new org.omg.CORBA.StructMember();
                _members[2].name = "heureFin";
                _members[2].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_string);
                _tc = orb.create_struct_tc(id(),"Autorisation",_members);
                _working = false;
            }
        }
        return _tc;
    }

    /**
     * Return the Autorisation IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:GestionEntreeSortie/Autorisation:1.0";

    /**
     * Read Autorisation from a marshalled stream
     * @param istream the input stream
     * @return the readed Autorisation value
     */
    public static GestionEntreeSortie.Autorisation read(org.omg.CORBA.portable.InputStream istream)
    {
        GestionEntreeSortie.Autorisation new_one = new GestionEntreeSortie.Autorisation();

        new_one.idPersonne = istream.read_long();
        new_one.heureDebut = istream.read_string();
        new_one.heureFin = istream.read_string();

        return new_one;
    }

    /**
     * Write Autorisation into a marshalled stream
     * @param ostream the output stream
     * @param value Autorisation value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, GestionEntreeSortie.Autorisation value)
    {
        ostream.write_long(value.idPersonne);
        ostream.write_string(value.heureDebut);
        ostream.write_string(value.heureFin);
    }

}
