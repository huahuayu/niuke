package cn.liushiming.niuke.solution;

import java.util.Scanner;

/**
 * @Description
 * @Author shiming
 * @Date 2020/7/26 12:08 PM
 * @Version 1.0
 * 题目描述
 * 写出一个程序，接受一个正浮点数值，输出该数值的近似整数值。如果小数点后数值大于等于5,向上取整；小于5，则向下取整。
 * <p>
 * 输入描述:
 * 输入一个正浮点数值
 * <p>
 * 输出描述:
 * 输出该数值的近似整数值
 * <p>
 * 示例1
 * 输入
 * 5.5
 * 输出
 * 6
 **/
public class Round {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a = scanner.nextDouble();
        System.out.println(solution1(a));
        System.out.println(solution2(a));
        System.out.println(solution3(a));
        scanner.close();
    }

    private static int solution1(double a) {
        int b = (int) a;
        if ((a - b) >= 0.5) {
            return (int) (a + 0.5);
        }

        return b;
    }

    /**
     * 用小数点拆分数字，判断小数点后面的数字是否大于5
     *
     * @param a
     * @return
     */
    private static int solution2(double a) {
        String s = String.valueOf(a);
        String[] split = s.split("\\.");
        if (split.length == 0 || split.length == 1) {
            return (int) a;
        } else if (split[1].charAt(0) >= '5') {
            return Integer.valueOf(split[0]) + 1;
        } else {
            return Integer.valueOf(split[0]);
        }
    }

    private static int solution3(double a) {
        return (int) Math.round(a);
    }
}
