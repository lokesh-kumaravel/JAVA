package DP;
import java.util.*;
public class MaxRectangle {
    public static int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0
           || matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }
        final int rows = matrix.length;
        final int cols = matrix[0].length;
        int[] left = new int[cols];
        int[] right = new int[cols];
        int[] height = new int[cols];
        Arrays.fill(left, 0); 
        Arrays.fill(right, cols); 
        Arrays.fill(height, 0);

        int maxA = 0;
        for (int i = 0; i < rows; i++) {
            int cur_left = 0, cur_right = cols; 
            // compute height (can do this from either side)
            for (int j = 0; j < cols; j++) { 
                if (matrix[i][j] == '1') {
                    height[j]++; 
                }
                else {
                    height[j]=0;
                }
            }
            // compute left (from left to right)
            for (int j = 0; j < cols; j++) { 
                if (matrix[i][j] == '1') {
                    left[j]=Math.max(left[j], cur_left);
                }
                else {
                    left[j] = 0; 
                    cur_left = j + 1;
                }      
            }
            // compute right (from right to left)
            for (int j = cols - 1; j >= 0; j--) {
                if (matrix[i][j] == '1') {
                    right[j] = Math.min(right[j], cur_right);
                }
                else {
                    right[j] = cols; 
                    cur_right = j;   
                }
            }
            // compute the area of rectangle (can do this from either side)
            for (int j = 0; j < cols; j++) {
                maxA = Math.max(maxA, (right[j] - left[j]) * height[j]);
            }   
        }
        
        return maxA;
    }
    
    public static void main(String[] args) {
        char[][] matrix = {
            {'1', '1', '0', '0', '0'},
            {'1', '1', '0', '0', '1'},
            {'1', '1', '1', '1', '0'},
            {'1', '1', '0', '1', '0'}
        };
        for(int i = 0;i<4;i++)
        {
            for(int j =0;j<5;j++)
            {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("Maximal Rectangle Area: " + maximalRectangle(matrix));
    }
}
