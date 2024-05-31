import java.util.*;
class KthDistinct {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        HashMap<Integer,Integer> h = new HashMap<>();
        for(int i = 0;i<n;i++)
        {
          int value = s.nextInt();
          int key = s.nextInt();
          if(!h.containsKey(key))
            h.put(key,value);
          else 
            h.put(key, h.getOrDefault(key, 0) + value);
        }
        System.out.println(h);
        int minferq = Integer.MAX_VALUE;
        int minval=0;
        int maxferq = 0;
        int maxval=0;
        for (Map.Entry<Integer, Integer> entry : h.entrySet()) {
          Integer key = entry.getKey();
          Integer value = entry.getValue();
          if(value<minferq)
          {
            minferq = value;
            minval = key;
          }
          if(value>maxferq)
          {
            maxferq = value;
            maxval = key;
          }
      }
      System.out.println(minval-maxval);
      s.close();
    }
}