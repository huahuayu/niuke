package cn.liushiming.niuke.solution;

import java.util.Scanner;

/**
 * @Description
 * @Author shiming
 * @Date 2020/7/29 1:35 PM
 * @Version 1.0
 * 题目描述
 * 验证尼科彻斯定理，即：任何一个整数m的立方都可以写成m个连续奇数之和。
 * <p>
 * 例如：
 * <p>
 * 1^3=1
 * <p>
 * 2^3=3+5
 * <p>
 * 3^3=7+9+11
 * <p>
 * 4^3=13+15+17+19
 * <p>
 * 输入描述:
 * 输入一个int整数
 * <p>
 * 输出描述:
 * 输出分解后的string
 * <p>
 * 示例1
 * 输入
 * 6
 * 输出
 * 31+33+35+37+39+41
 **/
public class SequeOddNum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int a = scanner.nextInt();
            System.out.println(solution1(a));
        }
    }

    private static String solution1(int a) {
        StringBuilder sb = new StringBuilder();
        int a0 = a * a - a + 1;
        sb.append(a0);

        for (int i = 1; i < a; i++) {
            sb.append("+").append(a0 + 2 * i);
        }

        return sb.toString();
    }
}
