package cn.liushiming.niuke.solution;

import java.util.Scanner;

/**
 * @Description
 * @Author shiming
 * @Date 2020/8/18 9:22 PM
 * @Version 1.0
 **/
public class LongestCommonPrefix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strs = scanner.nextLine().split("\\s");
        longestCommonPrefix(strs);
    }

    public static String longestCommonPrefix(String[] strs) {
        // 输入检查
        if (strs == null || strs.length == 0) {
            return "";
        }

        // 字符串数组长度
        int arrayLen = strs.length;
        // 最短字符串长度
        int minLen = Integer.MAX_VALUE;
        // 最短字符串下标
        int p = 0;
        for (int i = 0; i < arrayLen; i++) {
            if (strs[i].length() < minLen) {
                minLen = strs[i].length();
                p = i;
            }
        }

        // 最短字符串
        String minStr = strs[p];

        // 使用最短字符串长度进行循环
        for (int i = 0; i < minLen; i++) {
            for (int j = 0; j < arrayLen; j++) {
                // 其他字符串循环和最短字符串比较
                if (!(minStr.charAt(i) == strs[j].charAt(i))) {
                    // 如果第一位就不匹配，直接返回空字符串
                    if (i == 0) {
                        return "";
                    }
                    // 否则返回最长的匹配
                    return minStr.substring(0, i);
                }
            }
        }
        // 完全匹配，则返回最短字符串
        return minStr;
    }
}
