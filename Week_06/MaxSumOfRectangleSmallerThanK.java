/**
 * 363. 矩形区域不超过 K 的最大数值和
 * 给定一个非空二维矩阵 matrix 和一个整数 k，找到这个矩阵内部不大于 k 的最大矩形和。
 * 示例:
 * 输入: matrix = [[1,0,1],[0,-2,3]], k = 2
 * 输出: 2
 * 解释: 矩形区域 [[0, 1], [-2, 3]] 的数值和是 2，且 2 是不超过 k 的最大数字（k = 2）。
 * 说明：
 * 矩阵内的矩形区域面积必须大于 0。
 * 如果行数远大于列数，你将如何解答呢？
 */
public class MaxSumOfRectangleSmallerThanK {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        // 动态规划
        int rows = matrix.length, cols = matrix[0].length,max = Integer.MIN_VALUE;
        for (int l = 0; l < cols; l++) { // 枚举左边界
            int[] rowSum = new int[rows]; // 左边界改变才算区域的重新开始
            for (int r = l; r < cols; r++) { // 枚举右边界
                for (int i = 0; i < rows; i++) { // 按每一行累计到 dp
                    rowSum[i] += matrix[i][r];
                }
                max = Math.max(max, dpmax(rowSum, k));
                if (max == k) return k; // 尽量提前
            }
        }
        return max;
    }
    // 在数组 arr 中，求不超过 k 的最大值
    private int dpmax(int[] arr, int k) {
        int rowSum = arr[0], rowMax = rowSum;
        for(int i = 1; i < arr.length; i++) {
            if(rowSum > 0) rowSum += arr[i];
            else rowSum = arr[i];
            if(rowSum > rowMax) rowMax = rowSum;
        }
        if(rowMax <= k) {
            return rowMax;
        }
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++) {
            int sum = 0;
            for(int j = i; j < arr.length; j++) {
                sum += arr[j];
                if(sum > max && sum <= k) max = sum;
                if (max == k) return max;
            }
        }
        return max;
    }
}
