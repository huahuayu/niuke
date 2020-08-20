package cn.liushiming.niuke.solution;

import java.util.Scanner;

/**
 * @Description
 * @Author shiming
 * @Date 2020/7/30 9:25 AM
 * @Version 1.0
 **/
public class PutAppleInBasket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int m = scanner.nextInt();
            int n = scanner.nextInt();
            System.out.println(solution1(m, n));
        }
    }

    private static int solution1(int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }

        if (m == 1 || n == 1) {
            return 1;
        }

        return solution1(m - n, n) + solution1(m, n - 1);
    }
}
