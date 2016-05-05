package GestionEntreeSortie;

/**
 * Interface definition : GestionAutorisation
 * 
 * @author OpenORB Compiler
 */
public class _GestionAutorisationStub extends org.omg.CORBA.portable.ObjectImpl
        implements GestionAutorisation
{
    static final String[] _ids_list =
    {
        "IDL:GestionEntreeSortie/GestionAutorisation:1.0"
    };

    public String[] _ids()
    {
     return _ids_list;
    }

    private final static Class _opsClass = GestionEntreeSortie.GestionAutorisationOperations.class;

    /**
     * Operation ajouterAutorisationPermanente
     */
    public void ajouterAutorisationPermanente(GestionEntreeSortie.AutorisationPermanente ap, String cleAPI)
        throws GestionEntreeSortie.AutorisationInconnue, GestionEntreeSortie.CleInconnue
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("ajouterAutorisationPermanente",true);
                    GestionEntreeSortie.AutorisationPermanenteHelper.write(_output,ap);
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
                    if (_exception_id.equals(GestionEntreeSortie.AutorisationInconnueHelper.id()))
                    {
                        throw GestionEntreeSortie.AutorisationInconnueHelper.read(_exception.getInputStream());
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("ajouterAutorisationPermanente",_opsClass);
                if (_so == null)
                   continue;
                GestionEntreeSortie.GestionAutorisationOperations _self = (GestionEntreeSortie.GestionAutorisationOperations) _so.servant;
                try
                {
                    _self.ajouterAutorisationPermanente( ap,  cleAPI);
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
     * Operation modifierAutorisationPermanente
     */
    public void modifierAutorisationPermanente(GestionEntreeSortie.AutorisationPermanente ap, GestionEntreeSortie.AutorisationPermanente np, String cleAPI)
        throws GestionEntreeSortie.AutorisationInconnue, GestionEntreeSortie.CleInconnue
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("modifierAutorisationPermanente",true);
                    GestionEntreeSortie.AutorisationPermanenteHelper.write(_output,ap);
                    GestionEntreeSortie.AutorisationPermanenteHelper.write(_output,np);
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
                    if (_exception_id.equals(GestionEntreeSortie.AutorisationInconnueHelper.id()))
                    {
                        throw GestionEntreeSortie.AutorisationInconnueHelper.read(_exception.getInputStream());
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("modifierAutorisationPermanente",_opsClass);
                if (_so == null)
                   continue;
                GestionEntreeSortie.GestionAutorisationOperations _self = (GestionEntreeSortie.GestionAutorisationOperations) _so.servant;
                try
                {
                    _self.modifierAutorisationPermanente( ap,  np,  cleAPI);
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
     * Operation supprimerAutorisationPermanente
     */
    public void supprimerAutorisationPermanente(GestionEntreeSortie.AutorisationPermanente ap, String cleAPI)
        throws GestionEntreeSortie.AutorisationInconnue, GestionEntreeSortie.CleInconnue
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("supprimerAutorisationPermanente",true);
                    GestionEntreeSortie.AutorisationPermanenteHelper.write(_output,ap);
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
                    if (_exception_id.equals(GestionEntreeSortie.AutorisationInconnueHelper.id()))
                    {
                        throw GestionEntreeSortie.AutorisationInconnueHelper.read(_exception.getInputStream());
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("supprimerAutorisationPermanente",_opsClass);
                if (_so == null)
                   continue;
                GestionEntreeSortie.GestionAutorisationOperations _self = (GestionEntreeSortie.GestionAutorisationOperations) _so.servant;
                try
                {
                    _self.supprimerAutorisationPermanente( ap,  cleAPI);
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
     * Operation ajouterAutorisationTemporaire
     */
    public void ajouterAutorisationTemporaire(GestionEntreeSortie.AutorisationTemporaire at, String cleAPI)
        throws GestionEntreeSortie.AutorisationInconnue, GestionEntreeSortie.CleInconnue
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("ajouterAutorisationTemporaire",true);
                    GestionEntreeSortie.AutorisationTemporaireHelper.write(_output,at);
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
                    if (_exception_id.equals(GestionEntreeSortie.AutorisationInconnueHelper.id()))
                    {
                        throw GestionEntreeSortie.AutorisationInconnueHelper.read(_exception.getInputStream());
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("ajouterAutorisationTemporaire",_opsClass);
                if (_so == null)
                   continue;
                GestionEntreeSortie.GestionAutorisationOperations _self = (GestionEntreeSortie.GestionAutorisationOperations) _so.servant;
                try
                {
                    _self.ajouterAutorisationTemporaire( at,  cleAPI);
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
     * Operation modifierAutorisationTemporaire
     */
    public void modifierAutorisationTemporaire(GestionEntreeSortie.AutorisationTemporaire at, GestionEntreeSortie.AutorisationTemporaire nt, String cleAPI)
        throws GestionEntreeSortie.AutorisationInconnue, GestionEntreeSortie.CleInconnue
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("modifierAutorisationTemporaire",true);
                    GestionEntreeSortie.AutorisationTemporaireHelper.write(_output,at);
                    GestionEntreeSortie.AutorisationTemporaireHelper.write(_output,nt);
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
                    if (_exception_id.equals(GestionEntreeSortie.AutorisationInconnueHelper.id()))
                    {
                        throw GestionEntreeSortie.AutorisationInconnueHelper.read(_exception.getInputStream());
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("modifierAutorisationTemporaire",_opsClass);
                if (_so == null)
                   continue;
                GestionEntreeSortie.GestionAutorisationOperations _self = (GestionEntreeSortie.GestionAutorisationOperations) _so.servant;
                try
                {
                    _self.modifierAutorisationTemporaire( at,  nt,  cleAPI);
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
     * Operation supprimerAutorisationTemporaire
     */
    public void supprimerAutorisationTemporaire(GestionEntreeSortie.AutorisationTemporaire at, String cleAPI)
        throws GestionEntreeSortie.AutorisationInconnue, GestionEntreeSortie.CleInconnue
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("supprimerAutorisationTemporaire",true);
                    GestionEntreeSortie.AutorisationTemporaireHelper.write(_output,at);
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
                    if (_exception_id.equals(GestionEntreeSortie.AutorisationInconnueHelper.id()))
                    {
                        throw GestionEntreeSortie.AutorisationInconnueHelper.read(_exception.getInputStream());
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("supprimerAutorisationTemporaire",_opsClass);
                if (_so == null)
                   continue;
                GestionEntreeSortie.GestionAutorisationOperations _self = (GestionEntreeSortie.GestionAutorisationOperations) _so.servant;
                try
                {
                    _self.supprimerAutorisationTemporaire( at,  cleAPI);
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
