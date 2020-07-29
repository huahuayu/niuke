package cn.liushiming.niuke.solution;

import java.util.Scanner;

/**
 * @Description
 * @Author shiming
 * @Date 2020/7/29 8:53 AM
 * @Version 1.0
 * 题目描述
 * Catcher 是MCA国的情报员，他工作时发现敌国会用一些对称的密码进行通信，比如像这些ABBA，ABA，A，123321，但是他们有时会在开始或结束时加入一些无关的字符以防止别国破解。比如进行下列变化 ABBA->12ABBA,ABA->ABAKK,123321->51233214　。因为截获的串太长了，而且存在多种可能的情况（abaaab可看作是aba,或baaab的加密形式），Cathcer的工作量实在是太大了，他只能向电脑高手求助，你能帮Catcher找出最长的有效密码串吗？
 * <p>
 * （注意：记得加上while处理多个测试用例）
 * <p>
 * 输入描述:
 * 输入一个字符串
 * <p>
 * 输出描述:
 * 返回有效密码串的最大长度
 * <p>
 * 示例1
 * 输入
 * ABBA
 * 输出
 * 4
 **/
public class LongestPalindrome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.next();
            System.out.println(solution1(s));
        }
    }

    private static int solution1(String s) {
        int maxLen = 0;
        String maxLenPassword = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String subStr = s.substring(i, j);
                if (isSymmetry(subStr)) {
                    if (subStr.length() > maxLen) {
                        maxLen = subStr.length();
                        maxLenPassword = subStr;
                    }
                }
            }
        }
        return maxLen;
    }

    private static boolean isSymmetry(String s) {
//        char[] arr = s.toCharArray();
//        for (int i = 0; i < arr.length / 2; i++) {
//            char temp = arr[i];
//            arr[i] = arr[arr.length - i - 1];
//            arr[arr.length - i - 1] = temp;
//        }
//
//        if (s.equals(String.valueOf(arr))) {
//            return true;
//        }
//        return false;
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString().equals(s);

    }
}
