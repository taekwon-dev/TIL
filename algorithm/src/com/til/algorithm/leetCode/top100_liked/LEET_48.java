package com.til.algorithm.leetCode.top100_liked;

/**
 *  You have to rotate the image in-place which means DO NOT allocate another 2D matrix.
 */
public class LEET_48 {

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int line = n % 2 == 0 ? n / 2 : n / 2 + 1;
        int limit = n - 1;

        for (int i = 0; i < line; i++) {
            for (int j = 0; j < limit; j++) {
                int temp = matrix[i][j + i];
                matrix[i][j + i] = matrix[n - 1 - j - i][i];
                matrix[n - 1 - j - i][i] = matrix[n - 1 - i][n - 1 - j - i];
                matrix[n - 1 - i][n - 1 - j - i] = matrix[j + i][n - 1 - i];
                matrix[j + i][n - 1 - i] = temp;
            }
            limit -= 2;
        }
    }
}
