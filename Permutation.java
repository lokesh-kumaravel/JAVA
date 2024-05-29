import java.util.*;
public class Permutation {
	public static void main(String[] args) 
	{ 
		Scanner s = new Scanner(System.in);
		char[] stri = s.next().toCharArray();
		Arrays.sort(stri);
		String str = String.valueOf(stri);
		int n = str.length(); 
		int f = 1;
		for(int i = 1;i<=n;i++)
		{
		    f*=i;
		}
		    System.out.println(f);
	ArrayList<String> list = new ArrayList<String>();
		permute(str, 0, n - 1,list); 
		Collections.sort(list);
		Iterator<String> itr = list.iterator();
		while(itr.hasNext())
		{
		    System.out.println(itr.next());
		}
		s.close();
	}
	private static void permute(String str, int l, int r,List<String> list) 
	{ 
		if (l == r) 
		{
		    list.add(str);
		}
		else { 
			for (int i = l; i <= r; i++) { 
				str = swap(str, l, i); 
				permute(str, l + 1, r,list); 
				str = swap(str, l, i); 
			} 
		} 
	} 
	public static String swap(String a, int i, int j) 
	{ 
		char temp; 
		char[] charArray = a.toCharArray(); 
		temp = charArray[i]; 
		charArray[i] = charArray[j]; 
		charArray[j] = temp; 
		return String.valueOf(charArray); 
	} 
} 