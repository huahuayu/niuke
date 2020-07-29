package cn.liushiming.niuke.solution;

import java.util.Scanner;

/**
 * @Description
 * @Author shiming
 * @Date 2020/7/29 8:27 PM
 * @Version 1.0
 * 根据输入的日期，计算是这一年的第几天。。
 * <p>
 * 详细描述：
 * <p>
 * 输入某年某月某日，判断这一天是这一年的第几天？
 * 输入描述:
 * 输入三行，分别是年，月，日
 * <p>
 * 输出描述:
 * 成功:返回outDay输出计算后的第几天;
 * 失败:返回-1
 * <p>
 * 示例1
 * 输入
 * 2012
 * 12
 * 31
 * 输出
 * 366
 **/
public class DaysInYear {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int year = scanner.nextInt();
            int month = scanner.nextInt();
            int day = scanner.nextInt();
            System.out.println(solution1(year, month, day));
        }
    }

    private static final int DAYS_28 = 28;
    private static final int DAYS_29 = 29;
    private static final int DAYS_30 = 30;
    private static final int DAYS_31 = 31;

    private static int solution1(int year, int month, int day) {
        int totalDays = 0;

        switch (month) {
            // totalDays从上加到下，因为没有break语句
            case 12:
                totalDays += DAYS_30;
            case 11:
                totalDays += DAYS_31;
            case 10:
                totalDays += DAYS_30;
            case 9:
                totalDays += DAYS_31;
            case 8:
                totalDays += DAYS_31;
            case 7:
                totalDays += DAYS_30;
            case 6:
                totalDays += DAYS_31;
            case 5:
                totalDays += DAYS_30;
            case 4:
                totalDays += DAYS_31;
            case 3:
                // 判断是否是闰年
                if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)) {
                    totalDays += DAYS_29;
                } else {
                    totalDays += DAYS_28;
                }
            case 2:
                totalDays += DAYS_31;
                // 如果是1月份就加上输入的天数
            case 1:
                totalDays += day;
        }

        return totalDays;
    }
}
