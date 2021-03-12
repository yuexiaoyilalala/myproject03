package kelly.view;

import java.util.*;

/**
 * @author Kelly  Email yuexiaoyilalala@gmail.com
 * @version 1.0
 * @Description ��Ŀ���ṩ��TSUtility.java�࣬�����������ʵ�ּ��̷���
 * @date 2021/1/9 13:29
 */
public class TSUtility
{
    private static Scanner scanner = new Scanner(System.in);

    /**
     *@Description ��������˵���ѡ�񡣸÷�����ȡ���̣�����û����롮1��-��4���е������ַ����򷽷����ء�����ֵΪ�û������ַ���
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
                System.out.println("ѡ��������������룺");
            }
            else break;
        }
        return c;
    }
    
    /*
     *@Description �÷�����ʾ���ȴ���ֱ���û����س����󷵻�
     * @param null
     *@return
    */
    
    public static void readReturn()
    {
        System.out.println("���س�����...");
        readKeyBoard(100,true);
    }

    /**
     *@Description �Ӽ��̶�ȡһ�����Ȳ�����2λ����������������Ϊ��������ֵ
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
                System.out.println("��������������������룺");
            }
        }
        return n;
    }

    /**
     *@Description ����ȷ��ѡ������롣�÷����Ӽ��̶�ȡ'Y'��'N,��������Ϊ�����ķ���ֵ
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
                System.out.print("ѡ��������������룺");
            }
        }
        return c;
    }

    private static String readKeyBoard(int limit,boolean blankReturn)
    {
        String line = "";
        while (scanner.hasNextLine())//����ڴ�ɨ�����������д�����һ�У��򷵻� true��
        {
            line = scanner.nextLine();//ʹ��ɨ����������ǰ�в��������������롣
            if(line.length() == 0)
            {
                if(blankReturn)
                    return line;
                else continue;
            }
            if(line.length() < 1 || line.length() > limit)
            {
                System.out.print("���볤�ȣ�������" + limit + ")�������������룺");
                continue;
            }
            break;
        }
        return line;
    }
}
