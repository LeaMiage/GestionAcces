package GestionEntreeSortie;

/**
 * Exception definition : EmpreinteExistante
 * 
 * @author OpenORB Compiler
 */
public final class EmpreinteExistante extends org.omg.CORBA.UserException
{
    /**
     * Exception member message
     */
    public String message;

    /**
     * Default constructor
     */
    public EmpreinteExistante()
    {
        super(EmpreinteExistanteHelper.id());
    }

    /**
     * Constructor with fields initialization
     * @param message message exception member
     */
    public EmpreinteExistante(String message)
    {
        super(EmpreinteExistanteHelper.id());
        this.message = message;
    }

    /**
     * Full constructor with fields initialization
     * @param message message exception member
     */
    public EmpreinteExistante(String orb_reason, String message)
    {
        super(EmpreinteExistanteHelper.id() +" " +  orb_reason);
        this.message = message;
    }

}
