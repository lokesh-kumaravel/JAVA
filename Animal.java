package DP;
public class Animal {
    public static int[][] a = {
            { 0, 1, 1, 1, 0, 1, 1, 1, 1, 1 },
            { 1, 1, 1, 1, 1, 1, 1, 1, 0, 1 },
            { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
            { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
            { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
            { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
            { 1, 0, 1, 1, 1, 1, 1, 1, 1, 1 },
            { 0, 1, 1, 1, 1, 1, 1, 1, 1, 0 },
            { 1, 1, 1, 1, 1, 0, 1, 1, 1, 1 },
            { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }
    };
    public static int[][] solution = new int[10][10];
    public static int[][] mainsolution = new int[10][10];
    public static int sense = 2;
    public static int n = 10;
    public static int mainCount = Integer.MAX_VALUE;

    public static void main(String[] args) {
        int r = -1, c = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j] == 0) {
                    r = i;
                    c = j;
                    MakingWalls(r, c);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                solution[i][j] = a[i][j];
            }
        }
        for (int i = 0; i < n; i++) {
            if (a[i][0] == 1) {
                findMinPath(i, 0, 0);
            }
        }
        System.out.println("Shortest Path: "+mainCount);
        System.out.println("Sense: "+sense);
        System.out.println("\nFinal Solution Matrix: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(mainsolution[i][j] + " ");
            }
            System.out.println();
        }
        int row = -1;
    for(int i = 0;i<n;i++)
    {
        if(a[i][0]==9)
        {
            row = i;
        break;
        }
    }
    System.out.println("\nFinal Vertices:");
    findVertices(row,0);
    }
    private static boolean findVertices(int i,int j)
    {
        if(j==n-1&&mainsolution[i][j]==9)
        {
            int row = i+1;
            int column = j+1;
            System.out.println(row +","+ column);
            return true;
        }
        if(i>=0&&i<n&&j>=0&&j<n&&mainsolution[i][j]==9)
        {
            int row = i+1;
            int column = j+1;
            System.out.println(row +","+ column);
            mainsolution[i][j] = 8;
            if(findVertices(i,j+1))
            {
                return true;
            }
            if(findVertices(i-1,j))
            {
                return true;
            }
            if(findVertices(i,j-1))
            {
                return true;
            }
            if(findVertices(i+1,j))
            {
                return true;
            }
            mainsolution[i][j] = 9;
            return false;
        }
        return false;
    }
    private static boolean findMinPath(int i, int j, int count) {
        if (j == n - 1 && a[i][j] == 1) {
            // mainCount = count;
            a[i][j] = 9;
            if (mainCount > count) {
                for (int k = 0; k < n; k++) {
                    for (int l = 0; l < n; l++) {
                        mainsolution[k][l] = a[k][l];
                    }
                }
                mainCount = count;
            }
            return true;
        }
        if (i >= 0 && i < n && j >= 0 && j < n && a[i][j] != 9 && solution[i][j] != 7) {
            a[i][j] = 9;
            if (findMinPath(i, j + 1, count + 1)) {
                return true;
            }
            if (findMinPath(i + 1, j, count + 1)) {
                return true;
            }
            if (findMinPath(i - 1, j, count + 1)) {
                return true;
            }
            if (findMinPath(i, j - 1, count + 1)) {
                return true;
            }
            a[i][j] = 1;
            return false;
        }
        return false;
    }

    private static void MakingWalls(int r, int c) {
        for (int i = 1; i <= sense; i++) {
            if (c + i < n) {
                if (a[r][c + i] != 0) {
                    a[r][c + i] = 7;
                }
            }
        }
        for (int i = 1; i <= sense; i++) {
            {
                if (c - i >= 0) {
                    if (a[r][c - i] != 0)
                        a[r][c - i] = 7;
                }
            }
        }
        for (int i = 1; i <= sense; i++) {
            if (r - i >= 0) {
                if (a[r - i][c] != 0)
                    a[r - i][c] = 7;
            }
        }
        for (int i = 1; i <= sense; i++) {
            if (r + i < n) {
                if (a[r + i][c] != 0)
                    a[r + i][c] = 7;
            }
        }
        int co = 0;
        while (co <= sense)
            for (int i = 1; i <= sense; i++) {
                for (int j = 1; j <= sense; j++) {
                    if (r + i < n && c + j < n)
                        if (a[r + i][c + j] != 0)
                            a[r + i][c + j] = 7;
                }
                co++;
            }
        co = 0;
        while (co <= sense)
            for (int i = 1; i <= sense; i++) {
                for (int j = 1; j <= sense; j++) {
                    if (r + i < n && c - j >= 0)
                        if (a[r + i][c - j] != 0)
                            a[r + i][c - j] = 7;
                }
                co++;
            }
        co = 0;
        while (co <= sense)
            for (int i = 1; i <= sense; i++) {
                for (int j = 1; j <= sense; j++) {
                    if (r - i >= 0 && c + j < n)
                        if (a[r - i][c + j] != 0)
                            a[r - i][c + j] = 7;
                }
                co++;
            }
        co = 0;
        while (co <= sense)
            for (int i = 1; i <= sense; i++) {
                for (int j = 1; j <= sense; j++) {
                    if (r - i >= 0 && c - j >= 0)
                        if (a[r - i][c - j] != 0)
                            a[r - i][c - j] = 7;
                }
                co++;
            }
    }
}
// package DP;

// public class Animal {
// public static int[][] a = {
// { 0, 1, 1, 1, 0, 1, 1, 1, 1, 1 },
// { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
// { 1, 1, 1, 1, 1, 1, 1, 1, 0, 1 },
// { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
// { 1, 1, 1, 1, 1, 0, 1, 1, 1, 1 },
// { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
// { 1, 0, 1, 1, 1, 1, 1, 1, 1, 1 },
// { 1, 1, 1, 1, 1, 1, 1, 1, 1, 0 },
// { 1, 1, 1, 1, 1, 0, 1, 1, 1, 1 },
// { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }
// };
// public static int sense = 1;

// public static void main(String[] args) {
// int n = 10;
// int r = -1, c = -1;
// for (int i = 0; i < n; i++) {
// for (int j = 0; j < n; j++) {
// if (a[i][j] == 0) {
// r = i;
// c = j;
// zero(r, c);
// }
// }
// }
// for (int i = 0; i < n; i++) {
// for (int j = 0; j < n; j++) {
// System.out.print(a[i][j] + " ");
// }
// System.out.println();
// }
// }

// private static void zero(int r, int c) {
// for(int i = 1;i<=sense;i++)
// {
// if(c+i<10)
// {
// a[r][c+i] = 100;
// }
// }
// for(int i = 1;i<=sense;i++)
// {
// if(c-i>=0)
// {
// a[r][c-i] = 100;
// }
// }
// for(int i = 1;i<=sense;i++)
// {
// if(r-i>=0)
// {
// a[r-i][c] = 100;
// }
// }
// for(int i = 1;i<=sense;i++)
// {
// if(r+i<10)
// {
// a[r+1][c] = 100;
// }
// }
// }
// }