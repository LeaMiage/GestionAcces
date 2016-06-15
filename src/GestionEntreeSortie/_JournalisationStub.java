package GestionEntreeSortie;

/**
 * Interface definition : Journalisation
 * 
 * @author OpenORB Compiler
 */
public class _JournalisationStub extends org.omg.CORBA.portable.ObjectImpl
        implements Journalisation
{
    static final String[] _ids_list =
    {
        "IDL:GestionEntreeSortie/Journalisation:1.0"
    };

    public String[] _ids()
    {
     return _ids_list;
    }

    private final static Class _opsClass = GestionEntreeSortie.JournalisationOperations.class;

    /**
     * Operation journaliser
     */
    public void journaliser(int idZone, int idPorte, String photoP, String statut, String typeAcces, double dateAcces, String cleAPI)
        throws GestionEntreeSortie.JournalisationImpossible, GestionEntreeSortie.CleInconnue
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("journaliser",true);
                    _output.write_long(idZone);
                    _output.write_long(idPorte);
                    _output.write_string(photoP);
                    _output.write_string(statut);
                    _output.write_string(typeAcces);
                    _output.write_double(dateAcces);
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
                    if (_exception_id.equals(GestionEntreeSortie.JournalisationImpossibleHelper.id()))
                    {
                        throw GestionEntreeSortie.JournalisationImpossibleHelper.read(_exception.getInputStream());
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("journaliser",_opsClass);
                if (_so == null)
                   continue;
                GestionEntreeSortie.JournalisationOperations _self = (GestionEntreeSortie.JournalisationOperations) _so.servant;
                try
                {
                    _self.journaliser( idZone,  idPorte,  photoP,  statut,  typeAcces,  dateAcces,  cleAPI);
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
