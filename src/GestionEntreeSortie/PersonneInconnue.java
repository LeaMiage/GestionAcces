package GestionEntreeSortie;

/**
 * Exception definition : PersonneInconnue
 * 
 * @author OpenORB Compiler
 */
public final class PersonneInconnue extends org.omg.CORBA.UserException
{
    /**
     * Exception member message
     */
    public String message;

    /**
     * Default constructor
     */
    public PersonneInconnue()
    {
        super(PersonneInconnueHelper.id());
    }

    /**
     * Constructor with fields initialization
     * @param message message exception member
     */
    public PersonneInconnue(String message)
    {
        super(PersonneInconnueHelper.id());
        this.message = message;
    }

    /**
     * Full constructor with fields initialization
     * @param message message exception member
     */
    public PersonneInconnue(String orb_reason, String message)
    {
        super(PersonneInconnueHelper.id() +" " +  orb_reason);
        this.message = message;
    }

}
