package GestionEntreeSortie;

/**
 * Exception definition : EmpreinteInconnue
 * 
 * @author OpenORB Compiler
 */
public final class EmpreinteInconnue extends org.omg.CORBA.UserException
{
    /**
     * Exception member message
     */
    public String message;

    /**
     * Default constructor
     */
    public EmpreinteInconnue()
    {
        super(EmpreinteInconnueHelper.id());
    }

    /**
     * Constructor with fields initialization
     * @param message message exception member
     */
    public EmpreinteInconnue(String message)
    {
        super(EmpreinteInconnueHelper.id());
        this.message = message;
    }

    /**
     * Full constructor with fields initialization
     * @param message message exception member
     */
    public EmpreinteInconnue(String orb_reason, String message)
    {
        super(EmpreinteInconnueHelper.id() +" " +  orb_reason);
        this.message = message;
    }

}
