package cn.liushiming.niuke.solution;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * @Description
 * @Author shiming
 * @Date 2020/7/18 9:15 PM
 * @Version 1.0
 * 题目描述
 * 给定一个字符串描述的算术表达式，计算出结果值。
 * <p>
 * 输入字符串长度不超过100，合法的字符包括”+, -, *, /, (, )”，”0-9”，字符串内容的合法性及表达式语法的合法性由做题者检查。本题目只涉及整型计算。
 * <p>
 * 输入描述:
 * 输入算术表达式
 * <p>
 * 输出描述:
 * 计算出结果值
 * <p>
 * 示例1
 * 输入
 * 复制
 * 400+5
 * 输出
 * 复制
 * 405
 * <p>
 * 参考题解：用栈进行表达式求值 https://zhuanlan.zhihu.com/p/24556103
 * 题解：https://www.nowcoder.com/questionTerminal/9999764a61484d819056f807d2a91f1e?answerType=1&f=discussion
 **/
public class Arithmetic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            List<Object> list = IN_TO_POST(str);
            Stack<Integer> stack = new Stack<>();
            for (Object temp : list) {
                if (temp instanceof Integer) {
                    stack.push((Integer) temp);
                } else {
                    int b = stack.pop();
                    int a = stack.pop();
                    stack.push(operation(a, b, (char) temp));
                }
            }
            System.out.println(stack.pop());
        }
    }

    //辅助函数，运算
    private static int operation(int a, int b, char c) {
        switch (c) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                return a / b;
            default:
                System.out.println("invalid operation " + c);
                return 0;
        }
    }

    //将中序字符串转为后序
    private static List<Object> IN_TO_POST(String str) {
        List<Object> list = new ArrayList<>();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            String T = "";
            while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                T = T + str.charAt(i++);
            }
            if (!"".equals(T)) {//是数字直接输出
                list.add(Integer.valueOf(T));
                --i;//注意回退
            } else {//不是数字，则进行判定操作
                if (str.charAt(i) == '(') {//左括号直接压栈
                    stack.push(str.charAt(i));
                } else if (str.charAt(i) == ')') {//右括号弹出栈内元素，直至遇到一个左括号
                    while (stack.peek() != '(') {
                        list.add(stack.pop());
                    }
                    stack.pop();
                } else {//符号的情况
                    if (stack.isEmpty() || prior(str.charAt(i), stack.peek())) {//如果栈为空,或者当前优先级高，直接压栈
                        stack.push(str.charAt(i));
                    } else {//优先级低，触发出栈
                        //三个条件同时满足，则弹出，1.栈不为空，2.栈顶不能是左括号，因为只有右括号有权利将左括号弹出。3.当前元素的优先级小于栈顶元素
                        while (!stack.isEmpty() && stack.peek() != '(' && !prior(str.charAt(i), stack.peek())) {
                            list.add(stack.pop());
                        }
                        //再把当前符号进栈
                        stack.push(str.charAt(i));
                    }
                }
            }
        }
        //当前面的循环进行完的时候，栈里可能还有符号，要将其拿过来，是满足后序的定义的
        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }
        return list;
    }

    //辅助函数，判定两个字符的优先级,优先级高则进栈
    private static boolean prior(char now, char peek) {
        //只有两种情况表示优先级高可以入栈，其余情况都不可以
        if (peek == '(') {
            return true;
        }
        return (now == '*' || now == '/') && (peek == '+' || peek == '-');
    }
}
