package cn.liushiming.niuke.solution;

import java.util.Scanner;

/**
 * @Description
 * @Author shiming
 * @Date 2020/7/8 5:08 PM
 * @Version 1.0
 * 题目描述
 * 描述：
 * <p>
 * 输入一个字符串，将这个字符串逆序输出
 * <p>
 * 如输入abc，则输出为cba
 **/
public class ReverseString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
//        System.out.println(solution1(input));
        System.out.println(solution2(input));
    }

    private static String solution1(String input) {
        char[] a = input.toCharArray();
        int len = input.length();
        // 长度是奇数，除中间的字符不对调，前后都对调；长度是偶数，中间的数字是中间偏右的位置，中间的两个数字也对调
        for (int i = 0; i < len / 2; i++) {
            char temp = a[i];
            a[i] = a[len - i - 1];
            a[len - i - 1] = temp;
        }
        return String.valueOf(a);
    }

    /**
     * 使用内建方法，速度方面还更快
     *
     * @param input
     * @return
     */
    private static String solution2(String input) {
        StringBuilder sb = new StringBuilder();
        sb.append(input);
        return sb.reverse().toString();
    }
}
