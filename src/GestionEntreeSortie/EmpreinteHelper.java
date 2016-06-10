package GestionEntreeSortie;

/** 
 * Helper class for : Empreinte
 *  
 * @author OpenORB Compiler
 */ 
public class EmpreinteHelper
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
     * Insert Empreinte into an any
     * @param a an any
     * @param t Empreinte value
     */
    public static void insert(org.omg.CORBA.Any a, GestionEntreeSortie.Empreinte t)
    {
        a.insert_Streamable(new GestionEntreeSortie.EmpreinteHolder(t));
    }

    /**
     * Extract Empreinte from an any
     * @param a an any
     * @return the extracted Empreinte value
     */
    public static GestionEntreeSortie.Empreinte extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        if (HAS_OPENORB && a instanceof org.openorb.CORBA.Any) {
            // streamable extraction. The jdk stubs incorrectly define the Any stub
            org.openorb.CORBA.Any any = (org.openorb.CORBA.Any)a;
            try {
                org.omg.CORBA.portable.Streamable s = any.extract_Streamable();
                if(s instanceof GestionEntreeSortie.EmpreinteHolder)
                    return ((GestionEntreeSortie.EmpreinteHolder)s).value;
            } catch (org.omg.CORBA.BAD_INV_ORDER ex) {
            }
            GestionEntreeSortie.EmpreinteHolder h = new GestionEntreeSortie.EmpreinteHolder(read(a.create_input_stream()));
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
     * Return the Empreinte TypeCode
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
                org.omg.CORBA.StructMember []_members = new org.omg.CORBA.StructMember[2];

                _members[0] = new org.omg.CORBA.StructMember();
                _members[0].name = "idPersonne";
                _members[0].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_long);
                _members[1] = new org.omg.CORBA.StructMember();
                _members[1].name = "empreinte";
                _members[1].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_string);
                _tc = orb.create_struct_tc(id(),"Empreinte",_members);
                _working = false;
            }
        }
        return _tc;
    }

    /**
     * Return the Empreinte IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:GestionEntreeSortie/Empreinte:1.0";

    /**
     * Read Empreinte from a marshalled stream
     * @param istream the input stream
     * @return the readed Empreinte value
     */
    public static GestionEntreeSortie.Empreinte read(org.omg.CORBA.portable.InputStream istream)
    {
        GestionEntreeSortie.Empreinte new_one = new GestionEntreeSortie.Empreinte();

        new_one.idPersonne = istream.read_long();
        new_one.empreinte = istream.read_string();

        return new_one;
    }

    /**
     * Write Empreinte into a marshalled stream
     * @param ostream the output stream
     * @param value Empreinte value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, GestionEntreeSortie.Empreinte value)
    {
        ostream.write_long(value.idPersonne);
        ostream.write_string(value.empreinte);
    }

}
