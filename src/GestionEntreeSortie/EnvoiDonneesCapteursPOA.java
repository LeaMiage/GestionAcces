package GestionEntreeSortie;

/**
 * Interface definition : EnvoiDonneesCapteurs
 * 
 * @author OpenORB Compiler
 */
public abstract class EnvoiDonneesCapteursPOA extends org.omg.PortableServer.Servant
        implements EnvoiDonneesCapteursOperations, org.omg.CORBA.portable.InvokeHandler
{
    public EnvoiDonneesCapteurs _this()
    {
        return EnvoiDonneesCapteursHelper.narrow(_this_object());
    }

    public EnvoiDonneesCapteurs _this(org.omg.CORBA.ORB orb)
    {
        return EnvoiDonneesCapteursHelper.narrow(_this_object(orb));
    }

    private static String [] _ids_list =
    {
        "IDL:GestionEntreeSortie/EnvoiDonneesCapteurs:1.0"
    };

    public String[] _all_interfaces(org.omg.PortableServer.POA poa, byte [] objectId)
    {
        return _ids_list;
    }

    public final org.omg.CORBA.portable.OutputStream _invoke(final String opName,
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler)
    {

        if (opName.equals("accederZone")) {
                return _invoke_accederZone(_is, handler);
        } else if (opName.equals("sortirZone")) {
                return _invoke_sortirZone(_is, handler);
        } else {
            throw new org.omg.CORBA.BAD_OPERATION(opName);
        }
    }

    // helper methods
    private org.omg.CORBA.portable.OutputStream _invoke_accederZone(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = _is.read_string();
        String arg1_in = _is.read_string();
        String arg2_in = _is.read_string();

        try
        {
            String _arg_result = accederZone(arg0_in, arg1_in, arg2_in);

            _output = handler.createReply();
            _output.write_string(_arg_result);

        }
        catch (GestionEntreeSortie.ErreurEnvoi _exception)
        {
            _output = handler.createExceptionReply();
            GestionEntreeSortie.ErreurEnvoiHelper.write(_output,_exception);
        }
        catch (GestionEntreeSortie.ErreurAuthentification _exception)
        {
            _output = handler.createExceptionReply();
            GestionEntreeSortie.ErreurAuthentificationHelper.write(_output,_exception);
        }
        catch (GestionEntreeSortie.EmpreinteInconnue _exception)
        {
            _output = handler.createExceptionReply();
            GestionEntreeSortie.EmpreinteInconnueHelper.write(_output,_exception);
        }
        catch (GestionEntreeSortie.NonAutorise _exception)
        {
            _output = handler.createExceptionReply();
            GestionEntreeSortie.NonAutoriseHelper.write(_output,_exception);
        }
        catch (GestionEntreeSortie.ChampVide _exception)
        {
            _output = handler.createExceptionReply();
            GestionEntreeSortie.ChampVideHelper.write(_output,_exception);
        }
        catch (GestionEntreeSortie.CleInconnue _exception)
        {
            _output = handler.createExceptionReply();
            GestionEntreeSortie.CleInconnueHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_sortirZone(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = _is.read_string();
        String arg1_in = _is.read_string();
        String arg2_in = _is.read_string();

        try
        {
            String _arg_result = sortirZone(arg0_in, arg1_in, arg2_in);

            _output = handler.createReply();
            _output.write_string(_arg_result);

        }
        catch (GestionEntreeSortie.ErreurEnvoi _exception)
        {
            _output = handler.createExceptionReply();
            GestionEntreeSortie.ErreurEnvoiHelper.write(_output,_exception);
        }
        catch (GestionEntreeSortie.ErreurAuthentification _exception)
        {
            _output = handler.createExceptionReply();
            GestionEntreeSortie.ErreurAuthentificationHelper.write(_output,_exception);
        }
        catch (GestionEntreeSortie.EmpreinteInconnue _exception)
        {
            _output = handler.createExceptionReply();
            GestionEntreeSortie.EmpreinteInconnueHelper.write(_output,_exception);
        }
        catch (GestionEntreeSortie.NonAutorise _exception)
        {
            _output = handler.createExceptionReply();
            GestionEntreeSortie.NonAutoriseHelper.write(_output,_exception);
        }
        catch (GestionEntreeSortie.ChampVide _exception)
        {
            _output = handler.createExceptionReply();
            GestionEntreeSortie.ChampVideHelper.write(_output,_exception);
        }
        catch (GestionEntreeSortie.CleInconnue _exception)
        {
            _output = handler.createExceptionReply();
            GestionEntreeSortie.CleInconnueHelper.write(_output,_exception);
        }
        return _output;
    }

}
