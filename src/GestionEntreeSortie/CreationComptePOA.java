package GestionEntreeSortie;

/**
 * Interface definition : CreationCompte
 * 
 * @author OpenORB Compiler
 */
public abstract class CreationComptePOA extends org.omg.PortableServer.Servant
        implements CreationCompteOperations, org.omg.CORBA.portable.InvokeHandler
{
    public CreationCompte _this()
    {
        return CreationCompteHelper.narrow(_this_object());
    }

    public CreationCompte _this(org.omg.CORBA.ORB orb)
    {
        return CreationCompteHelper.narrow(_this_object(orb));
    }

    private static String [] _ids_list =
    {
        "IDL:GestionEntreeSortie/CreationCompte:1.0"
    };

    public String[] _all_interfaces(org.omg.PortableServer.POA poa, byte [] objectId)
    {
        return _ids_list;
    }

    public final org.omg.CORBA.portable.OutputStream _invoke(final String opName,
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler)
    {

        if (opName.equals("creerCP")) {
                return _invoke_creerCP(_is, handler);
        } else if (opName.equals("creerCT")) {
                return _invoke_creerCT(_is, handler);
        } else {
            throw new org.omg.CORBA.BAD_OPERATION(opName);
        }
    }

    // helper methods
    private org.omg.CORBA.portable.OutputStream _invoke_creerCP(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = _is.read_string();
        String arg1_in = _is.read_string();
        String arg2_in = _is.read_string();
        String arg3_in = _is.read_string();
        String arg4_in = _is.read_string();

        try
        {
            int _arg_result = creerCP(arg0_in, arg1_in, arg2_in, arg3_in, arg4_in);

            _output = handler.createReply();
            _output.write_long(_arg_result);

        }
        catch (GestionEntreeSortie.CleInconnue _exception)
        {
            _output = handler.createExceptionReply();
            GestionEntreeSortie.CleInconnueHelper.write(_output,_exception);
        }
        catch (GestionEntreeSortie.PersonneExistante _exception)
        {
            _output = handler.createExceptionReply();
            GestionEntreeSortie.PersonneExistanteHelper.write(_output,_exception);
        }
        catch (GestionEntreeSortie.ChampVide _exception)
        {
            _output = handler.createExceptionReply();
            GestionEntreeSortie.ChampVideHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_creerCT(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = _is.read_string();
        String arg1_in = _is.read_string();
        String arg2_in = _is.read_string();
        String arg3_in = _is.read_string();
        String arg4_in = _is.read_string();

        try
        {
            int _arg_result = creerCT(arg0_in, arg1_in, arg2_in, arg3_in, arg4_in);

            _output = handler.createReply();
            _output.write_long(_arg_result);

        }
        catch (GestionEntreeSortie.CleInconnue _exception)
        {
            _output = handler.createExceptionReply();
            GestionEntreeSortie.CleInconnueHelper.write(_output,_exception);
        }
        catch (GestionEntreeSortie.PersonneExistante _exception)
        {
            _output = handler.createExceptionReply();
            GestionEntreeSortie.PersonneExistanteHelper.write(_output,_exception);
        }
        catch (GestionEntreeSortie.ChampVide _exception)
        {
            _output = handler.createExceptionReply();
            GestionEntreeSortie.ChampVideHelper.write(_output,_exception);
        }
        return _output;
    }

}
