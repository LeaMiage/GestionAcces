package GestionEntreeSortie;

/**
 * Exception definition : AjoutAPImpossible
 * 
 * @author OpenORB Compiler
 */
public final class AjoutAPImpossible extends org.omg.CORBA.UserException
{
    /**
     * Exception member message
     */
    public String message;

    /**
     * Default constructor
     */
    public AjoutAPImpossible()
    {
        super(AjoutAPImpossibleHelper.id());
    }

    /**
     * Constructor with fields initialization
     * @param message message exception member
     */
    public AjoutAPImpossible(String message)
    {
        super(AjoutAPImpossibleHelper.id());
        this.message = message;
    }

    /**
     * Full constructor with fields initialization
     * @param message message exception member
     */
    public AjoutAPImpossible(String orb_reason, String message)
    {
        super(AjoutAPImpossibleHelper.id() +" " +  orb_reason);
        this.message = message;
    }

}
