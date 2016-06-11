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
     * Struct member dateDebut
     */
    public double dateDebut;

    /**
     * Struct member dateFin
     */
    public double dateFin;

    /**
     * Default constructor
     */
    public AutorisationTemporaire()
    { }

    /**
     * Constructor with fields initialization
     * @param idPersonne idPersonne struct member
     * @param dateDebut dateDebut struct member
     * @param dateFin dateFin struct member
     */
    public AutorisationTemporaire(int idPersonne, double dateDebut, double dateFin)
    {
        this.idPersonne = idPersonne;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }

}
