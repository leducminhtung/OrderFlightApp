package Model;

import java.io.Serializable;
import java.util.List;

public class ChuyenBayModel implements Serializable
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
    public class Items implements Serializable
    {
        private String macb;

        private String macangden;

        private String tenmb;

        private String gvtg;

        private String giobay;

        private String thoiluongcb;

        private String macangdi;

        private String tencangdi;

        private String gvht;

        private String tencangden;

        public String getMacb ()
        {
            return macb;
        }

        public void setMacb (String macb)
        {
            this.macb = macb;
        }

        public String getMacangden ()
        {
            return macangden;
        }

        public void setMacangden (String macangden)
        {
            this.macangden = macangden;
        }

        public String getTenmb ()
        {
            return tenmb;
        }

        public void setTenmb (String tenmb)
        {
            this.tenmb = tenmb;
        }

        public String getGvtg ()
        {
            return gvtg;
        }

        public void setGvtg (String gvtg)
        {
            this.gvtg = gvtg;
        }

        public String getGiobay ()
        {
            return giobay;
        }

        public void setGiobay (String giobay)
        {
            this.giobay = giobay;
        }

        public String getThoiluongcb ()
        {
            return thoiluongcb;
        }

        public void setThoiluongcb (String thoiluongcb)
        {
            this.thoiluongcb = thoiluongcb;
        }

        public String getMacangdi ()
        {
            return macangdi;
        }

        public void setMacangdi (String macangdi)
        {
            this.macangdi = macangdi;
        }

        public String getTencangdi ()
        {
            return tencangdi;
        }

        public void setTencangdi (String tencangdi)
        {
            this.tencangdi = tencangdi;
        }

        public String getGvht ()
        {
            return gvht;
        }

        public void setGvht (String gvht)
        {
            this.gvht = gvht;
        }

        public String getTencangden ()
        {
            return tencangden;
        }

        public void setTencangden (String tencangden)
        {
            this.tencangden = tencangden;
        }

        @Override
        public String toString()
        {
            return "ClassPojo [macb = "+macb+", macangden = "+macangden+", tenmb = "+tenmb+", gvtg = "+gvtg+", giobay = "+giobay+", thoiluongcb = "+thoiluongcb+", macangdi = "+macangdi+", tencangdi = "+tencangdi+", gvht = "+gvht+", tencangden = "+tencangden+"]";
        }
    }
}