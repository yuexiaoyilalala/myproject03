package kelly.service;

import kelly.domain.Architect;
import kelly.domain.Designer;
import kelly.domain.Employee;
import kelly.domain.Programmer;

/**
 * @author Kelly  Email yuexiaoyilalala@gmail.com
 * @version 1.0
 * @Description ���ڿ����ŶӵĹ�����ӡ�ɾ��
 * @date 2021/1/10 13:59
 */
public class TeamService
{
    private static int counter = 1;//��memberId��ֵʹ��
    private final int MAX_MEMBER = 5;//���ƿ����Ŷӵ�����
    private Programmer[] team = new Programmer[MAX_MEMBER];//���濪���Ŷӳ�Ա
    private int total;//��¼�����Ŷ���ʵ�ʵ�����

    public TeamService()
    {
        super();
    }

    /*
     *@Description ��ȡ�����Ŷ��е����г�Ա
     * @param null
     *@return
    */
    
    public Programmer[] getTeam()
    {
        Programmer[] team = new Programmer[total];
        for (int i = 0;i < team.length;i++)
        {
            team[i] = this.team[i];
        }
        return team;
    }

    /*
     *@Description ��ָ����Ա����ӵ������Ŷ���
     * @param null
     *@return
    */
    
    public void addMember(Employee e) throws TeamException
    {
        //��Ա����
        if(total >= MAX_MEMBER)
        {
            throw new TeamException("��Ա�������޷����");
        }
        //�ó�Ա���ǿ�����Ա���޷����
        if(!(e instanceof Programmer))
        {
            throw new TeamException("�ó�Ա���ǿ�����Ա���޷����");
        }
        //��Ա�����ڱ������Ŷ���
        if(isExist(e))
        {
            throw new TeamException("��Ա�����ڱ������Ŷ���");
        }
        //��Ա������ĳ�Ŷӳ�Ա
        //��Ա�������ݼ٣��޷����
        Programmer p = (Programmer)e;//һ���������ClassCastException
//        if("BUSY".equals(p.getStatus().getNAME()))
//        {
//            throw new TeamException("��Ա������ĳ�Ŷӳ�Ա");
//        }
//        else if("VOCATION".equals(p.getStatus().getNAME()))
//        {
//            throw new TeamException("��Ա�������ݼ٣��޷����");
//        }
        switch (p.getStatus())
        {
            case BUSY:
                throw new TeamException("��Ա������ĳ�Ŷӳ�Ա");
            case VOCATION:
                throw new TeamException("��Ա�������ݼ٣��޷����");
        }
        //�Ŷ�������ֻ����һ���ܹ�ʦ
        //�Ŷ�������ֻ�����������ʦ
        //�Ŷ�������ֻ������������Ա

        //��ȡteam���г�Ա�мܹ�ʦ�����ʦ������Ա������
        int numOfArch = 0,numOfDes = 0,numOfPro = 0;
        for (int i = 0;i < total;i++)
        {
            if(team[i] instanceof Architect)
            {
                numOfArch++;
            }
            else if(team[i] instanceof Designer)
            {
                numOfDes++;
            }
            else if(team[i] instanceof Programmer)
            {
                numOfPro++;
            }
        }
        if (p instanceof Architect)
        {
            if (numOfArch >= 1)
            {
                throw new TeamException("�Ŷ�������ֻ����һ���ܹ�ʦ");
            }

        }
        else if(p instanceof Designer)
        {
            if(numOfDes >= 2)
            {
                throw new TeamException("�Ŷ�������ֻ�����������ʦ");
            }
        }
        else if(p instanceof Programmer)
        {
            if(numOfPro >= 3)
            {
                throw new TeamException("�Ŷ�������ֻ������������Ա");
            }
        }
        //�߼�����
//        if(p instanceof Architect && numOfArch >= 1)
//        {
//            throw new TeamException("�Ŷ�������ֻ����һ���ܹ�ʦ");
//        }
//        else if(p instanceof Designer && numOfDes >= 2)
//        {
//            throw new TeamException("�Ŷ�������ֻ�����������ʦ");
//        }
//        else if(p instanceof Programmer && numOfPro >= 3)
//        {
//            throw new TeamException("�Ŷ�������ֻ������������Ա");
//        }

        //��p(��e)��ӵ����е�team��
        team[total++] = p;
        //p�����Ը�ֵ
        p.setStatus(Status.BUSY);
        p.setMemberId(counter++);
    }

    /*
     *@Description �ж�ָ����Ա���Ƿ��Ѿ����������еĿ����Ŷ���
     * @param null
     *@return
    */
    
    private boolean isExist(Employee e)
    {
        for (int i = 0; i < total;i++)
        {
             return team[i].getId() == e.getId();
        }
        return false;
    }

    /*
     *@Description ���Ŷ���ɾ����Ա
     * @param null
     *@return
    */

    public void removeMember(int memberId) throws TeamException
    {
         int i = 0;
         for(;i < total ;i++)
         {
             if(team[i].getMemberId() == memberId)
             {
                 team[i].setStatus(Status.FREE);
                 break;
             }
         }

         //δ�ҵ�ָ����memberId�����
        if (i == total)
        {
            throw new TeamException("�Ҳ���ָ����memberId��Ա����ɾ��ʧ��");
        }

         //ʵ��ɾ������
         for (int j = i + 1;j < total;j++)
         {
             team[j - 1] = team[j];
         }

         team[total-1] = null;
         total--;
         //��
        //team[--total] = null;
    }
}
