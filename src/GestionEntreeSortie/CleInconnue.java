package GestionEntreeSortie;

/**
 * Exception definition : CleInconnue
 * 
 * @author OpenORB Compiler
 */
public final class CleInconnue extends org.omg.CORBA.UserException
{
    /**
     * Exception member message
     */
    public String message;

    /**
     * Default constructor
     */
    public CleInconnue()
    {
        super(CleInconnueHelper.id());
    }

    /**
     * Constructor with fields initialization
     * @param message message exception member
     */
    public CleInconnue(String message)
    {
        super(CleInconnueHelper.id());
        this.message = message;
    }

    /**
     * Full constructor with fields initialization
     * @param message message exception member
     */
    public CleInconnue(String orb_reason, String message)
    {
        super(CleInconnueHelper.id() +" " +  orb_reason);
        this.message = message;
    }

}
