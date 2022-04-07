package Model;

import java.io.Serializable;
import java.util.List;

public class CangModel implements Serializable
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
        private String quocgia;

        private String tinh;

        private List<Links> links;

        private String tencang;

        private String macang;

        public String getQuocgia ()
        {
            return quocgia;
        }

        public void setQuocgia (String quocgia)
        {
            this.quocgia = quocgia;
        }

        public String getTinh ()
        {
            return tinh;
        }

        public void setTinh (String tinh)
        {
            this.tinh = tinh;
        }

        public List<Links> getLinks ()
        {
            return links;
        }

        public void setLinks (List<Links> links)
        {
            this.links = links;
        }

        public String getTencang ()
        {
            return tencang;
        }

        public void setTencang (String tencang)
        {
            this.tencang = tencang;
        }

        public String getMacang ()
        {
            return macang;
        }

        public void setMacang (String macang)
        {
            this.macang = macang;
        }

        @Override
        public String toString()
        {
            return "ClassPojo [quocgia = "+quocgia+", tinh = "+tinh+", links = "+links+", tencang = "+tencang+", macang = "+macang+"]";
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
