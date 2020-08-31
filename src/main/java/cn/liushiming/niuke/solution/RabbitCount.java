package cn.liushiming.niuke.solution;

import java.util.Scanner;

/**
 * @Description
 * @Author shiming
 * @Date 2020/8/31 10:24 AM
 * @Version 1.0
 * 题目描述
 * 有一只兔子，从出生后第3个月起每个月都生一只兔子，小兔子长到第三个月后每个月又生一只兔子，假如兔子都不死，问每个月的兔子总数为多少？
 * <p>
 * 输入描述:
 * 输入int型表示month
 * <p>
 * 输出描述:
 * 输出兔子总数int型
 * <p>
 * 示例1
 * 输入
 * 9
 * 输出
 * 34
 **/
public class RabbitCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            System.out.println(solution1(n));
        }
    }

    private static int solution1(int n) {
        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 1;
        }

        return solution1(n - 1) + solution1(n - 2);
    }
}
