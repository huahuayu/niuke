package cn.liushiming.niuke.solution;

import java.util.Scanner;

/**
 * @Description
 * @Author shiming
 * @Date 2020/7/28 11:42 PM
 * @Version 1.0
 * 题目描述
 * 功能: 求一个byte数字对应的二进制数字中1的最大连续数，例如3的二进制为00000011，最大连续2个1
 * <p>
 * 输入: 一个byte型的数字
 * <p>
 * 输出: 无
 * <p>
 * 返回: 对应的二进制数字中1的最大连续数
 * 输入描述:
 * 输入一个byte数字
 * <p>
 * 输出描述:
 * 输出转成二进制之后连续1的个数
 * <p>
 * 示例1
 * 输入
 * 3
 * 输出
 * 2
 **/
public class ContinuousOneInBinary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int a = scanner.nextInt();
            System.out.println(solution1(a));
            //System.out.println(solution2(a));
        }
    }

    private static int solution1(int a) {
        int max = 0;
        int current = 0;
        while (a != 0) {
            if ((a & 1) > 0) {
                System.out.println(a & 1);
                current += 1;
                if (current > max) {
                    max = current;
                }
            } else {
                current = 0;
            }
            a = a >>> 1;
        }
        return max;
    }

    private static int solution2(int a) {
        int max = 0;
        int current = 0;
        String s = Integer.toBinaryString(a);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                current += 1;
                if (current > max) {
                    max = current;
                }
            } else {
                current = 0;
            }
        }
        return max;
    }
}


