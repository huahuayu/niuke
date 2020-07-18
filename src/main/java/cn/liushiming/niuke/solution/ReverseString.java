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
        Scanner sc = new Scanner(System.in);
        String in = sc.next();
        char[] arr = in.toCharArray();
        for (int i = 0; i < arr.length / 2; i++) {  // 长度是奇数，除中间的字符不对调，前后都对调；长度是偶数，中间的数字是中间偏右的位置，中间的两个数字也对调
            char temp;
            temp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;
        }
        System.out.println(String.valueOf(arr));
    }
}
