import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] A = new int[N];
        
        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextInt();
        }
        
        int max_xor = 0;
        
        for (int mask = 0; mask < (1 << N); mask++) {
            int xor_subset = 0;
            int count = 0;
            
            for (int i = 0; i < N; i++) {
                if ((mask & (1 << i)) != 0) { 
                    xor_subset ^= A[i];
                    count++;
                }
            }
            
            if (count <= N / 2) { 
                max_xor = Math.max(max_xor, xor_subset);
            }
        }
        System.out.println(max_xor);
    }
}
