package GestionEntreeSortie;

/**
 * Interface definition : CreationCompte
 * 
 * @author OpenORB Compiler
 */
public class _CreationCompteStub extends org.omg.CORBA.portable.ObjectImpl
        implements CreationCompte
{
    static final String[] _ids_list =
    {
        "IDL:GestionEntreeSortie/CreationCompte:1.0"
    };

    public String[] _ids()
    {
     return _ids_list;
    }

    private final static Class _opsClass = GestionEntreeSortie.CreationCompteOperations.class;

    /**
     * Operation creerCP
     */
    public int creerCP(String nomP, String prenomP, String mdp, String photoP, String cleAPI)
        throws GestionEntreeSortie.CleInconnue, GestionEntreeSortie.PersonneExistante, GestionEntreeSortie.ChampVide
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("creerCP",true);
                    _output.write_string(nomP);
                    _output.write_string(prenomP);
                    _output.write_string(mdp);
                    _output.write_string(photoP);
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
                    if (_exception_id.equals(GestionEntreeSortie.CleInconnueHelper.id()))
                    {
                        throw GestionEntreeSortie.CleInconnueHelper.read(_exception.getInputStream());
                    }

                    if (_exception_id.equals(GestionEntreeSortie.PersonneExistanteHelper.id()))
                    {
                        throw GestionEntreeSortie.PersonneExistanteHelper.read(_exception.getInputStream());
                    }

                    if (_exception_id.equals(GestionEntreeSortie.ChampVideHelper.id()))
                    {
                        throw GestionEntreeSortie.ChampVideHelper.read(_exception.getInputStream());
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("creerCP",_opsClass);
                if (_so == null)
                   continue;
                GestionEntreeSortie.CreationCompteOperations _self = (GestionEntreeSortie.CreationCompteOperations) _so.servant;
                try
                {
                    return _self.creerCP( nomP,  prenomP,  mdp,  photoP,  cleAPI);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation creerCT
     */
    public int creerCT(String nomP, String prenomP, String mdp, String photoP, String cleAPI)
        throws GestionEntreeSortie.CleInconnue, GestionEntreeSortie.PersonneExistante, GestionEntreeSortie.ChampVide
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("creerCT",true);
                    _output.write_string(nomP);
                    _output.write_string(prenomP);
                    _output.write_string(mdp);
                    _output.write_string(photoP);
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
                    if (_exception_id.equals(GestionEntreeSortie.CleInconnueHelper.id()))
                    {
                        throw GestionEntreeSortie.CleInconnueHelper.read(_exception.getInputStream());
                    }

                    if (_exception_id.equals(GestionEntreeSortie.PersonneExistanteHelper.id()))
                    {
                        throw GestionEntreeSortie.PersonneExistanteHelper.read(_exception.getInputStream());
                    }

                    if (_exception_id.equals(GestionEntreeSortie.ChampVideHelper.id()))
                    {
                        throw GestionEntreeSortie.ChampVideHelper.read(_exception.getInputStream());
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("creerCT",_opsClass);
                if (_so == null)
                   continue;
                GestionEntreeSortie.CreationCompteOperations _self = (GestionEntreeSortie.CreationCompteOperations) _so.servant;
                try
                {
                    return _self.creerCT( nomP,  prenomP,  mdp,  photoP,  cleAPI);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

}
