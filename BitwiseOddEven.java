import java.util.*;
public class BitwiseOddEven
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        if((n&1)==0&&(m&1)==0)
        {
            n = n<<3;
            m = m<<3;
            System.out.println(n);
            System.out.println(m);
        }
        else if((n&1)!=0&&(m&1)!=0)
        {
            n = n^m;
            m = n^m;
            n = n^m;
            System.out.println(n);
            System.out.println(m);
        }
        else
        {
            System.out.println(n);
            System.out.println(m);
        }
        s.close();
    }
}