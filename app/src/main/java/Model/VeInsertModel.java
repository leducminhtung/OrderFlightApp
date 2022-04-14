package Model;

public class VeInsertModel
{
    private String MACB;

    private String TIENVE;

    private String CANCUOC;

    private String MAPHIEU;

    public String getMACB ()
    {
        return MACB;
    }

    public void setMACB (String MACB)
    {
        this.MACB = MACB;
    }

    public String getTIENVE ()
    {
        return TIENVE;
    }

    public void setTIENVE (String TIENVE)
    {
        this.TIENVE = TIENVE;
    }

    public String getCANCUOC ()
    {
        return CANCUOC;
    }

    public void setCANCUOC (String CANCUOC)
    {
        this.CANCUOC = CANCUOC;
    }

    public String getMAPHEU ()
    {
        return MAPHIEU;
    }

    public void setMAPHEU (String MAPHEU)
    {
        this.MAPHIEU = MAPHEU;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [MACB = "+MACB+", TIENVE = "+TIENVE+", CANCUOC = "+CANCUOC+", MAPHIEU = "+MAPHIEU+"]";
    }
}