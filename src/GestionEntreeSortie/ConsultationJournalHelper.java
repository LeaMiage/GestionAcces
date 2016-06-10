package GestionEntreeSortie;

/** 
 * Helper class for : ConsultationJournal
 *  
 * @author OpenORB Compiler
 */ 
public class ConsultationJournalHelper
{
    /**
     * Insert ConsultationJournal into an any
     * @param a an any
     * @param t ConsultationJournal value
     */
    public static void insert(org.omg.CORBA.Any a, GestionEntreeSortie.ConsultationJournal t)
    {
        a.insert_Object(t , type());
    }

    /**
     * Extract ConsultationJournal from an any
     * @param a an any
     * @return the extracted ConsultationJournal value
     */
    public static GestionEntreeSortie.ConsultationJournal extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        try {
            return GestionEntreeSortie.ConsultationJournalHelper.narrow(a.extract_Object());
        } catch (final org.omg.CORBA.BAD_PARAM e) {
            throw new org.omg.CORBA.MARSHAL(e.getMessage());
        }
    }

    //
    // Internal TypeCode value
    //
    private static org.omg.CORBA.TypeCode _tc = null;

    /**
     * Return the ConsultationJournal TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            _tc = orb.create_interface_tc(id(),"ConsultationJournal");
        }
        return _tc;
    }

    /**
     * Return the ConsultationJournal IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:GestionEntreeSortie/ConsultationJournal:1.0";

    /**
     * Read ConsultationJournal from a marshalled stream
     * @param istream the input stream
     * @return the readed ConsultationJournal value
     */
    public static GestionEntreeSortie.ConsultationJournal read(org.omg.CORBA.portable.InputStream istream)
    {
        return(GestionEntreeSortie.ConsultationJournal)istream.read_Object(GestionEntreeSortie._ConsultationJournalStub.class);
    }

    /**
     * Write ConsultationJournal into a marshalled stream
     * @param ostream the output stream
     * @param value ConsultationJournal value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, GestionEntreeSortie.ConsultationJournal value)
    {
        ostream.write_Object((org.omg.CORBA.portable.ObjectImpl)value);
    }

    /**
     * Narrow CORBA::Object to ConsultationJournal
     * @param obj the CORBA Object
     * @return ConsultationJournal Object
     */
    public static ConsultationJournal narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof ConsultationJournal)
            return (ConsultationJournal)obj;

        if (obj._is_a(id()))
        {
            _ConsultationJournalStub stub = new _ConsultationJournalStub();
            stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
            return stub;
        }

        throw new org.omg.CORBA.BAD_PARAM();
    }

    /**
     * Unchecked Narrow CORBA::Object to ConsultationJournal
     * @param obj the CORBA Object
     * @return ConsultationJournal Object
     */
    public static ConsultationJournal unchecked_narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof ConsultationJournal)
            return (ConsultationJournal)obj;

        _ConsultationJournalStub stub = new _ConsultationJournalStub();
        stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
        return stub;

    }

}
