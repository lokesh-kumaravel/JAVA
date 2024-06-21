package DP;

import java.util.*;

public class Repeatcoin {
    public static void main(String[] args) {
        int n = 3;
        int[] a = {1,2,3};
        int targetcoin = 10;
        find(n,a,targetcoin);
    }
    private static void find(int n,int[] a,int targetcoin)
    {
        // int[][] dp = new int[targetcoin+1][targetcoin+1];
        @SuppressWarnings("unchecked")
        ArrayList<Integer>[][] dp = new ArrayList[targetcoin+1][targetcoin+1];
        for (int i = 0; i <= targetcoin; i++) {
            for (int j = 0; j <= targetcoin; j++) {
                dp[i][j] = new ArrayList<>(); 
            }
        }
        dp[1][1].add(1);
        for(int i = 2;i<targetcoin+1;i++)
        {
            ArrayList<Integer> temp = new ArrayList<>();
            temp.addAll(dp[1][i-1]);
            temp.add(1);
            dp[1][i].addAll(temp); 
        }
        int k = 2;
        for(int i = 2;i<targetcoin+1;i++)
        {
            for(int j = 0;j<targetcoin+1;j++)
            {
                if(j==i)
                {
                    dp[i][j].add(k);
                }
                else if(j<i)
                {
                    dp[i][j].addAll(dp[i-1][j]);
                }
                else 
                {
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.addAll(dp[i][j-i]);
                    dp[i][j].addAll(temp);
                    dp[i][j].add(k);
                }
            }
            k++;
        }
        for (int i = 0; i <= targetcoin; i++) {
            for (int j = 0; j <= targetcoin; j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
    }
}
