package cn.liushiming.niuke.solution;

import java.util.Scanner;

/**
 * @Description
 * @Author shiming
 * @Date 2020/7/18 8:10 AM
 * @Version 1.0
 * 求int型正整数在内存中存储时1的个数
 * 链接：https://www.nowcoder.com/questionTerminal/440f16e490a0404786865e99c6ad91c9?f=discussion
 * 来源：牛客网
 * <p>
 * 输入一个int型的正整数，计算出该int型数据在内存中存储时1的个数。
 * <p>
 * <p>
 * 输入描述:
 * 输入一个整数（int类型）
 * <p>
 * <p>
 * <p>
 * 输出描述:
 * 这个数转换成2进制后，输出1的个数
 * <p>
 * 示例1
 * 输入
 * 5
 * 输出
 * 2
 **/

public class CountOneInBinary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(solution1(n));
        System.out.println(solution2(n));
        scanner.close();
    }

    /**
     * 先转二进制，再循环计数1的个数
     *
     * @param n
     * @return
     */
    private static int solution1(int n) {
        char[] binaryArray = Integer.toBinaryString(n).toCharArray();
        int count = 0;
        for (char c : binaryArray) {
            if (c == '1') {
                count++;
            }
        }
        return count;
    }

    /**
     * 使用位运算，数字与1相与，
     * Java 位运算(移位、位与、或、异或、非） https://blog.csdn.net/xiaochunyong/article/details/7748713
     *
     * @param n
     * @return
     */
    private static int solution2(int n) {
        int count = 0;
        while (n != 0) {
            if ((n & 1) > 0) {
                count++;
            }
            // >>> 无符号右移，高位补0。如果使用>>带符号右移，负数的时候，高位会补1，所以处理不了输入值为负数的情况
            n = n >>> 1;
        }
        return count;
    }
}
