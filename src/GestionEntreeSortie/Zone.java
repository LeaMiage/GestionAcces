package GestionEntreeSortie;

/**
 * Struct definition : Zone
 * 
 * @author OpenORB Compiler
*/
public final class Zone implements org.omg.CORBA.portable.IDLEntity
{
    /**
     * Struct member idZone
     */
    public int idZone;

    /**
     * Struct member libelleZone
     */
    public String libelleZone;

    /**
     * Struct member listeIdPortes
     */
    public int[] listeIdPortes;

    /**
     * Default constructor
     */
    public Zone()
    { }

    /**
     * Constructor with fields initialization
     * @param idZone idZone struct member
     * @param libelleZone libelleZone struct member
     * @param listeIdPortes listeIdPortes struct member
     */
    public Zone(int idZone, String libelleZone, int[] listeIdPortes)
    {
        this.idZone = idZone;
        this.libelleZone = libelleZone;
        this.listeIdPortes = listeIdPortes;
    }

}
