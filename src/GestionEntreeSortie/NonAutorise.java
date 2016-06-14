package GestionEntreeSortie;

/**
 * Exception definition : NonAutorise
 * 
 * @author OpenORB Compiler
 */
public final class NonAutorise extends org.omg.CORBA.UserException
{
    /**
     * Exception member message
     */
    public String message;

    /**
     * Default constructor
     */
    public NonAutorise()
    {
        super(NonAutoriseHelper.id());
    }

    /**
     * Constructor with fields initialization
     * @param message message exception member
     */
    public NonAutorise(String message)
    {
        super(NonAutoriseHelper.id());
        this.message = message;
    }

    /**
     * Full constructor with fields initialization
     * @param message message exception member
     */
    public NonAutorise(String orb_reason, String message)
    {
        super(NonAutoriseHelper.id() +" " +  orb_reason);
        this.message = message;
    }

}
