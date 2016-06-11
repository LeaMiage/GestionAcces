package GestionEntreeSortie;

/**
 * Exception definition : ErreurAuthentification
 * 
 * @author OpenORB Compiler
 */
public final class ErreurAuthentification extends org.omg.CORBA.UserException
{
    /**
     * Exception member message
     */
    public String message;

    /**
     * Default constructor
     */
    public ErreurAuthentification()
    {
        super(ErreurAuthentificationHelper.id());
    }

    /**
     * Constructor with fields initialization
     * @param message message exception member
     */
    public ErreurAuthentification(String message)
    {
        super(ErreurAuthentificationHelper.id());
        this.message = message;
    }

    /**
     * Full constructor with fields initialization
     * @param message message exception member
     */
    public ErreurAuthentification(String orb_reason, String message)
    {
        super(ErreurAuthentificationHelper.id() +" " +  orb_reason);
        this.message = message;
    }

}
