package DP;
import java.util.*;
import java.math.BigInteger;
public class CoinChange {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] coin = new int[n];
        for(int i = 0;i<n;i++)
        {
            coin[i] = s.nextInt();
        }
        int k = s.nextInt();
        s.close();
        BigInteger[][] dp = new BigInteger[n+1][k+2];
        for(int i = 0;i<=n;i++)
        {
            for(int j = 0;j<=k;j++)
            {
                dp[i][j] = BigInteger.ZERO;
            }
        }
        dp[1][0] = BigInteger.ONE;
        for(int i = 1;i<=n;i++)
        {
            for(int j = 1;j<=k;j++)
            {
                if(j==1)
                {
                    dp[i][j-1] = BigInteger.ONE;
                }
                if(j>=coin[i-1])
                {
                    dp[i][j] = dp[i-1][j].add(dp[i][j-coin[i-1]]);
                }
                else
                {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        // for(int i = 0;i<=n;i++)
        // {
        //     for(int j = 0;j<=k+1;j++)
        //     {
        //         System.out.print(dp[i][j]+" ");
        //     }
        //     System.out.println();
        // }
            System.out.println(dp[n][k]);
    }
}
// package DP;
// public class CoinChange {
//     public static void main(String[] args) {
//         int n = 12;
//         int[] coin = {1,2,3,4,5,8,9,17,23,39,59,67};
//         int k = 50000;
//         int[][] dp = new int[n+1][k+2];
//         dp[1][0] = 1;
//         for(int i = 0;i<k+1;i++)
//         {
//             System.out.print(i+" ");
//         }
//         System.out.println();
//         for(int i = 1;i<=n;i++)
//         {
//             for(int j = 1;j<=k;j++)
//             {
//                 if(j==1)
//                 {
//                     dp[i][j-1] = 1;
//                 }
//                 if(j>=coin[i-1])
//                 {
//                     dp[i][j] = Math.abs(dp[i-1][j])+Math.abs(dp[i][j-coin[i-1]]);
//                 }
//                 else
//                 {
//                     dp[i][j] = Math.abs(dp[i-1][j]);
//                 }
//             }
//         }
//         for(int i = 0;i<=n;i++)
//         {
//             for(int j = 0;j<=k;j++)
//             {
//                 System.out.print(dp[i][j]+" ");
//             }
//             System.out.println();
//         }
//         System.out.println(dp[n][k]);
//     }
// }