package GestionEntreeSortie;

/**
 * Exception definition : AutorisationInconnue
 * 
 * @author OpenORB Compiler
 */
public final class AutorisationInconnue extends org.omg.CORBA.UserException
{
    /**
     * Exception member message
     */
    public String message;

    /**
     * Default constructor
     */
    public AutorisationInconnue()
    {
        super(AutorisationInconnueHelper.id());
    }

    /**
     * Constructor with fields initialization
     * @param message message exception member
     */
    public AutorisationInconnue(String message)
    {
        super(AutorisationInconnueHelper.id());
        this.message = message;
    }

    /**
     * Full constructor with fields initialization
     * @param message message exception member
     */
    public AutorisationInconnue(String orb_reason, String message)
    {
        super(AutorisationInconnueHelper.id() +" " +  orb_reason);
        this.message = message;
    }

}
