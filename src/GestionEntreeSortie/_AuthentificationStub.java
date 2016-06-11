package GestionEntreeSortie;

/**
 * Interface definition : Authentification
 * 
 * @author OpenORB Compiler
 */
public class _AuthentificationStub extends org.omg.CORBA.portable.ObjectImpl
        implements Authentification
{
    static final String[] _ids_list =
    {
        "IDL:GestionEntreeSortie/Authentification:1.0"
    };

    public String[] _ids()
    {
     return _ids_list;
    }

    private final static Class _opsClass = GestionEntreeSortie.AuthentificationOperations.class;

    /**
     * Operation authentifierCompte
     */
    public int authentifierCompte(int idPersonne, String mdp, String cleAPI)
        throws GestionEntreeSortie.ErreurAuthentification, GestionEntreeSortie.CleInconnue
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("authentifierCompte",true);
                    _output.write_long(idPersonne);
                    _output.write_string(mdp);
                    _output.write_string(cleAPI);
                    _input = this._invoke(_output);
                    int _arg_ret = _input.read_long();
                    return _arg_ret;
                }
                catch(org.omg.CORBA.portable.RemarshalException _exception)
                {
                    continue;
                }
                catch(org.omg.CORBA.portable.ApplicationException _exception)
                {
                    String _exception_id = _exception.getId();
                    if (_exception_id.equals(GestionEntreeSortie.ErreurAuthentificationHelper.id()))
                    {
                        throw GestionEntreeSortie.ErreurAuthentificationHelper.read(_exception.getInputStream());
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("authentifierCompte",_opsClass);
                if (_so == null)
                   continue;
                GestionEntreeSortie.AuthentificationOperations _self = (GestionEntreeSortie.AuthentificationOperations) _so.servant;
                try
                {
                    return _self.authentifierCompte( idPersonne,  mdp,  cleAPI);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation authentifierPersonne
     */
    public GestionEntreeSortie.IdentiteCollaborateur authentifierPersonne(String photoP, String cleAPI)
        throws GestionEntreeSortie.ErreurAuthentification, GestionEntreeSortie.CleInconnue
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("authentifierPersonne",true);
                    _output.write_string(photoP);
                    _output.write_string(cleAPI);
                    _input = this._invoke(_output);
                    GestionEntreeSortie.IdentiteCollaborateur _arg_ret = GestionEntreeSortie.IdentiteCollaborateurHelper.read(_input);
                    return _arg_ret;
                }
                catch(org.omg.CORBA.portable.RemarshalException _exception)
                {
                    continue;
                }
                catch(org.omg.CORBA.portable.ApplicationException _exception)
                {
                    String _exception_id = _exception.getId();
                    if (_exception_id.equals(GestionEntreeSortie.ErreurAuthentificationHelper.id()))
                    {
                        throw GestionEntreeSortie.ErreurAuthentificationHelper.read(_exception.getInputStream());
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("authentifierPersonne",_opsClass);
                if (_so == null)
                   continue;
                GestionEntreeSortie.AuthentificationOperations _self = (GestionEntreeSortie.AuthentificationOperations) _so.servant;
                try
                {
                    return _self.authentifierPersonne( photoP,  cleAPI);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

}
