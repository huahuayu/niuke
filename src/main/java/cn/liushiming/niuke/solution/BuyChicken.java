package cn.liushiming.niuke.solution;

import java.util.Scanner;

/**
 * @Description
 * @Author shiming
 * @Date 2020/7/29 10:12 PM
 * @Version 1.0
 * 题目描述
 * 公元前五世纪，我国古代数学家张丘建在《算经》一书中提出了“百鸡问题”：鸡翁一值钱五，鸡母一值钱三，鸡雏三值钱一。百钱买百鸡，问鸡翁、鸡母、鸡雏各几何？
 * <p>
 * 详细描述：
 * <p>
 * 接口说明
 * <p>
 * 原型：
 * <p>
 * int GetResult(vector &list)
 * <p>
 * 输入参数：
 * <p>
 * 无
 * <p>
 * 输出参数（指针指向的内存区域保证有效）：
 * <p>
 * list  鸡翁、鸡母、鸡雏组合的列表
 * <p>
 * 返回值：
 * <p>
 * -1 失败
 * <p>
 * 0 成功
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入描述:
 * 输入任何一个整数，即可运行程序。
 * <p>
 * 输出描述:
 * <p>
 * <p>
 * 示例1
 * 输入
 * 复制
 * 1
 * 输出
 * 复制
 * 0 25 75
 * 4 18 78
 * 8 11 81
 * 12 4 84
 **/
public class BuyChicken {
    private static final int TOTAL_PRICE = 100;
    private static final int TOTAL_NUM = 100;
    private static final int PRICE_X = 5;
    private static final int PRICE_Y = 3;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            scanner.next();
            solution1();
        }
    }

    private static void solution1() {
        // 100块钱能买到的鸡，理论上限
        int limitX = TOTAL_PRICE / PRICE_X;
        int limitY = TOTAL_PRICE / PRICE_Y;
        int limitZ = TOTAL_PRICE / 3 * 3;

        for (int i = 0; i < limitX; i++) {
            for (int j = 0; j < limitY; j++) {
                for (int k = 0; k < limitZ; k = k + 3) {
                    if (PRICE_X * i + PRICE_Y * j + k / 3 == TOTAL_PRICE && i + j + k == TOTAL_NUM) {
                        System.out.println(i + " " + j + " " + k);
                    }
                }
            }
        }
    }
}
