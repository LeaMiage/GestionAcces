package GestionEntreeSortie;

/**
 * Exception definition : AutorisationExistante
 * 
 * @author OpenORB Compiler
 */
public final class AutorisationExistante extends org.omg.CORBA.UserException
{
    /**
     * Exception member message
     */
    public String message;

    /**
     * Default constructor
     */
    public AutorisationExistante()
    {
        super(AutorisationExistanteHelper.id());
    }

    /**
     * Constructor with fields initialization
     * @param message message exception member
     */
    public AutorisationExistante(String message)
    {
        super(AutorisationExistanteHelper.id());
        this.message = message;
    }

    /**
     * Full constructor with fields initialization
     * @param message message exception member
     */
    public AutorisationExistante(String orb_reason, String message)
    {
        super(AutorisationExistanteHelper.id() +" " +  orb_reason);
        this.message = message;
    }

}
