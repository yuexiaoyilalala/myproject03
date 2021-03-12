package kelly.domain;

import kelly.service.Status;

/**
 * @author Kelly  Email yuexiaoyilalala@gmail.com
 * @version 1.0
 * @Description
 * @date 2021/1/9 18:48
 */
public class Programmer extends Employee
{
    private int memberId;//开发团队中的id
    private Status status = Status.FREE;
    private Equipment equipment;

    public Programmer()
    {

    }

    public Programmer(int id, String name, int age, double salary, Equipment equipment)
    {
        super(id, name, age, salary);
        this.equipment = equipment;
    }

    public int getMemberId()
    {
        return memberId;
    }

    public void setMemberId(int memberId)
    {
        this.memberId = memberId;
    }

    public Status getStatus()
    {
        return status;
    }

    public void setStatus(Status status)
    {
        this.status = status;
    }

    public Equipment getEquipment()
    {
        return equipment;
    }

    public void setEquipment(Equipment equipment)
    {
        this.equipment = equipment;
    }

    public String toString()
    {
        return getDetails() +  "\t程序员\t" + status + "\t\t\t\t\t" + equipment.getDecription();
    }

    public String getTeamBaseDetails()
    {
        return memberId + "/" + getId() + "\t\t" + getName() + "\t\t" + getAge() + "\t\t" + getSalary() ;
    }

    public String getDetailsForTeam()
    {
         return getTeamBaseDetails() + "\t程序员" ;
    }
}
