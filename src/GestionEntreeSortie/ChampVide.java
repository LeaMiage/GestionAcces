package GestionEntreeSortie;

/**
 * Exception definition : ChampVide
 * 
 * @author OpenORB Compiler
 */
public final class ChampVide extends org.omg.CORBA.UserException
{
    /**
     * Exception member message
     */
    public String message;

    /**
     * Default constructor
     */
    public ChampVide()
    {
        super(ChampVideHelper.id());
    }

    /**
     * Constructor with fields initialization
     * @param message message exception member
     */
    public ChampVide(String message)
    {
        super(ChampVideHelper.id());
        this.message = message;
    }

    /**
     * Full constructor with fields initialization
     * @param message message exception member
     */
    public ChampVide(String orb_reason, String message)
    {
        super(ChampVideHelper.id() +" " +  orb_reason);
        this.message = message;
    }

}
