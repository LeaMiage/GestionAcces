package GestionEntreeSortie;

/** 
 * Helper class for : EntreeJournal
 *  
 * @author OpenORB Compiler
 */ 
public class EntreeJournalHelper
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
     * Insert EntreeJournal into an any
     * @param a an any
     * @param t EntreeJournal value
     */
    public static void insert(org.omg.CORBA.Any a, GestionEntreeSortie.EntreeJournal t)
    {
        a.insert_Streamable(new GestionEntreeSortie.EntreeJournalHolder(t));
    }

    /**
     * Extract EntreeJournal from an any
     * @param a an any
     * @return the extracted EntreeJournal value
     */
    public static GestionEntreeSortie.EntreeJournal extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        if (HAS_OPENORB && a instanceof org.openorb.CORBA.Any) {
            // streamable extraction. The jdk stubs incorrectly define the Any stub
            org.openorb.CORBA.Any any = (org.openorb.CORBA.Any)a;
            try {
                org.omg.CORBA.portable.Streamable s = any.extract_Streamable();
                if(s instanceof GestionEntreeSortie.EntreeJournalHolder)
                    return ((GestionEntreeSortie.EntreeJournalHolder)s).value;
            } catch (org.omg.CORBA.BAD_INV_ORDER ex) {
            }
            GestionEntreeSortie.EntreeJournalHolder h = new GestionEntreeSortie.EntreeJournalHolder(read(a.create_input_stream()));
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
     * Return the EntreeJournal TypeCode
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
                org.omg.CORBA.StructMember []_members = new org.omg.CORBA.StructMember[6];

                _members[0] = new org.omg.CORBA.StructMember();
                _members[0].name = "idZone";
                _members[0].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_long);
                _members[1] = new org.omg.CORBA.StructMember();
                _members[1].name = "idPorte";
                _members[1].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_long);
                _members[2] = new org.omg.CORBA.StructMember();
                _members[2].name = "photoP";
                _members[2].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_string);
                _members[3] = new org.omg.CORBA.StructMember();
                _members[3].name = "statut";
                _members[3].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_string);
                _members[4] = new org.omg.CORBA.StructMember();
                _members[4].name = "typeAcces";
                _members[4].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_string);
                _members[5] = new org.omg.CORBA.StructMember();
                _members[5].name = "dateAcces";
                _members[5].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_double);
                _tc = orb.create_struct_tc(id(),"EntreeJournal",_members);
                _working = false;
            }
        }
        return _tc;
    }

    /**
     * Return the EntreeJournal IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:GestionEntreeSortie/EntreeJournal:1.0";

    /**
     * Read EntreeJournal from a marshalled stream
     * @param istream the input stream
     * @return the readed EntreeJournal value
     */
    public static GestionEntreeSortie.EntreeJournal read(org.omg.CORBA.portable.InputStream istream)
    {
        GestionEntreeSortie.EntreeJournal new_one = new GestionEntreeSortie.EntreeJournal();

        new_one.idZone = istream.read_long();
        new_one.idPorte = istream.read_long();
        new_one.photoP = istream.read_string();
        new_one.statut = istream.read_string();
        new_one.typeAcces = istream.read_string();
        new_one.dateAcces = istream.read_double();

        return new_one;
    }

    /**
     * Write EntreeJournal into a marshalled stream
     * @param ostream the output stream
     * @param value EntreeJournal value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, GestionEntreeSortie.EntreeJournal value)
    {
        ostream.write_long(value.idZone);
        ostream.write_long(value.idPorte);
        ostream.write_string(value.photoP);
        ostream.write_string(value.statut);
        ostream.write_string(value.typeAcces);
        ostream.write_double(value.dateAcces);
    }

}
