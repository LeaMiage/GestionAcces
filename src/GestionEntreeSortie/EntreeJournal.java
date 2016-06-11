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
     * Struct member status
     */
    public String status;

    /**
     * Struct member typeAcces
     */
    public String typeAcces;

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
     * @param status status struct member
     * @param typeAcces typeAcces struct member
     */
    public EntreeJournal(int idZone, int idPorte, String photoP, String status, String typeAcces)
    {
        this.idZone = idZone;
        this.idPorte = idPorte;
        this.photoP = photoP;
        this.status = status;
        this.typeAcces = typeAcces;
    }

}
