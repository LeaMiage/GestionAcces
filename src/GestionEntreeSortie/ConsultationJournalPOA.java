package GestionEntreeSortie;

/**
 * Interface definition : ConsultationJournal
 * 
 * @author OpenORB Compiler
 */
public abstract class ConsultationJournalPOA extends org.omg.PortableServer.Servant
        implements ConsultationJournalOperations, org.omg.CORBA.portable.InvokeHandler
{
    public ConsultationJournal _this()
    {
        return ConsultationJournalHelper.narrow(_this_object());
    }

    public ConsultationJournal _this(org.omg.CORBA.ORB orb)
    {
        return ConsultationJournalHelper.narrow(_this_object(orb));
    }

    private static String [] _ids_list =
    {
        "IDL:GestionEntreeSortie/ConsultationJournal:1.0"
    };

    public String[] _all_interfaces(org.omg.PortableServer.POA poa, byte [] objectId)
    {
        return _ids_list;
    }

    public final org.omg.CORBA.portable.OutputStream _invoke(final String opName,
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler)
    {

        if (opName.equals("consulterJournal")) {
                return _invoke_consulterJournal(_is, handler);
        } else {
            throw new org.omg.CORBA.BAD_OPERATION(opName);
        }
    }

    // helper methods
    private org.omg.CORBA.portable.OutputStream _invoke_consulterJournal(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = _is.read_string();

        try
        {
            GestionEntreeSortie.EntreeJournal[] _arg_result = consulterJournal(arg0_in);

            _output = handler.createReply();
            GestionEntreeSortie.listeEntreesJournalHelper.write(_output,_arg_result);

        }
        catch (GestionEntreeSortie.CleInconnue _exception)
        {
            _output = handler.createExceptionReply();
            GestionEntreeSortie.CleInconnueHelper.write(_output,_exception);
        }
        return _output;
    }

}
