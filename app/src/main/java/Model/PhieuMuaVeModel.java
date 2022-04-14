package Model;

import java.io.Serializable;
import java.util.List;

public class PhieuMuaVeModel implements Serializable
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
        private String maphieu;

        private String thanhtien;

        private String ngaylap;

        private Links[] links;

        private String slve;

        private String cancuoc;

        public String getMaphieu ()
        {
            return maphieu;
        }

        public void setMaphieu (String maphieu)
        {
            this.maphieu = maphieu;
        }

        public String getThanhtien ()
        {
            return thanhtien;
        }

        public void setThanhtien (String thanhtien)
        {
            this.thanhtien = thanhtien;
        }

        public String getNgaylap ()
        {
            return ngaylap;
        }

        public void setNgaylap (String ngaylap)
        {
            this.ngaylap = ngaylap;
        }

        public Links[] getLinks ()
        {
            return links;
        }

        public void setLinks (Links[] links)
        {
            this.links = links;
        }

        public String getSlve ()
        {
            return slve;
        }

        public void setSlve (String slve)
        {
            this.slve = slve;
        }

        public String getCancuoc ()
        {
            return cancuoc;
        }

        public void setCancuoc (String cancuoc)
        {
            this.cancuoc = cancuoc;
        }

        @Override
        public String toString()
        {
            return "ClassPojo [maphieu = "+maphieu+", thanhtien = "+thanhtien+", ngaylap = "+ngaylap+", links = "+links+", slve = "+slve+", cancuoc = "+cancuoc+"]";
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