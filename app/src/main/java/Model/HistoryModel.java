package Model;

import java.io.Serializable;
import java.util.List;

public class HistoryModel implements Serializable
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
    public class Items implements Serializable {
        private String giobay;

        private String tienve;

        private String cangdi;

        private String tinhtrang;

        private String ngaymua;

        private String ngaybay;

        private String cangden;

        private String loaive;

        public String getGiobay() {
            return giobay;
        }

        public void setGiobay(String giobay) {
            this.giobay = giobay;
        }

        public String getTienve() {
            return tienve;
        }

        public void setTienve(String tienve) {
            this.tienve = tienve;
        }

        public String getCangdi() {
            return cangdi;
        }

        public void setCangdi(String cangdi) {
            this.cangdi = cangdi;
        }

        public String getTinhtrang() {
            return tinhtrang;
        }

        public void setTinhtrang(String tinhtrang) {
            this.tinhtrang = tinhtrang;
        }

        public String getNgaymua() {
            return ngaymua;
        }

        public void setNgaymua(String ngaymua) {
            this.ngaymua = ngaymua;
        }

        public String getNgaybay() {
            return ngaybay;
        }

        public void setNgaybay(String ngaybay) {
            this.ngaybay = ngaybay;
        }

        public String getCangden() {
            return cangden;
        }

        public void setCangden(String cangden) {
            this.cangden = cangden;
        }

        public String getLoaive() {
            return loaive;
        }

        public void setLoaive(String loaive) {
            this.loaive = loaive;
        }

        @Override
        public String toString() {
            return "ClassPojo [giobay = " + giobay + ", tienve = " + tienve + ", cangdi = " + cangdi + ", tinhtrang = " + tinhtrang + ", ngaymua = " + ngaymua + ", ngaybay = " + ngaybay + ", cangden = " + cangden + ", loaive = " + loaive + "]";
        }
    }
}