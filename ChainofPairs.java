package DP.GreedyAlgorithms;
import java.util.*;
public class ChainofPairs {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for(int k = 0;k<t;k++)
        {
        int n = s.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for(int i = 0;i<n;i++)
        {
            a[i] = s.nextInt();
            b[i] = s.nextInt();
        }
        s.close();
        for(int i = 0;i<n;i++)
        {
            for(int j = i+1;j<n;j++)
            {
                if(a[i]>a[j])
                {
                    int t1 = a[i];
                    a[i] = a[j];
                    a[j] = t1;
                    int t2 = b[i];
                    b[i] = b[j];
                    b[j] = t2;
                }
            }
        }
        for(int i = 0;i<n;i++)
        {
            if(a[i]>b[i])
            {
                a[i] = 0;
                b[i] = 0;
            }
        }
        int cast[] = new int[n];
        Arrays.fill(cast, 1);
        for(int i = 1;i<n;i++)
        {
            for(int j = 0;j<i;j++)
            {
                if(a[i]>b[j]&&a[i]!=0&&b[j]!=0)
                {
                    cast[i] = cast[j]+1;
                }
            }
        }
        int max = 0;
        for(int i = 0;i<n;i++)
        {
            max = Math.max(max,cast[i]);
        }
        System.out.println(max);
        }
    }
}