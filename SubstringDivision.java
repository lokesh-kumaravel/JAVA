import java.util.Scanner;

public class SubstringDivision {
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        int num = s.nextInt();
        int den = s.nextInt();
        s.close();
        int n = num%den;
        int k = n;
        int c = 0;
        do{
            c++;
            int rem = k*10;
            k = rem%den;
        }while(k!=n);
        System.out.println(c);
    }
}
