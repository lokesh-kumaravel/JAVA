package DP.GreedyAlgorithms;

public class LongestCommonSubseqienceLength {
    public static void main(String[] args) {
        char[] a = {'s','t','o','n','e'};
        char[] b = {'l','o','n','g','e','s','t'};
        int[][] dp = new int[a.length+1][b.length+1];
        for(int i = 1;i<=a.length;i++)
        {
            for(int j = 1;j<=b.length;j++)
            {
                if(a[i-1]==b[j-1])
                {
                    dp[i][j] = 1+dp[i-1][j-1];
                }
                else
                {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        for(int i = 0;i<=a.length;i++)
        {
            for(int j = 0;j<=b.length;j++)
            {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("The Longest Common subsequence is : "+dp[a.length][b.length]);
    }
}