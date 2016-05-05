package GestionEntreeSortie;

/**
 * Interface definition : GestionEmpreinte
 * 
 * @author OpenORB Compiler
 */
public class _GestionEmpreinteStub extends org.omg.CORBA.portable.ObjectImpl
        implements GestionEmpreinte
{
    static final String[] _ids_list =
    {
        "IDL:GestionEntreeSortie/GestionEmpreinte:1.0"
    };

    public String[] _ids()
    {
     return _ids_list;
    }

    private final static Class _opsClass = GestionEntreeSortie.GestionEmpreinteOperations.class;

    /**
     * Operation modifierEmpreinte
     */
    public void modifierEmpreinte(int idPersonne, String empreinte, String cleAPI)
        throws GestionEntreeSortie.PersonneInconnue, GestionEntreeSortie.CleInconnue
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("modifierEmpreinte",true);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("modifierEmpreinte",_opsClass);
                if (_so == null)
                   continue;
                GestionEntreeSortie.GestionEmpreinteOperations _self = (GestionEntreeSortie.GestionEmpreinteOperations) _so.servant;
                try
                {
                    _self.modifierEmpreinte( idPersonne,  empreinte,  cleAPI);
                    return;
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation supprimerEmpreinte
     */
    public void supprimerEmpreinte(int idPersonne, String cleAPI)
        throws GestionEntreeSortie.PersonneInconnue, GestionEntreeSortie.CleInconnue
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("supprimerEmpreinte",true);
                    _output.write_long(idPersonne);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("supprimerEmpreinte",_opsClass);
                if (_so == null)
                   continue;
                GestionEntreeSortie.GestionEmpreinteOperations _self = (GestionEntreeSortie.GestionEmpreinteOperations) _so.servant;
                try
                {
                    _self.supprimerEmpreinte( idPersonne,  cleAPI);
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
