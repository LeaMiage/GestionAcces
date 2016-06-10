package GestionEntreeSortie;

/**
 * Interface definition : EnvoiDonneesCapteurs
 * 
 * @author OpenORB Compiler
 */
public class _EnvoiDonneesCapteursStub extends org.omg.CORBA.portable.ObjectImpl
        implements EnvoiDonneesCapteurs
{
    static final String[] _ids_list =
    {
        "IDL:GestionEntreeSortie/EnvoiDonneesCapteurs:1.0"
    };

    public String[] _ids()
    {
     return _ids_list;
    }

    private final static Class _opsClass = GestionEntreeSortie.EnvoiDonneesCapteursOperations.class;

    /**
     * Operation accederZone
     */
    public String accederZone(String empreinte, String photoP, String cleAPI)
        throws GestionEntreeSortie.ErreurEnvoi, GestionEntreeSortie.CleInconnue
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("accederZone",true);
                    _output.write_string(empreinte);
                    _output.write_string(photoP);
                    _output.write_string(cleAPI);
                    _input = this._invoke(_output);
                    String _arg_ret = _input.read_string();
                    return _arg_ret;
                }
                catch(org.omg.CORBA.portable.RemarshalException _exception)
                {
                    continue;
                }
                catch(org.omg.CORBA.portable.ApplicationException _exception)
                {
                    String _exception_id = _exception.getId();
                    if (_exception_id.equals(GestionEntreeSortie.ErreurEnvoiHelper.id()))
                    {
                        throw GestionEntreeSortie.ErreurEnvoiHelper.read(_exception.getInputStream());
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("accederZone",_opsClass);
                if (_so == null)
                   continue;
                GestionEntreeSortie.EnvoiDonneesCapteursOperations _self = (GestionEntreeSortie.EnvoiDonneesCapteursOperations) _so.servant;
                try
                {
                    return _self.accederZone( empreinte,  photoP,  cleAPI);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation sortirZone
     */
    public String sortirZone(String empreinte, String photoP, String cleAPI)
        throws GestionEntreeSortie.ErreurEnvoi, GestionEntreeSortie.CleInconnue
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("sortirZone",true);
                    _output.write_string(empreinte);
                    _output.write_string(photoP);
                    _output.write_string(cleAPI);
                    _input = this._invoke(_output);
                    String _arg_ret = _input.read_string();
                    return _arg_ret;
                }
                catch(org.omg.CORBA.portable.RemarshalException _exception)
                {
                    continue;
                }
                catch(org.omg.CORBA.portable.ApplicationException _exception)
                {
                    String _exception_id = _exception.getId();
                    if (_exception_id.equals(GestionEntreeSortie.ErreurEnvoiHelper.id()))
                    {
                        throw GestionEntreeSortie.ErreurEnvoiHelper.read(_exception.getInputStream());
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("sortirZone",_opsClass);
                if (_so == null)
                   continue;
                GestionEntreeSortie.EnvoiDonneesCapteursOperations _self = (GestionEntreeSortie.EnvoiDonneesCapteursOperations) _so.servant;
                try
                {
                    return _self.sortirZone( empreinte,  photoP,  cleAPI);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

}
