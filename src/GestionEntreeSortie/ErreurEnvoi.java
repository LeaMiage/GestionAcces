package GestionEntreeSortie;

/**
 * Exception definition : ErreurEnvoi
 * 
 * @author OpenORB Compiler
 */
public final class ErreurEnvoi extends org.omg.CORBA.UserException
{
    /**
     * Exception member message
     */
    public String message;

    /**
     * Default constructor
     */
    public ErreurEnvoi()
    {
        super(ErreurEnvoiHelper.id());
    }

    /**
     * Constructor with fields initialization
     * @param message message exception member
     */
    public ErreurEnvoi(String message)
    {
        super(ErreurEnvoiHelper.id());
        this.message = message;
    }

    /**
     * Full constructor with fields initialization
     * @param message message exception member
     */
    public ErreurEnvoi(String orb_reason, String message)
    {
        super(ErreurEnvoiHelper.id() +" " +  orb_reason);
        this.message = message;
    }

}
