package cn.liushiming.niuke.solution;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Description 将十进制数转换为二进制数
 * @Author shiming
 * @Date 2020/7/9 11:24 PM
 * @Version 1.0
 **/
public class DecimalToBinary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            int num = scanner.nextInt();
            System.out.println(solution1(num));
            System.out.println(solution2(num));
            System.out.println(solution3(num));
        }
        scanner.close();
    }

    /**
     * 自带utility
     *
     * @param num
     * @return
     */
    private static String solution1(int num) {
        return Integer.toBinaryString(num);
    }

    /**
     * 循环求余数，倒序输出
     *
     * @param num
     * @return
     */
    private static String solution2(int num) {
        List<Integer> remainder = new ArrayList<>();
        String binaryStr = "";
        while (num != 0) {
            remainder.add(num % 2);
            num = num / 2;
        }

        for (int i = remainder.size() - 1; i >= 0; i--) {
            binaryStr = binaryStr + remainder.get(i);
        }
        return binaryStr;
    }

    private static String solution3(int num) {
        return null;
    }
}
