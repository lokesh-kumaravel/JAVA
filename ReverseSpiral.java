import java.util.*;
public class ReverseSpiral
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        int[][] a = new int[n][m];
        for(int i = 0;i<n;i++)
        {
            for(int j = 0;j<m;j++)
            {
                a[i][j] = s.nextInt();
            }
        }
        for(int i = 0;i<n;i++)
        {
            for(int j = 0;j<m;j++)
            {
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("Spiral rotation in forward direction\n");
        int left = 0;
        int right = m-1;
        int top = 0;
        int bottom = n-1;
        while(left<=right&&top<=bottom)
        {
            for(int i = top;i<=bottom;i++)
            {
                System.out.print(a[i][top]+" ");
            }
            left++;
            for(int i = left;i<=right;i++)
            {
                System.out.print(a[bottom][i]+" ");
            }
            bottom--;
            if(top<=bottom)
            {
            for(int i = bottom;i>=top;i--)
            {
                System.out.print(a[i][right]+" ");
            }
            right--;
            }
            if(left<=right)
            {
            for(int i = right;i>=left;i--)
            {
                System.out.print(a[top][i]+" ");
            }
            top++;
            }
        }
        s.close();
    }
}