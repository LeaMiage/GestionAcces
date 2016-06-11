package GestionEntreeSortie;

/**
 * Interface definition : GestionSalaries
 * 
 * @author OpenORB Compiler
 */
public class _GestionSalariesStub extends org.omg.CORBA.portable.ObjectImpl
        implements GestionSalaries
{
    static final String[] _ids_list =
    {
        "IDL:GestionEntreeSortie/GestionSalaries:1.0"
    };

    public String[] _ids()
    {
     return _ids_list;
    }

    private final static Class _opsClass = GestionEntreeSortie.GestionSalariesOperations.class;

    /**
     * Operation rechercherSalarie
     */
    public GestionEntreeSortie.IdentiteCollaborateur rechercherSalarie(int idPersonne, String cleAPI)
        throws GestionEntreeSortie.PersonneInconnue, GestionEntreeSortie.CleInconnue
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("rechercherSalarie",true);
                    _output.write_long(idPersonne);
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
                    if (_exception_id.equals(GestionEntreeSortie.PersonneInconnueHelper.id()))
                    {
                        throw GestionEntreeSortie.PersonneInconnueHelper.read(_exception.getInputStream());
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("rechercherSalarie",_opsClass);
                if (_so == null)
                   continue;
                GestionEntreeSortie.GestionSalariesOperations _self = (GestionEntreeSortie.GestionSalariesOperations) _so.servant;
                try
                {
                    return _self.rechercherSalarie( idPersonne,  cleAPI);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation verifierPersonne
     */
    public int verifierPersonne(int idPersonne, String cleAPI)
        throws GestionEntreeSortie.PersonneInconnue, GestionEntreeSortie.CleInconnue
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("verifierPersonne",true);
                    _output.write_long(idPersonne);
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
                    if (_exception_id.equals(GestionEntreeSortie.PersonneInconnueHelper.id()))
                    {
                        throw GestionEntreeSortie.PersonneInconnueHelper.read(_exception.getInputStream());
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("verifierPersonne",_opsClass);
                if (_so == null)
                   continue;
                GestionEntreeSortie.GestionSalariesOperations _self = (GestionEntreeSortie.GestionSalariesOperations) _so.servant;
                try
                {
                    return _self.verifierPersonne( idPersonne,  cleAPI);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

}
