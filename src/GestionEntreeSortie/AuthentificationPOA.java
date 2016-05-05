package GestionEntreeSortie;

/**
 * Interface definition : Authentification
 * 
 * @author OpenORB Compiler
 */
public abstract class AuthentificationPOA extends org.omg.PortableServer.Servant
        implements AuthentificationOperations, org.omg.CORBA.portable.InvokeHandler
{
    public Authentification _this()
    {
        return AuthentificationHelper.narrow(_this_object());
    }

    public Authentification _this(org.omg.CORBA.ORB orb)
    {
        return AuthentificationHelper.narrow(_this_object(orb));
    }

    private static String [] _ids_list =
    {
        "IDL:GestionEntreeSortie/Authentification:1.0"
    };

    public String[] _all_interfaces(org.omg.PortableServer.POA poa, byte [] objectId)
    {
        return _ids_list;
    }

    public final org.omg.CORBA.portable.OutputStream _invoke(final String opName,
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler)
    {

        if (opName.equals("authentifierCompte")) {
                return _invoke_authentifierCompte(_is, handler);
        } else if (opName.equals("authentifierPersonne")) {
                return _invoke_authentifierPersonne(_is, handler);
        } else {
            throw new org.omg.CORBA.BAD_OPERATION(opName);
        }
    }

    // helper methods
    private org.omg.CORBA.portable.OutputStream _invoke_authentifierCompte(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        int arg0_in = _is.read_long();
        String arg1_in = _is.read_string();
        String arg2_in = _is.read_string();

        try
        {
            authentifierCompte(arg0_in, arg1_in, arg2_in);

            _output = handler.createReply();

        }
        catch (GestionEntreeSortie.ErreurAuthentification _exception)
        {
            _output = handler.createExceptionReply();
            GestionEntreeSortie.ErreurAuthentificationHelper.write(_output,_exception);
        }
        catch (GestionEntreeSortie.CleInconnue _exception)
        {
            _output = handler.createExceptionReply();
            GestionEntreeSortie.CleInconnueHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_authentifierPersonne(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = _is.read_string();
        String arg1_in = _is.read_string();

        try
        {
            GestionEntreeSortie.IdentiteCollaborateur _arg_result = authentifierPersonne(arg0_in, arg1_in);

            _output = handler.createReply();
            GestionEntreeSortie.IdentiteCollaborateurHelper.write(_output,_arg_result);

        }
        catch (GestionEntreeSortie.ErreurAuthentification _exception)
        {
            _output = handler.createExceptionReply();
            GestionEntreeSortie.ErreurAuthentificationHelper.write(_output,_exception);
        }
        catch (GestionEntreeSortie.CleInconnue _exception)
        {
            _output = handler.createExceptionReply();
            GestionEntreeSortie.CleInconnueHelper.write(_output,_exception);
        }
        return _output;
    }

}
