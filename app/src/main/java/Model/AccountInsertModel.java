package Model;

import java.io.Serializable;

public class AccountInsertModel implements Serializable
{
    private String CANCUOC;

    private String MATKHAU;

    public String getCANCUOC ()
    {
        return CANCUOC;
    }

    public void setCANCUOC (String CANCUOC)
    {
        this.CANCUOC = CANCUOC;
    }

    public String getMATKHAU ()
    {
        return MATKHAU;
    }

    public void setMATKHAU (String MATKHAU)
    {
        this.MATKHAU = MATKHAU;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [CANCUOC = "+CANCUOC+", MATKHAU = "+MATKHAU+"]";
    }
}
