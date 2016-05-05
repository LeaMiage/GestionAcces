package GestionEntreeSortie;

/**
 * Interface definition : VerificationEmpreinte
 * 
 * @author OpenORB Compiler
 */
public class _VerificationEmpreinteStub extends org.omg.CORBA.portable.ObjectImpl
        implements VerificationEmpreinte
{
    static final String[] _ids_list =
    {
        "IDL:GestionEntreeSortie/VerificationEmpreinte:1.0"
    };

    public String[] _ids()
    {
     return _ids_list;
    }

    private final static Class _opsClass = GestionEntreeSortie.VerificationEmpreinteOperations.class;

    /**
     * Operation verifierEmpreinte
     */
    public void verifierEmpreinte(int idPersonne, String empreinte, String cleAPI)
        throws GestionEntreeSortie.EmpreinteInconnue, GestionEntreeSortie.CleInconnue
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("verifierEmpreinte",true);
                    _output.write_long(idPersonne);
                    _output.write_string(empreinte);
                    _output.write_string(cleAPI);
                    _input = this._invoke(_output);
                    return;
                }
                catch(org.omg.CORBA.portable.RemarshalException _exception)
                {
                    continue;
                }
                catch(org.omg.CORBA.portable.ApplicationException _exception)
                {
                    String _exception_id = _exception.getId();
                    if (_exception_id.equals(GestionEntreeSortie.EmpreinteInconnueHelper.id()))
                    {
                        throw GestionEntreeSortie.EmpreinteInconnueHelper.read(_exception.getInputStream());
                    }

                    if (_exception_id.equals(GestionEntreeSortie.CleInconnueHelper.id()))
                    {
                        throw GestionEntreeSortie.CleInconnueHelper.read(_exception.getInputStream());
                    }

                    throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: "+ _exception_id);
                }
                finally
                {
                    this._releaseReply(_input);
                }
            }
            else
            {
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("verifierEmpreinte",_opsClass);
                if (_so == null)
                   continue;
                GestionEntreeSortie.VerificationEmpreinteOperations _self = (GestionEntreeSortie.VerificationEmpreinteOperations) _so.servant;
                try
                {
                    _self.verifierEmpreinte( idPersonne,  empreinte,  cleAPI);
                    return;
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

}
