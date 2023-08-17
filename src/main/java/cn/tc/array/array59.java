package cn.tc.array;

import java.util.Arrays;

public class array59 {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(generateMatrix(2)));
    }

    public static int[][] generateMatrix(int n) {
        /*
         *
         * 确定好开闭区间, 定好位置进行旋转
         *
         * */
        int[][] res = new int[n][n];

        int num = 0;//循环次数
        int start = 1;  //计数

        int n1 = 0;

        while (num < n / 2) {       //num=1,n=4
            //从左到右
            for (int i = num; i < n - num; i++) {
                res[num][i] = start;
                n1 = i;
                start++;
            }
            //从上到下
            for (int i = num; i < n - num; i++) {
                if (i != num) {
                    res[i][n1] = start;
                    start++;
                }
            }

            //从右到左
            for (int i = n - num - 1; i >= num; i--) {
                if (i != n - num - 1) {
                    res[n1][i] = start;
                    start++;
                }
            }

            //从下到上
            for (int i = n - num - 1; i > num; i--) {
                if (i != n - num - 1) {
                    res[i][num] = start;
                    start++;
                }
            }


            num++;
        }

        //奇数时
        if (n % 2 == 1) {
            res[num][num] = start;
        }
        return res;
    }
}

//给你一个正整数 n ，生成一个包含 1 到 n² 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
//
//
//
// 示例 1：
//
//
//输入：n = 3
//输出：[[1,2,3],[8,9,4],[7,6,5]]
//
//
// 示例 2：
//
//
//输入：n = 1
//输出：[[1]]
//
//
//
//
// 提示：
//
//
// 1 <= n <= 20
//
//
// Related Topics 数组 矩阵 模拟 👍 1126 👎 0

