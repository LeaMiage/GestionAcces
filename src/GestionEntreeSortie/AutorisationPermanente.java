package GestionEntreeSortie;

/**
 * Struct definition : AutorisationPermanente
 * 
 * @author OpenORB Compiler
*/
public final class AutorisationPermanente implements org.omg.CORBA.portable.IDLEntity
{
    /**
     * Struct member idPersonne
     */
    public int idPersonne;

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
     * @param idPersonne idPersonne struct member
     * @param heureDebut heureDebut struct member
     * @param heureFin heureFin struct member
     */
    public AutorisationPermanente(int idPersonne, String heureDebut, String heureFin)
    {
        this.idPersonne = idPersonne;
        this.heureDebut = heureDebut;
        this.heureFin = heureFin;
    }

}
