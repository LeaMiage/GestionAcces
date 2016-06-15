package GestionEntreeSortie;

/**
 * Struct definition : EntreeJournal
 * 
 * @author OpenORB Compiler
*/
public final class EntreeJournal implements org.omg.CORBA.portable.IDLEntity
{
    /**
     * Struct member idZone
     */
    public int idZone;

    /**
     * Struct member idPorte
     */
    public int idPorte;

    /**
     * Struct member photoP
     */
    public String photoP;

    /**
     * Struct member statut
     */
    public String statut;

    /**
     * Struct member typeAcces
     */
    public String typeAcces;

    /**
     * Struct member dateAcces
     */
    public double dateAcces;

    /**
     * Default constructor
     */
    public EntreeJournal()
    { }

    /**
     * Constructor with fields initialization
     * @param idZone idZone struct member
     * @param idPorte idPorte struct member
     * @param photoP photoP struct member
     * @param statut statut struct member
     * @param typeAcces typeAcces struct member
     * @param dateAcces dateAcces struct member
     */
    public EntreeJournal(int idZone, int idPorte, String photoP, String statut, String typeAcces, double dateAcces)
    {
        this.idZone = idZone;
        this.idPorte = idPorte;
        this.photoP = photoP;
        this.statut = statut;
        this.typeAcces = typeAcces;
        this.dateAcces = dateAcces;
    }

}
