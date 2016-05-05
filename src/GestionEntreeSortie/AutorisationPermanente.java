package GestionEntreeSortie;

/**
 * Struct definition : AutorisationPermanente
 * 
 * @author OpenORB Compiler
*/
public final class AutorisationPermanente implements org.omg.CORBA.portable.IDLEntity
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
    public AutorisationPermanente()
    { }

    /**
     * Constructor with fields initialization
     * @param heureDebut heureDebut struct member
     * @param heureFin heureFin struct member
     */
    public AutorisationPermanente(String heureDebut, String heureFin)
    {
        this.heureDebut = heureDebut;
        this.heureFin = heureFin;
    }

}
