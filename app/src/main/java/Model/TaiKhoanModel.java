package Model;

import java.io.Serializable;
import java.util.List;

public class TaiKhoanModel implements Serializable
{
    private String offset;

    private String hasMore;

    private String limit;

    private String count;

    private List<Links> links;

    private List<Items> items;

    public String getOffset ()
    {
        return offset;
    }

    public void setOffset (String offset)
    {
        this.offset = offset;
    }

    public String getHasMore ()
    {
        return hasMore;
    }

    public void setHasMore (String hasMore)
    {
        this.hasMore = hasMore;
    }

    public String getLimit ()
    {
        return limit;
    }

    public void setLimit (String limit)
    {
        this.limit = limit;
    }

    public String getCount ()
    {
        return count;
    }

    public void setCount (String count)
    {
        this.count = count;
    }

    public List<Links> getLinks ()
    {
        return links;
    }

    public void setLinks (List<Links> links)
    {
        this.links = links;
    }

    public List<Items> getItems ()
    {
        return items;
    }

    public void setItems (List<Items> items)
    {
        this.items = items;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [offset = "+offset+", hasMore = "+hasMore+", limit = "+limit+", count = "+count+", links = "+links+", items = "+items+"]";
    }
    public class Items implements Serializable
    {
        private String sdt;

        private String matkhau;

        private String gioitinh;

        private String hangtv;

        private String tenkh;

        private String ngaysinh;

        private Links[] links;

        private String cancuoc;

        private String email;

        public String getSdt ()
        {
            return sdt;
        }

        public void setSdt (String sdt)
        {
            this.sdt = sdt;
        }

        public String getMatkhau ()
        {
            return matkhau;
        }

        public void setMatkhau (String matkhau)
        {
            this.matkhau = matkhau;
        }

        public String getGioitinh ()
        {
            return gioitinh;
        }

        public void setGioitinh (String gioitinh)
        {
            this.gioitinh = gioitinh;
        }

        public String getHangtv ()
        {
            return hangtv;
        }

        public void setHangtv (String hangtv)
        {
            this.hangtv = hangtv;
        }

        public String getTenkh ()
        {
            return tenkh;
        }

        public void setTenkh (String tenkh)
        {
            this.tenkh = tenkh;
        }

        public String getNgaysinh ()
        {
            return ngaysinh;
        }

        public void setNgaysinh (String ngaysinh)
        {
            this.ngaysinh = ngaysinh;
        }

        public Links[] getLinks ()
        {
            return links;
        }

        public void setLinks (Links[] links)
        {
            this.links = links;
        }

        public String getCancuoc ()
        {
            return cancuoc;
        }

        public void setCancuoc (String cancuoc)
        {
            this.cancuoc = cancuoc;
        }

        public String getEmail ()
        {
            return email;
        }

        public void setEmail (String email)
        {
            this.email = email;
        }

        @Override
        public String toString()
        {
            return "ClassPojo [sdt = "+sdt+", matkhau = "+matkhau+", gioitinh = "+gioitinh+", hangtv = "+hangtv+", tenkh = "+tenkh+", ngaysinh = "+ngaysinh+", links = "+links+", cancuoc = "+cancuoc+", email = "+email+"]";
        }
    }
    public class Links implements Serializable
    {
        private String rel;

        private String href;

        public String getRel ()
        {
            return rel;
        }

        public void setRel (String rel)
        {
            this.rel = rel;
        }

        public String getHref ()
        {
            return href;
        }

        public void setHref (String href)
        {
            this.href = href;
        }

        @Override
        public String toString()
        {
            return "ClassPojo [rel = "+rel+", href = "+href+"]";
        }
    }
}
