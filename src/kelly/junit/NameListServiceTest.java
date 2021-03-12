package kelly.junit;

import kelly.domain.Employee;
import kelly.service.NameListService;
import kelly.service.TeamException;
import org.junit.Test;

/**
 * @author Kelly  Email yuexiaoyilalala@gmail.com
 * @version 1.0
 * @Description
 * @date 2021/1/9 23:44
 */
public class NameListServiceTest
{
     @Test
     public void testGetAllEmployees()
     {
         NameListService service = new NameListService();
         Employee[] employees = service.getAllEmployees();
         for (int i = 0;i < employees.length;i++)
         {
             System.out.println(employees[i]);
         }
     }

    @Test
    public void testGetEmployees()
    {
        NameListService service = new NameListService();
        int id = 101;
        try
        {
            Employee employee = service.getEmployee(id);
            System.out.println(employee);
        }
        catch (TeamException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
