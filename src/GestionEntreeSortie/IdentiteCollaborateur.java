package GestionEntreeSortie;

/**
 * Struct definition : IdentiteCollaborateur
 * 
 * @author OpenORB Compiler
*/
public final class IdentiteCollaborateur implements org.omg.CORBA.portable.IDLEntity
{
    /**
     * Struct member idPersonne
     */
    public int idPersonne;

    /**
     * Struct member nomP
     */
    public String nomP;

    /**
     * Struct member prenomP
     */
    public String prenomP;

    /**
     * Struct member photoP
     */
    public String photoP;

    /**
     * Default constructor
     */
    public IdentiteCollaborateur()
    { }

    /**
     * Constructor with fields initialization
     * @param idPersonne idPersonne struct member
     * @param nomP nomP struct member
     * @param prenomP prenomP struct member
     * @param photoP photoP struct member
     */
    public IdentiteCollaborateur(int idPersonne, String nomP, String prenomP, String photoP)
    {
        this.idPersonne = idPersonne;
        this.nomP = nomP;
        this.prenomP = prenomP;
        this.photoP = photoP;
    }

}
