package GestionEntreeSortie;

/**
 * Interface definition : ConsultationJournal
 * 
 * @author OpenORB Compiler
 */
public class _ConsultationJournalStub extends org.omg.CORBA.portable.ObjectImpl
        implements ConsultationJournal
{
    static final String[] _ids_list =
    {
        "IDL:GestionEntreeSortie/ConsultationJournal:1.0"
    };

    public String[] _ids()
    {
     return _ids_list;
    }

    private final static Class _opsClass = GestionEntreeSortie.ConsultationJournalOperations.class;

    /**
     * Operation consulterJournal
     */
    public GestionEntreeSortie.EntreeJournal[] consulterJournal(String cleAPI)
        throws GestionEntreeSortie.CleInconnue
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("consulterJournal",true);
                    _output.write_string(cleAPI);
                    _input = this._invoke(_output);
                    GestionEntreeSortie.EntreeJournal[] _arg_ret = GestionEntreeSortie.listeEntreesJournalHelper.read(_input);
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

                    throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: "+ _exception_id);
                }
                finally
                {
                    this._releaseReply(_input);
                }
            }
            else
            {
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("consulterJournal",_opsClass);
                if (_so == null)
                   continue;
                GestionEntreeSortie.ConsultationJournalOperations _self = (GestionEntreeSortie.ConsultationJournalOperations) _so.servant;
                try
                {
                    return _self.consulterJournal( cleAPI);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

}
