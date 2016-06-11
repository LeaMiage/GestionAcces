package GestionEntreeSortie;

/**
 * Exception definition : ZoneInconnue
 * 
 * @author OpenORB Compiler
 */
public final class ZoneInconnue extends org.omg.CORBA.UserException
{
    /**
     * Exception member message
     */
    public String message;

    /**
     * Default constructor
     */
    public ZoneInconnue()
    {
        super(ZoneInconnueHelper.id());
    }

    /**
     * Constructor with fields initialization
     * @param message message exception member
     */
    public ZoneInconnue(String message)
    {
        super(ZoneInconnueHelper.id());
        this.message = message;
    }

    /**
     * Full constructor with fields initialization
     * @param message message exception member
     */
    public ZoneInconnue(String orb_reason, String message)
    {
        super(ZoneInconnueHelper.id() +" " +  orb_reason);
        this.message = message;
    }

}
