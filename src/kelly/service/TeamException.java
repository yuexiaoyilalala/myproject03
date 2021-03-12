package kelly.service;

/**
 * @author Kelly  Email yuexiaoyilalala@gmail.com
 * @version 1.0
 * @Description 自定义异常类
 * @date 2021/1/9 22:13
 */
public class TeamException extends Exception
{
    static final long serialVersionUID = -2387516993124229948L;

    public TeamException()
    {

    }

    public TeamException(String message) {
        super(message);
    }
}
