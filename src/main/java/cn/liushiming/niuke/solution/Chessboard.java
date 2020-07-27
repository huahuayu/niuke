package cn.liushiming.niuke.solution;

import java.util.Scanner;

/**
 * @Description
 * @Author shiming
 * @Date 2020/7/27 9:38 PM
 * @Version 1.0
 * 题目描述
 * 请编写一个函数（允许增加子函数），计算n x m的棋盘格子（n为横向的格子数，m为竖向的格子数）沿着各自边缘线从左上角走到右下角，总共有多少种走法，要求不能走回头路，即：只能往右和往下走，不能往左和往上走。
 * 输入描述:
 * 输入两个正整数
 * <p>
 * 输出描述:
 * 返回结果
 * <p>
 * 示例1
 * 输入
 * 2
 * 2
 * 输出
 * 6
 **/
public class Chessboard {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            System.out.println(solution1(m, n));
        }
    }

    private static int solution1(int m, int n) {
        if (n == 0 || m == 0) {
            return 1;
        } else {
            return solution1(m - 1, n) + solution1(m, n - 1);
        }
    }
}
