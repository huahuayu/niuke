package cn.liushiming.niuke.solution;

import java.util.Scanner;

/**
 * @Description
 * @Author shiming
 * @Date 2020/7/26 10:10 PM
 * @Version 1.0
 * 题目描述
 * 功能:等差数列 2，5，8，11，14。。。。
 * <p>
 * 输入:正整数N >0
 * <p>
 * 输出:求等差数列前N项和
 * <p>
 * 返回:转换成功返回 0 ,非法输入与异常返回-1
 * <p>
 * 本题为多组输入，请使用while(cin>>)等形式读取数据
 * <p>
 * 输入描述:
 * 输入一个正整数。
 * <p>
 * 输出描述:
 * 输出一个相加后的整数。
 * <p>
 * 示例1
 * 输入
 * 2
 * 输出
 * 7
 **/
public class ArithmeticProgression {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            System.out.println(solution1(n));
            System.out.println(solution2(n));
            System.out.println(solution3(n));
        }
        scanner.close();
    }

    /**
     * sum =  (a0 + an) * n / 2
     *
     * @param n
     * @return
     */
    private static int solution1(int n) {
        int a0 = 2;
        int differ = 3;
        int m = n;
        int an = 0;
        while (n > 1) {
            an += differ;
            n--;
        }
        an = a0 + an;
        return (a0 + an) * m / 2;
    }

    /**
     * 递归
     *
     * @param n
     * @return
     */
    private static int solution2(int n) {
        int a0 = 2;
        int differ = 3;
        if (n == 1) {
            return a0;
        } else {
            return solution2(n - 1) + a0 + differ * (n - 1);
        }
    }

    /**
     * sum = a1 * n + n * (n-1) /2 * d
     *
     * @param n
     * @return
     */
    private static int solution3(int n) {
        int a0 = 2;
        int differ = 3;
        return n * a0 + n * (n - 1) / 2 * differ;
    }
}
