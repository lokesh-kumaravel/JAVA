import java.util.*;
public class Ncobination { 
	public static void main(String[] args) 
	{ 
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] a = new int[n];
		for(int i = 0;i<n;i++)
		{
			a[i] = s.nextInt();
		}
		int l = 0;
		for(int i = 0;i<n;i++)
		{
			int k = 0;
			while(k<n)
			{
				for(int j = i;j<=k;j++)
				{
					System.out.print(a[j]+" ");
					l = j;
				}
				k++;
				if(l!=n-1)
				{
				System.out.println();
			}
		}
		System.out.println();

		}
		s.close();
	}
} 