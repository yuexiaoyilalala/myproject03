package kelly.view;

import java.util.*;

/**
 * @author Kelly  Email yuexiaoyilalala@gmail.com
 * @version 1.0
 * @Description 项目中提供了TSUtility.java类，可用来方便的实现键盘访问
 * @date 2021/1/9 13:29
 */
public class TSUtility
{
    private static Scanner scanner = new Scanner(System.in);

    /**
     *@Description 用来界面菜单的选择。该方法读取键盘，如果用户键入‘1’-‘4’中的任意字符，则方法返回。返回值为用户键入字符。
     * @param
     *@return
     */
    public static char readMeanSelection()
    {
        char c;
        for (;;)
        {
            String str = readKeyBoard(1,false);
            c = str.charAt(0);
            if(c != '1' && c != '2' && c != '3' && c != '4' )
            {
                System.out.println("选择错误，请重新输入：");
            }
            else break;
        }
        return c;
    }
    
    /*
     *@Description 该方法提示并等待，直到用户按回车键后返回
     * @param null
     *@return
    */
    
    public static void readReturn()
    {
        System.out.println("按回车继续...");
        readKeyBoard(100,true);
    }

    /**
     *@Description 从键盘读取一个长度不超过2位的整数，并将其作为方法返回值
     * @param
     *@return
     */
    public static int readInt()
    {
        int n;
        for (;;)
        {
            String str = readKeyBoard(2,false);
            try
            {
                n = Integer.parseInt(str);
                break;
            }
            catch (NumberFormatException e)
            {
                System.out.println("数字输入错误，请重新输入：");
            }
        }
        return n;
    }

    /**
     *@Description 用于确认选择的输入。该方法从键盘读取'Y'或'N,并将其作为方法的返回值
     * @param
     *@return
     */
    public static char readConfirmSelection()
    {
        char c;
        for (;;)
        {
            String str = readKeyBoard(1,false).toUpperCase();
            c = str.charAt(0);
            if(c == 'Y' || c == 'N')
            {
                break;
            }
            else
            {
                System.out.print("选择错误，请重新输入：");
            }
        }
        return c;
    }

    private static String readKeyBoard(int limit,boolean blankReturn)
    {
        String line = "";
        while (scanner.hasNextLine())//如果在此扫描器的输入中存在另一行，则返回 true。
        {
            line = scanner.nextLine();//使此扫描器超过当前行并返回跳过的输入。
            if(line.length() == 0)
            {
                if(blankReturn)
                    return line;
                else continue;
            }
            if(line.length() < 1 || line.length() > limit)
            {
                System.out.print("输入长度（不大于" + limit + ")错误，请重新输入：");
                continue;
            }
            break;
        }
        return line;
    }
}
