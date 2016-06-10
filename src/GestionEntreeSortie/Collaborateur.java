package GestionEntreeSortie;

/**
 * Struct definition : Collaborateur
 * 
 * @author OpenORB Compiler
*/
public final class Collaborateur implements org.omg.CORBA.portable.IDLEntity
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
     * Struct member mdp
     */
    public String mdp;

    /**
     * Default constructor
     */
    public Collaborateur()
    { }

    /**
     * Constructor with fields initialization
     * @param idPersonne idPersonne struct member
     * @param nomP nomP struct member
     * @param prenomP prenomP struct member
     * @param photoP photoP struct member
     * @param mdp mdp struct member
     */
    public Collaborateur(int idPersonne, String nomP, String prenomP, String photoP, String mdp)
    {
        this.idPersonne = idPersonne;
        this.nomP = nomP;
        this.prenomP = prenomP;
        this.photoP = photoP;
        this.mdp = mdp;
    }

}
