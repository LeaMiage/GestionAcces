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

    private static final java.util.Map operationMap = new java.util.HashMap();

    static {
            operationMap.put("ajouterAutorisationPermanente",
                    new Operation_ajouterAutorisationPermanente());
            operationMap.put("ajouterAutorisationTemporaire",
                    new Operation_ajouterAutorisationTemporaire());
            operationMap.put("listeAutorisationsPerm",
                    new Operation_listeAutorisationsPerm());
            operationMap.put("listeAutorisationsPermPersonne",
                    new Operation_listeAutorisationsPermPersonne());
            operationMap.put("listeAutorisationsTemp",
                    new Operation_listeAutorisationsTemp());
            operationMap.put("listeAutorisationsTempPersonne",
                    new Operation_listeAutorisationsTempPersonne());
            operationMap.put("modifierAutorisationPermanente",
                    new Operation_modifierAutorisationPermanente());
            operationMap.put("modifierAutorisationTemporaire",
                    new Operation_modifierAutorisationTemporaire());
            operationMap.put("supprimerAutorisationPermanente",
                    new Operation_supprimerAutorisationPermanente());
            operationMap.put("supprimerAutorisationTemporaire",
                    new Operation_supprimerAutorisationTemporaire());
    }

    public final org.omg.CORBA.portable.OutputStream _invoke(final String opName,
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler)
    {

        final AbstractOperation operation = (AbstractOperation)operationMap.get(opName);

        if (null == operation) {
            throw new org.omg.CORBA.BAD_OPERATION(opName);
        }

        return operation.invoke(this, _is, handler);
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
        catch (GestionEntreeSortie.AutorisationExistante _exception)
        {
            _output = handler.createExceptionReply();
            GestionEntreeSortie.AutorisationExistanteHelper.write(_output,_exception);
        }
        catch (GestionEntreeSortie.PersonneInconnue _exception)
        {
            _output = handler.createExceptionReply();
            GestionEntreeSortie.PersonneInconnueHelper.write(_output,_exception);
        }
        catch (GestionEntreeSortie.AjoutAPImpossible _exception)
        {
            _output = handler.createExceptionReply();
            GestionEntreeSortie.AjoutAPImpossibleHelper.write(_output,_exception);
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
        catch (GestionEntreeSortie.AutorisationExistante _exception)
        {
            _output = handler.createExceptionReply();
            GestionEntreeSortie.AutorisationExistanteHelper.write(_output,_exception);
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

    private org.omg.CORBA.portable.OutputStream _invoke_listeAutorisationsPerm(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        int arg0_in = _is.read_long();
        String arg1_in = _is.read_string();

        try
        {
            GestionEntreeSortie.AutorisationPermanente[] _arg_result = listeAutorisationsPerm(arg0_in, arg1_in);

            _output = handler.createReply();
            GestionEntreeSortie.listeAutorisationsPermanentesHelper.write(_output,_arg_result);

        }
        catch (GestionEntreeSortie.ZoneInconnue _exception)
        {
            _output = handler.createExceptionReply();
            GestionEntreeSortie.ZoneInconnueHelper.write(_output,_exception);
        }
        catch (GestionEntreeSortie.CleInconnue _exception)
        {
            _output = handler.createExceptionReply();
            GestionEntreeSortie.CleInconnueHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_listeAutorisationsTemp(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        int arg0_in = _is.read_long();
        String arg1_in = _is.read_string();

        try
        {
            GestionEntreeSortie.AutorisationTemporaire[] _arg_result = listeAutorisationsTemp(arg0_in, arg1_in);

            _output = handler.createReply();
            GestionEntreeSortie.listeAutorisationsTemporairesHelper.write(_output,_arg_result);

        }
        catch (GestionEntreeSortie.ZoneInconnue _exception)
        {
            _output = handler.createExceptionReply();
            GestionEntreeSortie.ZoneInconnueHelper.write(_output,_exception);
        }
        catch (GestionEntreeSortie.CleInconnue _exception)
        {
            _output = handler.createExceptionReply();
            GestionEntreeSortie.CleInconnueHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_listeAutorisationsPermPersonne(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        int arg0_in = _is.read_long();
        String arg1_in = _is.read_string();

        try
        {
            GestionEntreeSortie.AutorisationPermanente[] _arg_result = listeAutorisationsPermPersonne(arg0_in, arg1_in);

            _output = handler.createReply();
            GestionEntreeSortie.listeAutorisationsPermanentesHelper.write(_output,_arg_result);

        }
        catch (GestionEntreeSortie.CleInconnue _exception)
        {
            _output = handler.createExceptionReply();
            GestionEntreeSortie.CleInconnueHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_listeAutorisationsTempPersonne(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        int arg0_in = _is.read_long();
        String arg1_in = _is.read_string();

        try
        {
            GestionEntreeSortie.AutorisationTemporaire[] _arg_result = listeAutorisationsTempPersonne(arg0_in, arg1_in);

            _output = handler.createReply();
            GestionEntreeSortie.listeAutorisationsTemporairesHelper.write(_output,_arg_result);

        }
        catch (GestionEntreeSortie.CleInconnue _exception)
        {
            _output = handler.createExceptionReply();
            GestionEntreeSortie.CleInconnueHelper.write(_output,_exception);
        }
        return _output;
    }

    // operation classes
    private abstract static class AbstractOperation {
        protected abstract org.omg.CORBA.portable.OutputStream invoke(
                GestionAutorisationPOA target,
                org.omg.CORBA.portable.InputStream _is,
                org.omg.CORBA.portable.ResponseHandler handler);
    }

    private static final class Operation_ajouterAutorisationPermanente extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final GestionAutorisationPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_ajouterAutorisationPermanente(_is, handler);
        }
    }

    private static final class Operation_modifierAutorisationPermanente extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final GestionAutorisationPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_modifierAutorisationPermanente(_is, handler);
        }
    }

    private static final class Operation_supprimerAutorisationPermanente extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final GestionAutorisationPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_supprimerAutorisationPermanente(_is, handler);
        }
    }

    private static final class Operation_ajouterAutorisationTemporaire extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final GestionAutorisationPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_ajouterAutorisationTemporaire(_is, handler);
        }
    }

    private static final class Operation_modifierAutorisationTemporaire extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final GestionAutorisationPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_modifierAutorisationTemporaire(_is, handler);
        }
    }

    private static final class Operation_supprimerAutorisationTemporaire extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final GestionAutorisationPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_supprimerAutorisationTemporaire(_is, handler);
        }
    }

    private static final class Operation_listeAutorisationsPerm extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final GestionAutorisationPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_listeAutorisationsPerm(_is, handler);
        }
    }

    private static final class Operation_listeAutorisationsTemp extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final GestionAutorisationPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_listeAutorisationsTemp(_is, handler);
        }
    }

    private static final class Operation_listeAutorisationsPermPersonne extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final GestionAutorisationPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_listeAutorisationsPermPersonne(_is, handler);
        }
    }

    private static final class Operation_listeAutorisationsTempPersonne extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final GestionAutorisationPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_listeAutorisationsTempPersonne(_is, handler);
        }
    }

}
