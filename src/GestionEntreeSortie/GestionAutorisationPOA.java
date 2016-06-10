package GestionEntreeSortie;

/**
 * Interface definition : GestionAutorisation
 * 
 * @author OpenORB Compiler
 */
public abstract class GestionAutorisationPOA extends org.omg.PortableServer.Servant
        implements GestionAutorisationOperations, org.omg.CORBA.portable.InvokeHandler
{
    public GestionAutorisation _this()
    {
        return GestionAutorisationHelper.narrow(_this_object());
    }

    public GestionAutorisation _this(org.omg.CORBA.ORB orb)
    {
        return GestionAutorisationHelper.narrow(_this_object(orb));
    }

    private static String [] _ids_list =
    {
        "IDL:GestionEntreeSortie/GestionAutorisation:1.0"
    };

    public String[] _all_interfaces(org.omg.PortableServer.POA poa, byte [] objectId)
    {
        return _ids_list;
    }

    public final org.omg.CORBA.portable.OutputStream _invoke(final String opName,
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler)
    {

        if (opName.equals("ajouterAutorisationPermanente")) {
                return _invoke_ajouterAutorisationPermanente(_is, handler);
        } else if (opName.equals("ajouterAutorisationTemporaire")) {
                return _invoke_ajouterAutorisationTemporaire(_is, handler);
        } else if (opName.equals("modifierAutorisationPermanente")) {
                return _invoke_modifierAutorisationPermanente(_is, handler);
        } else if (opName.equals("modifierAutorisationTemporaire")) {
                return _invoke_modifierAutorisationTemporaire(_is, handler);
        } else if (opName.equals("supprimerAutorisationPermanente")) {
                return _invoke_supprimerAutorisationPermanente(_is, handler);
        } else if (opName.equals("supprimerAutorisationTemporaire")) {
                return _invoke_supprimerAutorisationTemporaire(_is, handler);
        } else {
            throw new org.omg.CORBA.BAD_OPERATION(opName);
        }
    }

    // helper methods
    private org.omg.CORBA.portable.OutputStream _invoke_ajouterAutorisationPermanente(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        GestionEntreeSortie.AutorisationPermanente arg0_in = GestionEntreeSortie.AutorisationPermanenteHelper.read(_is);
        String arg1_in = _is.read_string();

        try
        {
            ajouterAutorisationPermanente(arg0_in, arg1_in);

            _output = handler.createReply();

        }
        catch (GestionEntreeSortie.AutorisationInconnue _exception)
        {
            _output = handler.createExceptionReply();
            GestionEntreeSortie.AutorisationInconnueHelper.write(_output,_exception);
        }
        catch (GestionEntreeSortie.CleInconnue _exception)
        {
            _output = handler.createExceptionReply();
            GestionEntreeSortie.CleInconnueHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_modifierAutorisationPermanente(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        GestionEntreeSortie.AutorisationPermanente arg0_in = GestionEntreeSortie.AutorisationPermanenteHelper.read(_is);
        GestionEntreeSortie.AutorisationPermanente arg1_in = GestionEntreeSortie.AutorisationPermanenteHelper.read(_is);
        String arg2_in = _is.read_string();

        try
        {
            modifierAutorisationPermanente(arg0_in, arg1_in, arg2_in);

            _output = handler.createReply();

        }
        catch (GestionEntreeSortie.AutorisationInconnue _exception)
        {
            _output = handler.createExceptionReply();
            GestionEntreeSortie.AutorisationInconnueHelper.write(_output,_exception);
        }
        catch (GestionEntreeSortie.CleInconnue _exception)
        {
            _output = handler.createExceptionReply();
            GestionEntreeSortie.CleInconnueHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_supprimerAutorisationPermanente(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        GestionEntreeSortie.AutorisationPermanente arg0_in = GestionEntreeSortie.AutorisationPermanenteHelper.read(_is);
        String arg1_in = _is.read_string();

        try
        {
            supprimerAutorisationPermanente(arg0_in, arg1_in);

            _output = handler.createReply();

        }
        catch (GestionEntreeSortie.AutorisationInconnue _exception)
        {
            _output = handler.createExceptionReply();
            GestionEntreeSortie.AutorisationInconnueHelper.write(_output,_exception);
        }
        catch (GestionEntreeSortie.CleInconnue _exception)
        {
            _output = handler.createExceptionReply();
            GestionEntreeSortie.CleInconnueHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_ajouterAutorisationTemporaire(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        GestionEntreeSortie.AutorisationTemporaire arg0_in = GestionEntreeSortie.AutorisationTemporaireHelper.read(_is);
        String arg1_in = _is.read_string();

        try
        {
            ajouterAutorisationTemporaire(arg0_in, arg1_in);

            _output = handler.createReply();

        }
        catch (GestionEntreeSortie.AutorisationInconnue _exception)
        {
            _output = handler.createExceptionReply();
            GestionEntreeSortie.AutorisationInconnueHelper.write(_output,_exception);
        }
        catch (GestionEntreeSortie.CleInconnue _exception)
        {
            _output = handler.createExceptionReply();
            GestionEntreeSortie.CleInconnueHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_modifierAutorisationTemporaire(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        GestionEntreeSortie.AutorisationTemporaire arg0_in = GestionEntreeSortie.AutorisationTemporaireHelper.read(_is);
        GestionEntreeSortie.AutorisationTemporaire arg1_in = GestionEntreeSortie.AutorisationTemporaireHelper.read(_is);
        String arg2_in = _is.read_string();

        try
        {
            modifierAutorisationTemporaire(arg0_in, arg1_in, arg2_in);

            _output = handler.createReply();

        }
        catch (GestionEntreeSortie.AutorisationInconnue _exception)
        {
            _output = handler.createExceptionReply();
            GestionEntreeSortie.AutorisationInconnueHelper.write(_output,_exception);
        }
        catch (GestionEntreeSortie.CleInconnue _exception)
        {
            _output = handler.createExceptionReply();
            GestionEntreeSortie.CleInconnueHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_supprimerAutorisationTemporaire(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        GestionEntreeSortie.AutorisationTemporaire arg0_in = GestionEntreeSortie.AutorisationTemporaireHelper.read(_is);
        String arg1_in = _is.read_string();

        try
        {
            supprimerAutorisationTemporaire(arg0_in, arg1_in);

            _output = handler.createReply();

        }
        catch (GestionEntreeSortie.AutorisationInconnue _exception)
        {
            _output = handler.createExceptionReply();
            GestionEntreeSortie.AutorisationInconnueHelper.write(_output,_exception);
        }
        catch (GestionEntreeSortie.CleInconnue _exception)
        {
            _output = handler.createExceptionReply();
            GestionEntreeSortie.CleInconnueHelper.write(_output,_exception);
        }
        return _output;
    }

}
