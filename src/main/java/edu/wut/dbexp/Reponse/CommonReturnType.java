package edu.wut.dbexp.Reponse;

/**
 * @author 多喝岩浆
 */
public class CommonReturnType
{
    private String msg;
    private Integer status;
    private Object data;

    public static CommonReturnType create(Object result)
    {
        return CommonReturnType.create(result,"success");
    }

    public static CommonReturnType create(Object result,String msg)
    {
        CommonReturnType commonReturnType = new CommonReturnType();
        commonReturnType.setData(result);
        commonReturnType.setMsg(msg);
        if(msg.equals("success"))
        {
            commonReturnType.setStatus(1);
        }else
        {
            commonReturnType.setStatus(0);
        }
        return commonReturnType;
    }

    public String getMsg()
    {
        return msg;
    }

    public void setMsg(String msg)
    {
        this.msg = msg;
    }

    public Integer getStatus()
    {
        return status;
    }

    public void setStatus(Integer status)
    {
        this.status = status;
    }

    public Object getData()
    {
        return data;
    }

    public void setData(Object data)
    {
        this.data = data;
    }
}
