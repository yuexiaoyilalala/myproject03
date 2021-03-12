package kelly.domain;

/**
 * @author Kelly  Email yuexiaoyilalala@gmail.com
 * @version 1.0
 * @Description
 * @date 2021/1/9 18:28
 */
public class PC implements Equipment
{
    private String model;//�����ͺ�
    private String display;//��ʾ������


    public PC()
    {
        super();
    }

    public PC(String model, String display)
    {
        super();
        this.model = model;
        this.display = display;
    }

    @Override
    public String getDecription()
    {
        return model + "(" + display + ")";
    }

    public String getModel()
    {
        return model;
    }

    public void setModel(String model)
    {
        this.model = model;
    }

    public String getDisplay()
    {
        return display;
    }

    public void setDisplay(String display)
    {
        this.display = display;
    }
}
