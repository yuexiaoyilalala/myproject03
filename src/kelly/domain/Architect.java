package kelly.domain;

/**
 * @author Kelly  Email yuexiaoyilalala@gmail.com
 * @version 1.0
 * @Description
 * @date 2021/1/9 19:04
 */
public class Architect extends Designer
{
    private int stock;//��Ʊ

    public Architect()
    {

    }

    public Architect(int id, String name, int age, double salary, Equipment equipment, double bonus, int stock)
    {
        super(id, name, age, salary, equipment, bonus);
        this.stock = stock;
    }

    public String toString()
    {
        return getDetails() + "\t�ܹ�ʦ\t" + getStatus() + "\t" + getBonus() + "\t" + stock + "\t" + getEquipment().getDecription();
    }

    public String getDetailsForTeam()
    {
        return getTeamBaseDetails()+ "\t�ܹ�ʦ\t" + getBonus() + "\t" + stock;
    }

}
