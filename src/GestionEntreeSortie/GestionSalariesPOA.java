package GestionEntreeSortie;

/**
 * Interface definition : GestionSalaries
 * 
 * @author OpenORB Compiler
 */
public abstract class GestionSalariesPOA extends org.omg.PortableServer.Servant
        implements GestionSalariesOperations, org.omg.CORBA.portable.InvokeHandler
{
    public GestionSalaries _this()
    {
        return GestionSalariesHelper.narrow(_this_object());
    }

    public GestionSalaries _this(org.omg.CORBA.ORB orb)
    {
        return GestionSalariesHelper.narrow(_this_object(orb));
    }

    private static String [] _ids_list =
    {
        "IDL:GestionEntreeSortie/GestionSalaries:1.0"
    };

    public String[] _all_interfaces(org.omg.PortableServer.POA poa, byte [] objectId)
    {
        return _ids_list;
    }

    public final org.omg.CORBA.portable.OutputStream _invoke(final String opName,
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler)
    {

        if (opName.equals("rechercherSalarie")) {
                return _invoke_rechercherSalarie(_is, handler);
        } else if (opName.equals("verifierPersonne")) {
                return _invoke_verifierPersonne(_is, handler);
        } else {
            throw new org.omg.CORBA.BAD_OPERATION(opName);
        }
    }

    // helper methods
    private org.omg.CORBA.portable.OutputStream _invoke_rechercherSalarie(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        int arg0_in = _is.read_long();
        String arg1_in = _is.read_string();

        try
        {
            GestionEntreeSortie.IdentiteCollaborateur _arg_result = rechercherSalarie(arg0_in, arg1_in);

            _output = handler.createReply();
            GestionEntreeSortie.IdentiteCollaborateurHelper.write(_output,_arg_result);

        }
        catch (GestionEntreeSortie.PersonneInconnue _exception)
        {
            _output = handler.createExceptionReply();
            GestionEntreeSortie.PersonneInconnueHelper.write(_output,_exception);
        }
        catch (GestionEntreeSortie.CleInconnue _exception)
        {
            _output = handler.createExceptionReply();
            GestionEntreeSortie.CleInconnueHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_verifierPersonne(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        int arg0_in = _is.read_long();
        String arg1_in = _is.read_string();

        try
        {
            verifierPersonne(arg0_in, arg1_in);

            _output = handler.createReply();

        }
        catch (GestionEntreeSortie.PersonneInconnue _exception)
        {
            _output = handler.createExceptionReply();
            GestionEntreeSortie.PersonneInconnueHelper.write(_output,_exception);
        }
        catch (GestionEntreeSortie.CleInconnue _exception)
        {
            _output = handler.createExceptionReply();
            GestionEntreeSortie.CleInconnueHelper.write(_output,_exception);
        }
        return _output;
    }

}
