package Administration;

import java.io.Serializable;

public class Zone implements Serializable
{

    public int idZone;

    public String libelleZone;

    public int[] listeIdPortes;



    public Zone(int idZone, String libelleZone, int[] listeIdPortes)
    {
        this.idZone = idZone;
        this.libelleZone = libelleZone;
        this.listeIdPortes = listeIdPortes;
    }

}
