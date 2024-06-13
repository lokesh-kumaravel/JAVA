package Level4.GameTheory;
import java.util.*;
public class GuessingGame 
{
    public static void main(String[] args) 
    {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int left  = 1;
        int right = n;
        int result = find(left,right);
        System.out.println(result);
        s.close();
    }
    private static int find(int left,int right)
    {
        if(left<right)
        {
            int mincost = Integer.MAX_VALUE;
            for(int guess = left;guess<=right;guess++)
            {
                 int cost = guess + Math.max(find(left, guess-1),find(guess+1, right));
                 mincost = Math.min(mincost, cost);
            }
            return mincost;
        }
        return 0;
    }
}