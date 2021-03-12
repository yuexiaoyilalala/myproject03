package kelly.domain;

/**
 * @author Kelly  Email yuexiaoyilalala@gmail.com
 * @version 1.0
 * @Description
 * @date 2021/1/9 19:02
 */
public class Designer extends Programmer
{
    private double bonus;//奖金

    public Designer()
    {

    }

    public Designer(int id, String name, int age, double salary, Equipment equipment, double bonus)
    {
        super(id, name, age, salary, equipment);
        this.bonus = bonus;
    }

    public double getBonus()
    {
        return bonus;
    }

    public void setBonus(double bonus)
    {
        this.bonus = bonus;
    }

    public String toString()
    {
        return getDetails() + "\t设计师\t" + getStatus() + "\t" + bonus + "\t\t\t" + getEquipment().getDecription();
    }

    public String getDetailsForTeam()
    {
        return getTeamBaseDetails()+ "\t设计师\t" + getBonus();
    }
}
