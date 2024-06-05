package TimeComplexity;
import java.util.*;
import java.util.ArrayList;
public class ArrayGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        for(int ix = 0 ; ix < m ; ix++)
        {
            int n = sc.nextInt();
            int arr[] =new int[n];
            ArrayList<Integer>  le = new ArrayList<>();
            ArrayList<Integer> ri  = new ArrayList<>();
            for(int i = 0 ; i < n ; i++)
            {
                arr[i]=sc.nextInt();
                ri.add(arr[i]);
            }
            long turn =1;
            check(le,ri,n,turn);
        }
        sc.close();
    }
    static int check(ArrayList<Integer> le,ArrayList<Integer> ri,int n ,long turn)
    {
        for(int i =  0; i < n-1; i++)
        {
             le.add(ri.remove(0));
            int min = Collections.min(ri);
            int max = Collections.max(le);
            if(max < min)
            {
                turn++;
            }
        }
        if(turn%2==0)
        {
          System.out.println("Jeel");
          return 0 ;
        }
        else
        {
          System.out.println("Ashish");
            return 0;
        }
      
    }
}