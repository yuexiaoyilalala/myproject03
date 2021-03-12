package kelly.domain;

/**
 * @author Kelly  Email yuexiaoyilalala@gmail.com
 * @version 1.0
 * @Description
 * @date 2021/1/9 18:39
 */
public class Printer implements Equipment
{
     private String name;//机器型号
     private String type;//机器类型

    public Printer()
    {

    }

    public Printer(String name, String type)
    {
        this.name = name;
        this.type = type;
    }

    @Override
    public String getDecription()
    {
        return name + "(" + type + ")";
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }
}
