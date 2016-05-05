package GestionEntreeSortie;

/**
 * Struct definition : AutorisationTemporaire
 * 
 * @author OpenORB Compiler
*/
public final class AutorisationTemporaire implements org.omg.CORBA.portable.IDLEntity
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
     * Struct member jourDebut
     */
    public String jourDebut;

    /**
     * Struct member jourFin
     */
    public String jourFin;

    /**
     * Default constructor
     */
    public AutorisationTemporaire()
    { }

    /**
     * Constructor with fields initialization
     * @param heureDebut heureDebut struct member
     * @param heureFin heureFin struct member
     * @param jourDebut jourDebut struct member
     * @param jourFin jourFin struct member
     */
    public AutorisationTemporaire(String heureDebut, String heureFin, String jourDebut, String jourFin)
    {
        this.heureDebut = heureDebut;
        this.heureFin = heureFin;
        this.jourDebut = jourDebut;
        this.jourFin = jourFin;
    }

}
