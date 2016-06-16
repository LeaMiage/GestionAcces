package GestionEntreeSortie;

/** 
 * Helper class for : listeAutorisationsTemporaires
 *  
 * @author OpenORB Compiler
 */ 
public class listeAutorisationsTemporairesHelper
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
     * Insert listeAutorisationsTemporaires into an any
     * @param a an any
     * @param t listeAutorisationsTemporaires value
     */
    public static void insert(org.omg.CORBA.Any a, GestionEntreeSortie.AutorisationTemporaire[] t)
    {
        a.insert_Streamable(new GestionEntreeSortie.listeAutorisationsTemporairesHolder(t));
    }

    /**
     * Extract listeAutorisationsTemporaires from an any
     * @param a an any
     * @return the extracted listeAutorisationsTemporaires value
     */
    public static GestionEntreeSortie.AutorisationTemporaire[] extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        if(HAS_OPENORB && a instanceof org.openorb.CORBA.Any) {
            // streamable extraction. The jdk stubs incorrectly define the Any stub
            org.openorb.CORBA.Any any = (org.openorb.CORBA.Any)a;
            try {
                org.omg.CORBA.portable.Streamable s = any.extract_Streamable();
                if(s instanceof GestionEntreeSortie.listeAutorisationsTemporairesHolder)
                    return ((GestionEntreeSortie.listeAutorisationsTemporairesHolder)s).value;
            } catch (org.omg.CORBA.BAD_INV_ORDER ex) {
            }
            GestionEntreeSortie.listeAutorisationsTemporairesHolder h = new GestionEntreeSortie.listeAutorisationsTemporairesHolder(read(a.create_input_stream()));
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
     * Return the listeAutorisationsTemporaires TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            _tc = orb.create_alias_tc(id(),"listeAutorisationsTemporaires",orb.create_sequence_tc(0,GestionEntreeSortie.AutorisationTemporaireHelper.type()));
        }
        return _tc;
    }

    /**
     * Return the listeAutorisationsTemporaires IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:GestionEntreeSortie/listeAutorisationsTemporaires:1.0";

    /**
     * Read listeAutorisationsTemporaires from a marshalled stream
     * @param istream the input stream
     * @return the readed listeAutorisationsTemporaires value
     */
    public static GestionEntreeSortie.AutorisationTemporaire[] read(org.omg.CORBA.portable.InputStream istream)
    {
        GestionEntreeSortie.AutorisationTemporaire[] new_one;
        {
        int size7 = istream.read_ulong();
        new_one = new GestionEntreeSortie.AutorisationTemporaire[size7];
        for (int i7=0; i7<new_one.length; i7++)
         {
            new_one[i7] = GestionEntreeSortie.AutorisationTemporaireHelper.read(istream);

         }
        }

        return new_one;
    }

    /**
     * Write listeAutorisationsTemporaires into a marshalled stream
     * @param ostream the output stream
     * @param value listeAutorisationsTemporaires value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, GestionEntreeSortie.AutorisationTemporaire[] value)
    {
        ostream.write_ulong(value.length);
        for (int i7=0; i7<value.length; i7++)
        {
            GestionEntreeSortie.AutorisationTemporaireHelper.write(ostream,value[i7]);

        }
    }

}
