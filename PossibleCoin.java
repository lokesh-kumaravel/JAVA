import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();  
        scanner.nextLine();
        String k = scanner.nextLine();
        String[] str = k.split(" ");
        int[] coins = new int[str.length];
        int[] a = new int[str.length];
        for(int i = 0;i<str.length;i++)
        {
            coins[i] = Integer.parseInt(str[i]);
        }
        int[] dp = new int[N + 1];
        dp[0] = 1; 
        for (int coin : coins) {
            for (int i = coin; i <= N; i++) {
                dp[i] += dp[i - coin];
            }
        }
        // for(int i = 0;i<dp.length;i++)
        // {
        //     System.out.print(dp[i]+" ");
        // }
        System.out.println(dp[N]);
    }
}
