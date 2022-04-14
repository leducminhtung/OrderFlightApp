package Model;

import java.io.Serializable;

public class CallbackResultModel
{
    private String STATUS_OUT;

    private String VALUE_OUT;

    public String getSTATUS_OUT ()
    {
        return STATUS_OUT;
    }

    public void setSTATUS_OUT (String STATUS_OUT)
    {
        this.STATUS_OUT = STATUS_OUT;
    }

    public String getVALUE_OUT ()
    {
        return VALUE_OUT;
    }

    public void setVALUE_OUT (String VALUE_OUT)
    {
        this.VALUE_OUT = VALUE_OUT;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [STATUS_OUT = "+STATUS_OUT+", VALUE_OUT = "+VALUE_OUT+"]";
    }
}