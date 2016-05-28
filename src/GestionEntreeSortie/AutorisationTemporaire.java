package GestionEntreeSortie;

/**
 * Struct definition : AutorisationTemporaire
 * 
 * @author OpenORB Compiler
*/
public final class AutorisationTemporaire implements org.omg.CORBA.portable.IDLEntity
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
     * @param idPersonne idPersonne struct member
     * @param heureDebut heureDebut struct member
     * @param heureFin heureFin struct member
     * @param jourDebut jourDebut struct member
     * @param jourFin jourFin struct member
     */
    public AutorisationTemporaire(int idPersonne, String heureDebut, String heureFin, String jourDebut, String jourFin)
    {
        this.idPersonne = idPersonne;
        this.heureDebut = heureDebut;
        this.heureFin = heureFin;
        this.jourDebut = jourDebut;
        this.jourFin = jourFin;
    }

}
