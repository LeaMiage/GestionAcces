package GestionEntreeSortie;

/**
 * Struct definition : Empreinte
 * 
 * @author OpenORB Compiler
*/
public final class Empreinte implements org.omg.CORBA.portable.IDLEntity
{
    /**
     * Struct member idPersonne
     */
    public int idPersonne;

    /**
     * Struct member empreinte
     */
    public String empreinte;

    /**
     * Default constructor
     */
    public Empreinte()
    { }

    /**
     * Constructor with fields initialization
     * @param idPersonne idPersonne struct member
     * @param empreinte empreinte struct member
     */
    public Empreinte(int idPersonne, String empreinte)
    {
        this.idPersonne = idPersonne;
        this.empreinte = empreinte;
    }

}
