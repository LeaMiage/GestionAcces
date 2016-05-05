package GestionEntreeSortie;

/**
 * Exception definition : JournalisationImpossible
 * 
 * @author OpenORB Compiler
 */
public final class JournalisationImpossible extends org.omg.CORBA.UserException
{
    /**
     * Exception member message
     */
    public String message;

    /**
     * Default constructor
     */
    public JournalisationImpossible()
    {
        super(JournalisationImpossibleHelper.id());
    }

    /**
     * Constructor with fields initialization
     * @param message message exception member
     */
    public JournalisationImpossible(String message)
    {
        super(JournalisationImpossibleHelper.id());
        this.message = message;
    }

    /**
     * Full constructor with fields initialization
     * @param message message exception member
     */
    public JournalisationImpossible(String orb_reason, String message)
    {
        super(JournalisationImpossibleHelper.id() +" " +  orb_reason);
        this.message = message;
    }

}
