import java.util.*;
public class DistinctString {
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        char[] str = s.next().toCharArray();
        int set = 0;
        int c = 0;
        for(int i = 0;i<str.length;i++)
        {
            for(int j = i+1;j<str.length;j++)
            {
                if(str[i]==str[j])
                {
                    set = 1;
                }
            }
            if(set==1)
            {
                c++;
                set = 0;
            }
        }
        System.out.println(c);
        s.close();
    }
    
}
