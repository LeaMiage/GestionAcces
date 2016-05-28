package GestionEntreeSortie;

/**
 * Interface definition : VerificationEmpreinte
 * 
 * @author OpenORB Compiler
 */
public abstract class VerificationEmpreintePOA extends org.omg.PortableServer.Servant
        implements VerificationEmpreinteOperations, org.omg.CORBA.portable.InvokeHandler
{
    public VerificationEmpreinte _this()
    {
        return VerificationEmpreinteHelper.narrow(_this_object());
    }

    public VerificationEmpreinte _this(org.omg.CORBA.ORB orb)
    {
        return VerificationEmpreinteHelper.narrow(_this_object(orb));
    }

    private static String [] _ids_list =
    {
        "IDL:GestionEntreeSortie/VerificationEmpreinte:1.0"
    };

    public String[] _all_interfaces(org.omg.PortableServer.POA poa, byte [] objectId)
    {
        return _ids_list;
    }

    public final org.omg.CORBA.portable.OutputStream _invoke(final String opName,
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler)
    {

        if (opName.equals("verifierEmpreinte")) {
                return _invoke_verifierEmpreinte(_is, handler);
        } else {
            throw new org.omg.CORBA.BAD_OPERATION(opName);
        }
    }

    // helper methods
    private org.omg.CORBA.portable.OutputStream _invoke_verifierEmpreinte(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        int arg0_in = _is.read_long();
        String arg1_in = _is.read_string();
        String arg2_in = _is.read_string();

        try
        {
            verifierEmpreinte(arg0_in, arg1_in, arg2_in);

            _output = handler.createReply();

        }
        catch (GestionEntreeSortie.EmpreinteInconnue _exception)
        {
            _output = handler.createExceptionReply();
            GestionEntreeSortie.EmpreinteInconnueHelper.write(_output,_exception);
        }
        catch (GestionEntreeSortie.CleInconnue _exception)
        {
            _output = handler.createExceptionReply();
            GestionEntreeSortie.CleInconnueHelper.write(_output,_exception);
        }
        catch (GestionEntreeSortie.ChampVide _exception)
        {
            _output = handler.createExceptionReply();
            GestionEntreeSortie.ChampVideHelper.write(_output,_exception);
        }
        return _output;
    }

}
