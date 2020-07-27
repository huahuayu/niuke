package cn.liushiming.niuke.solution;

import java.util.Scanner;

/**
 * @Description
 * @Author shiming
 * @Date 2020/7/26 12:45 PM
 * @Version 1.0
 * 题目描述
 * 正整数A和正整数B 的最小公倍数是指 能被A和B整除的最小的正整数值，设计一个算法，求输入A和B的最小公倍数。
 * <p>
 * 输入描述:
 * 输入两个正整数A和B。
 * <p>
 * 输出描述:
 * 输出A和B的最小公倍数。
 * <p>
 * 示例1
 * 输入
 * 5 7
 * 输出
 * 35
 **/
public class LeastCommonMultiple {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        System.out.println(solution1(a, b));
    }

    private static int solution1(int a, int b) {
        int i = 1;
        while ((a * i) % b != 0) {
            i++;
        }
        return a * i;
    }
}
