package GestionEntreeSortie;

/** 
 * Helper class for : PersonneExistante
 *  
 * @author OpenORB Compiler
 */ 
public class PersonneExistanteHelper
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
     * Insert PersonneExistante into an any
     * @param a an any
     * @param t PersonneExistante value
     */
    public static void insert(org.omg.CORBA.Any a, GestionEntreeSortie.PersonneExistante t)
    {
        a.insert_Streamable(new GestionEntreeSortie.PersonneExistanteHolder(t));
    }

    /**
     * Extract PersonneExistante from an any
     * @param a an any
     * @return the extracted PersonneExistante value
     */
    public static GestionEntreeSortie.PersonneExistante extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        if (HAS_OPENORB && a instanceof org.openorb.CORBA.Any) {
            // streamable extraction. The jdk stubs incorrectly define the Any stub
            org.openorb.CORBA.Any any = (org.openorb.CORBA.Any)a;
            try {
                org.omg.CORBA.portable.Streamable s = any.extract_Streamable();
                if(s instanceof GestionEntreeSortie.PersonneExistanteHolder)
                    return ((GestionEntreeSortie.PersonneExistanteHolder)s).value;
            } catch (org.omg.CORBA.BAD_INV_ORDER ex) {
            }
            GestionEntreeSortie.PersonneExistanteHolder h = new GestionEntreeSortie.PersonneExistanteHolder(read(a.create_input_stream()));
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
     * Return the PersonneExistante TypeCode
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
                _tc = orb.create_exception_tc(id(),"PersonneExistante",_members);
                _working = false;
            }
        }
        return _tc;
    }

    /**
     * Return the PersonneExistante IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:GestionEntreeSortie/PersonneExistante:1.0";

    /**
     * Read PersonneExistante from a marshalled stream
     * @param istream the input stream
     * @return the readed PersonneExistante value
     */
    public static GestionEntreeSortie.PersonneExistante read(org.omg.CORBA.portable.InputStream istream)
    {
        GestionEntreeSortie.PersonneExistante new_one = new GestionEntreeSortie.PersonneExistante();

        if (!istream.read_string().equals(id()))
         throw new org.omg.CORBA.MARSHAL();
        new_one.message = istream.read_string();

        return new_one;
    }

    /**
     * Write PersonneExistante into a marshalled stream
     * @param ostream the output stream
     * @param value PersonneExistante value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, GestionEntreeSortie.PersonneExistante value)
    {
        ostream.write_string(id());
        ostream.write_string(value.message);
    }

}
