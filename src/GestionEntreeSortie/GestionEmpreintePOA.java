package GestionEntreeSortie;

/**
 * Interface definition : GestionEmpreinte
 * 
 * @author OpenORB Compiler
 */
public abstract class GestionEmpreintePOA extends org.omg.PortableServer.Servant
        implements GestionEmpreinteOperations, org.omg.CORBA.portable.InvokeHandler
{
    public GestionEmpreinte _this()
    {
        return GestionEmpreinteHelper.narrow(_this_object());
    }

    public GestionEmpreinte _this(org.omg.CORBA.ORB orb)
    {
        return GestionEmpreinteHelper.narrow(_this_object(orb));
    }

    private static String [] _ids_list =
    {
        "IDL:GestionEntreeSortie/GestionEmpreinte:1.0"
    };

    public String[] _all_interfaces(org.omg.PortableServer.POA poa, byte [] objectId)
    {
        return _ids_list;
    }

    public final org.omg.CORBA.portable.OutputStream _invoke(final String opName,
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler)
    {

        if (opName.equals("modifierEmpreinte")) {
                return _invoke_modifierEmpreinte(_is, handler);
        } else if (opName.equals("supprimerEmpreinte")) {
                return _invoke_supprimerEmpreinte(_is, handler);
        } else {
            throw new org.omg.CORBA.BAD_OPERATION(opName);
        }
    }

    // helper methods
    private org.omg.CORBA.portable.OutputStream _invoke_modifierEmpreinte(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        int arg0_in = _is.read_long();
        String arg1_in = _is.read_string();
        String arg2_in = _is.read_string();

        try
        {
            modifierEmpreinte(arg0_in, arg1_in, arg2_in);

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
        catch (GestionEntreeSortie.ChampVide _exception)
        {
            _output = handler.createExceptionReply();
            GestionEntreeSortie.ChampVideHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_supprimerEmpreinte(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        int arg0_in = _is.read_long();
        String arg1_in = _is.read_string();

        try
        {
            supprimerEmpreinte(arg0_in, arg1_in);

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
