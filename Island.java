public class Island {
    public static int[][] a = {
            { 0, 0, 1, 0, 0, 0 },
            { 1, 1, 0, 1, 0, 1 },
            { 1, 0, 0, 1, 1, 1 },
            { 1, 1, 1, 1, 0, 0 },
            { 0, 0, 0, 0, 1, 0 },
            { 0, 0, 0, 1, 1, 1 }
    };
    public static int[][] solution = new int[6][6];
    public static int count = 1;
    public static int set = 0;

    public static void main(String[] args) {
        int n = 6;
        for (int i = 0; i < n; i++) {
            int r = -1, c = -1;
            for (int j = 0; j < n; j++) {
                if (a[i][j] == 1) {
                    r = i;
                    c = j;
                }
                {
                    find(a, r, c, n);
                    if (set == 1) {
                        set = 0;
                        count++;
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(solution[i][j] + " ");
            }
            System.out.println();
        }
        System.out.print("Count of Island: ");
        System.out.print(count - 1);
    }

    private static boolean find(int[][] a, int i, int j, int n) {
        if (i >= 0 && i <= n - 1 && j >= 0 && j <= n - 1 && solution[i][j] == 0 && a[i][j] != 0) {
            solution[i][j] = count;
            set = 1;
            if (find(a, i + 1, j, n)) {
                return true;
            }
            if (find(a, i, j + 1, n)) {
                return true;
            }
            if (find(a, i - 1, j, n)) {
                return true;
            }
            if (find(a, i, j - 1, n)) {
                return true;
            }
            return false;
        }
        return false;
    }
}