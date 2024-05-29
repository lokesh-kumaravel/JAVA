import java.util.*;
public class Graycode
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        str = str.replace("[","").replace("]","");
        String[] a = str.split(",");
        int[] arr = new int[a.length];
        for(int i = 0;i<a.length;i++)
        {
            arr[i] = Integer.parseInt(a[i]);
        }
        int c = 0;
        for(int i = 0;i<arr.length-1;i++)
        {
            for(int j = i+1;j<=i+1;j++)
            {
                int k = Integer.bitCount(arr[i]^arr[j]);
                if(k==1)
                {
                    c++;
                }
            }
        }
        if(Integer.bitCount(arr[0]^arr[arr.length-1])==1)
        {
            c++;
        }
        if(c==arr.length)
        {
            System.out.println("true");
        }
        else
        {
            System.out.println("false");
        }
        s.close();
    }
}