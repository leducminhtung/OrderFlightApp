package Model;

public class PhieuMuaVeInsertModel
{
    private String THANHTIEN;

    private String CANCUOC;

    private String SLVE;

    public String getTHANHTIEN ()
    {
        return THANHTIEN;
    }

    public void setTHANHTIEN (String THANHTIEN)
    {
        this.THANHTIEN = THANHTIEN;
    }

    public String getCANCUOC ()
    {
        return CANCUOC;
    }

    public void setCANCUOC (String CANCUOC)
    {
        this.CANCUOC = CANCUOC;
    }

    public String getSLVE ()
    {
        return SLVE;
    }

    public void setSLVE (String SLVE)
    {
        this.SLVE = SLVE;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [THANHTIEN = "+THANHTIEN+", CANCUOC = "+CANCUOC+", SLVE = "+SLVE+"]";
    }
}