package cn.liushiming.niuke.solution;

import java.util.Scanner;

/**
 * @Description
 * @Author shiming
 * @Date 2020/8/23 11:50 AM
 * @Version 1.0
 * 实现 strStr() 函数。
 * <p>
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 * <p>
 * 示例 1:
 * <p>
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * 说明:
 * <p>
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * <p>
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 **/
public class StrInStr {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String haystack = scanner.next();
        String needle = scanner.next();
        System.out.println(strStr(haystack, needle));
    }

    public static int strStr(String haystack, String needle) {
        if (needle == null || "".equals(needle)) {
            return 0;
        }

        if (haystack == null) {
            return -1;
        }

        int len1 = haystack.length();
        int len2 = needle.length();
        if (len2 > len1) {
            return -1;
        }

        for (int i = 0; i < len1 - len2 + 1; i++) {
            if (haystack.charAt(i) == needle.charAt(0) && haystack.substring(i, i + len2).equals(needle)) {
                return i;
            }
        }
        return -1;
    }
}
