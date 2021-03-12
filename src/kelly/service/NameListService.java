package kelly.service;

import kelly.domain.*;

/**
 * @author Kelly  Email yuexiaoyilalala@gmail.com
 * @version 1.0
 * @Description ����Data�е��鼮��װ��Employee[]�����У�ͬʱ�ṩ��ز���Employee[]�ķ���
 * @date 2021/1/9 19:07
 */
public class NameListService
{
     private Employee[] employees;

     /*
      *@Description ��employees������Ԫ�ؽ��г�ʼ��
      * @param null
      *@return
     */
     
    public NameListService()
    {
        //1.������Ŀ�ṩ��Data�๹����Ӧ��С��employees����
        //2.�ٸ���Data���е����ݹ�����ͬ�Ķ��󣬰���Employee��Programmer��Designer��Architect
        //3.���������������
        employees = new Employee[Data.EMPLOYEES.length];

        for(int i = 0; i < employees.length;i++)
        {
            //��ȡԱ��������
            int type = Integer.parseInt(Data.EMPLOYEES[i][0]);
            //��ȡEmployee��4��������Ϣ
            int id = Integer.parseInt(Data.EMPLOYEES[i][1]);
            String name = Data.EMPLOYEES[i][2];
            int age = Integer.parseInt(Data.EMPLOYEES[i][3]);
            double salary = Double.parseDouble(Data.EMPLOYEES[i][4]);

            Equipment equipment;
            double bonus;
            int stock;
            switch (type)
            {
                case Data.EMPLOYEE:
                    employees[i] = new Employee(id,name,age,salary);
                    break;
                case Data.PROGRAMMER:
                    equipment = createEquipment(i);
                    employees[i] = new Programmer(id,name,age,salary,equipment);
                    break;
                case Data.DESIGNER:
                    equipment = createEquipment(i);
                    bonus = Double.parseDouble(Data.EMPLOYEES[i][5]);
                    employees[i] = new Designer(id,name,age,salary,equipment,bonus);
                    break;
                case Data.ARCHITECT:
                    equipment = createEquipment(i);
                    bonus = Double.parseDouble(Data.EMPLOYEES[i][5]);
                    stock = Integer.parseInt(Data.EMPLOYEES[i][6]);
                    employees[i] = new Architect(id,name,age,salary,equipment,bonus,stock);
                    break;
            }
        }
    }

    /*
     *@Description ��ȡָ��index�ϵ�Ա�����豸
     * @param null
     *@return
    */

    private Equipment createEquipment(int index)
    {
        int key = Integer.parseInt(Data.EQUIPMENTS[index][0]);
        String modelOrName = Data.EQUIPMENTS[index][1];
        switch (key)
        {
            case Data.PC://21
                String display = Data.EQUIPMENTS[index][2];
                return new PC(modelOrName,display);
            case Data.NOTEBOOK://22
                double price = Double.parseDouble(Data.EQUIPMENTS[index][2]);
                return new NoteBook(modelOrName,price);
            case Data.PRINTER://23
                String type = Data.EQUIPMENTS[index][2];
                return new Printer(modelOrName,type);

        }
        return null;
    }

    /*
     *@Description ��ȡ��ǰ����Ա��
     * @param null
     *@return
    */
    public Employee[] getAllEmployees()
    {
        return employees;
    }

    /**
     * @Description:
     * @param id
     * @return kelly.domain.Employee
     * @throws TeamException
     */

    public Employee getEmployee(int id) throws TeamException
    {
        for (int i = 0;i < employees.length;i++)
        {
             if(employees[i].getId() == id)
             {
                 return employees[i];
             }
        }
        throw new TeamException("�Ҳ���ָ����Ա��");
    }
}
