package kelly.domain;

/**
 * @author Kelly  Email yuexiaoyilalala@gmail.com
 * @version 1.0
 * @Description
 * @date 2021/1/9 18:35
 */
public class NoteBook implements Equipment
{
     private String model;//机器型号
     private double price;//价格

    public NoteBook()
    {

    }

    public NoteBook(String model, double price)
    {
        this.model = model;
        this.price = price;
    }

    @Override
    public String getDecription()
    {
        return model + "(" + price +")";
    }

    public String getModel()
    {
        return model;
    }

    public void setModel(String model)
    {
        this.model = model;
    }

    public double getPrice()
    {
        return price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }
}
