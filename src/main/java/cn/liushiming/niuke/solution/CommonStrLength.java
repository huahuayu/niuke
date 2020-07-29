package cn.liushiming.niuke.solution;

import java.util.Scanner;

/**
 * @Description
 * @Author shiming
 * @Date 2020/7/29 1:47 PM
 * @Version 1.0
 * 题目标题：
 * <p>
 * 计算两个字符串的最大公共子串的长度，字符不区分大小写
 * 输入描述:
 * 输入两个字符串
 * <p>
 * 输出描述:
 * 输出一个整数
 * <p>
 * 示例1
 * 输入
 * asdfas
 * werasdfaswer
 * 输出
 * 6
 **/
public class CommonStrLength {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s1 = scanner.next().toLowerCase();
            String s2 = scanner.next().toLowerCase();
            System.out.println(solution1(s1, s2));
        }
    }

    private static int solution1(String s1, String s2) {
        int maxLen = 0;
        for (int i = 0; i < s1.length(); i++) {
            for (int j = i + 1; j < s1.length(); j++) {
                if (s2.contains(s1.substring(i, j)) && s1.substring(i, j).length() > maxLen) {
                    maxLen = s1.substring(i, j).length();
                }
            }
        }
        return maxLen;
    }
}
