package GestionEntreeSortie;

/**
 * Exception definition : PersonneExistante
 * 
 * @author OpenORB Compiler
 */
public final class PersonneExistante extends org.omg.CORBA.UserException
{
    /**
     * Exception member message
     */
    public String message;

    /**
     * Default constructor
     */
    public PersonneExistante()
    {
        super(PersonneExistanteHelper.id());
    }

    /**
     * Constructor with fields initialization
     * @param message message exception member
     */
    public PersonneExistante(String message)
    {
        super(PersonneExistanteHelper.id());
        this.message = message;
    }

    /**
     * Full constructor with fields initialization
     * @param message message exception member
     */
    public PersonneExistante(String orb_reason, String message)
    {
        super(PersonneExistanteHelper.id() +" " +  orb_reason);
        this.message = message;
    }

}
