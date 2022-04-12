package Model;

import java.io.Serializable;

public class CallbackResultModel
{
    private String STATUS_OUT;

    public String getSTATUS_OUT ()
    {
        return STATUS_OUT;
    }

    public void setSTATUS_OUT (String STATUS_OUT)
    {
        this.STATUS_OUT = STATUS_OUT;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [STATUS_OUT = "+STATUS_OUT+"]";
    }
}