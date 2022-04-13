package Model;

import java.io.Serializable;

public class CustomerUpdateModel
{
    private String CANCUOC;

    private String SDT;

    private String TENKH;

    private String EMAIL;

    private String MATKHAU;

    private String GIOITINH;

    private String NGAYSINH;

    public String getCANCUOC ()
    {
        return CANCUOC;
    }

    public void setCANCUOC (String CANCUOC)
    {
        this.CANCUOC = CANCUOC;
    }

    public String getSDT ()
    {
        return SDT;
    }

    public void setSDT (String SDT)
    {
        this.SDT = SDT;
    }

    public String getTENKH ()
    {
        return TENKH;
    }

    public void setTENKH (String TENKH)
    {
        this.TENKH = TENKH;
    }

    public String getEMAIL ()
    {
        return EMAIL;
    }

    public void setEMAIL (String EMAIL)
    {
        this.EMAIL = EMAIL;
    }

    public String getMATKHAU ()
    {
        return MATKHAU;
    }

    public void setMATKHAU (String MATKHAU)
    {
        this.MATKHAU = MATKHAU;
    }

    public String getGIOITINH ()
    {
        return GIOITINH;
    }

    public void setGIOITINH (String GIOITINH)
    {
        this.GIOITINH = GIOITINH;
    }

    public String getNGAYSINH ()
    {
        return NGAYSINH;
    }

    public void setNGAYSINH (String NGAYSINH)
    {
        this.NGAYSINH = NGAYSINH;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [CANCUOC = "+CANCUOC+", SDT = "+SDT+", TENKH = "+TENKH+", EMAIL = "+EMAIL+", MATKHAU = "+MATKHAU+", GIOITINH = "+GIOITINH+", NGAYSINH = "+NGAYSINH+"]";
    }
}