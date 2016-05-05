package GestionEntreeSortie;

/**
 * Struct definition : Autorisation
 * 
 * @author OpenORB Compiler
*/
public final class Autorisation implements org.omg.CORBA.portable.IDLEntity
{
    /**
     * Struct member heureDebut
     */
    public String heureDebut;

    /**
     * Struct member heureFin
     */
    public String heureFin;

    /**
     * Default constructor
     */
    public Autorisation()
    { }

    /**
     * Constructor with fields initialization
     * @param heureDebut heureDebut struct member
     * @param heureFin heureFin struct member
     */
    public Autorisation(String heureDebut, String heureFin)
    {
        this.heureDebut = heureDebut;
        this.heureFin = heureFin;
    }

}
