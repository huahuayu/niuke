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
 * 输入一个整数，将这个整数以字符串的形式逆序输出
 * <p>
 * 程序不考虑负数的情况，若数字含有0，则逆序形式也含有0，如输入为100，则输出为001
 **/
public class ReverseNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        String res = "";

        while (num != 0) {
            int t1 = num % 10;  // 获取个位数上的数字
            int t2 = num / 10;  // 截断个位数的数字
            res = res + t1;
            num = t2;
        }
        System.out.println(res);
    }
}
