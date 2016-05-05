package GestionEntreeSortie;

/** 
 * Helper class for : listeCollaborateurs
 *  
 * @author OpenORB Compiler
 */ 
public class listeCollaborateursHelper
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
     * Insert listeCollaborateurs into an any
     * @param a an any
     * @param t listeCollaborateurs value
     */
    public static void insert(org.omg.CORBA.Any a, GestionEntreeSortie.Collaborateur[] t)
    {
        a.insert_Streamable(new GestionEntreeSortie.listeCollaborateursHolder(t));
    }

    /**
     * Extract listeCollaborateurs from an any
     * @param a an any
     * @return the extracted listeCollaborateurs value
     */
    public static GestionEntreeSortie.Collaborateur[] extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        if(HAS_OPENORB && a instanceof org.openorb.CORBA.Any) {
            // streamable extraction. The jdk stubs incorrectly define the Any stub
            org.openorb.CORBA.Any any = (org.openorb.CORBA.Any)a;
            try {
                org.omg.CORBA.portable.Streamable s = any.extract_Streamable();
                if(s instanceof GestionEntreeSortie.listeCollaborateursHolder)
                    return ((GestionEntreeSortie.listeCollaborateursHolder)s).value;
            } catch (org.omg.CORBA.BAD_INV_ORDER ex) {
            }
            GestionEntreeSortie.listeCollaborateursHolder h = new GestionEntreeSortie.listeCollaborateursHolder(read(a.create_input_stream()));
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
     * Return the listeCollaborateurs TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            _tc = orb.create_alias_tc(id(),"listeCollaborateurs",orb.create_sequence_tc(0,GestionEntreeSortie.CollaborateurHelper.type()));
        }
        return _tc;
    }

    /**
     * Return the listeCollaborateurs IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:GestionEntreeSortie/listeCollaborateurs:1.0";

    /**
     * Read listeCollaborateurs from a marshalled stream
     * @param istream the input stream
     * @return the readed listeCollaborateurs value
     */
    public static GestionEntreeSortie.Collaborateur[] read(org.omg.CORBA.portable.InputStream istream)
    {
        GestionEntreeSortie.Collaborateur[] new_one;
        {
        int size7 = istream.read_ulong();
        new_one = new GestionEntreeSortie.Collaborateur[size7];
        for (int i7=0; i7<new_one.length; i7++)
         {
            new_one[i7] = GestionEntreeSortie.CollaborateurHelper.read(istream);

         }
        }

        return new_one;
    }

    /**
     * Write listeCollaborateurs into a marshalled stream
     * @param ostream the output stream
     * @param value listeCollaborateurs value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, GestionEntreeSortie.Collaborateur[] value)
    {
        ostream.write_ulong(value.length);
        for (int i7=0; i7<value.length; i7++)
        {
            GestionEntreeSortie.CollaborateurHelper.write(ostream,value[i7]);

        }
    }

}
