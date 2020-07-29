package cn.liushiming.niuke.solution;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Description
 * @Author shiming
 * @Date 2020/7/29 4:03 PM
 * @Version 1.0
 * 在命令行输入如下命令：
 * <p>
 * xcopy /s c:\ d:\，
 * <p>
 * 各个参数如下：
 * <p>
 * 参数1：命令字xcopy
 * <p>
 * 参数2：字符串/s
 * <p>
 * 参数3：字符串c:\
 * <p>
 * 参数4: 字符串d:\
 * <p>
 * 请编写一个参数解析程序，实现将命令行各个参数解析出来。
 * <p>
 * <p>
 * <p>
 * 解析规则：
 * <p>
 * 1.参数分隔符为空格
 * 2.对于用“”包含起来的参数，如果中间有空格，不能解析为多个参数。比如在命令行输入xcopy /s “C:\program files abc” “d:\”时，参数仍然是4个，第3个参数应该是字符串C:\program files，而不是C:\program，注意输出参数时，需要将“”去掉，引号不存在嵌套情况。
 * 3.参数不定长
 * 4.输入由用例保证，不会出现不符合要求的输入
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入描述:
 * 输入一行字符串，可以有空格
 * <p>
 * 输出描述:
 * 输出参数个数，分解后的参数，每个参数都独占一行
 * <p>
 * 示例1
 * 输入
 * 复制
 * xcopy /s c:\\ d:\\
 * 输出
 * 复制
 * 4
 * xcopy
 * /s
 * c:\\
 * d:\\
 **/
public class ParseParams {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.nextLine().trim();
            solution1(s);
        }
    }

    private static void solution1(String s) {
        String[] arr = s.split(" ");
        List<String> params = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            String e = arr[i];
            // 处理由引号包围的字符串
            if (e.charAt(0) == '"' && e.charAt(e.length() - 1) == '"') {
                params.add(e.replace("\"", ""));
                // 处理被空格中断的相邻字符串，从左引号开始一直拼接到右引号，中间可能有多个空格，并把引号用substring去掉
            } else if (e.charAt(0) == '"' && e.charAt(e.length() - 1) != '"') {
                String strHolder = e.substring(1);
                int concatWordCount = 0;
                for (int j = 0; j < arr.length - i && i + j + 1 < arr.length - 1; j++) {
                    if (arr[i + j + 1].charAt(arr[i + j + 1].length() - 1) == '"') {
                        strHolder += " " + arr[i + j + 1].substring(0, arr[i + j + 1].length() - 1);
                        concatWordCount++;
                        break;
                    } else {
                        strHolder += " " + arr[i + j + 1];
                        concatWordCount++;
                    }
                }
                params.add(strHolder);
                i += concatWordCount;
            } else {
                params.add(e);
            }
        }
        System.out.println(params.size());
        for (String param : params) {
            System.out.println(param);
        }
    }
}
