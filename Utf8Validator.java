import java.util.*;
public class Utf8Validator {

    public boolean validUtf8(int[] data) {
        int nBytes = 0;
        int mask1 = 1 << 7;
        int mask2 = 1 << 6; 

        for (int num : data) {
            if (nBytes == 0) {
                int mask = 1 << 7;
                while ((num & mask) != 0) {
                    nBytes++;
                    mask >>= 1;
                }
                if (nBytes == 0) {
                    continue;
                }
                if (nBytes == 1 || nBytes > 4) {
                    return false;
                }
            } else {
                if (!((num & mask1) != 0 && (num & mask2) == 0)) {
                    return false;
                }
            }
            nBytes--;
        }
        return nBytes == 0;
    }
    public static void main(String[] args) {
        Utf8Validator validator = new Utf8Validator();
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        str = str.replace("[","").replace("]","");
        String[] a = str.split(",");
        int[] arr = new int[a.length];
        for(int i = 0;i<a.length;i++)
        {
            arr[i] = Integer.parseInt(a[i]);
        }
        System.out.println(validator.validUtf8(arr)); 
        s.close();
    }
}
