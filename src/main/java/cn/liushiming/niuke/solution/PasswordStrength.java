package cn.liushiming.niuke.solution;

import java.util.Scanner;

/**
 * @Description
 * @Author shiming
 * @Date 2020/7/27 10:38 PM
 * @Version 1.0
 * 题目描述
 * 密码按如下规则进行计分，并根据不同的得分为密码进行安全等级划分。
 * <p>
 * 一、密码长度:
 * <p>
 * 5 分: 小于等于4 个字符
 * <p>
 * 10 分: 5 到7 字符
 * <p>
 * 25 分: 大于等于8 个字符
 * <p>
 * 二、字母:
 * <p>
 * 0 分: 没有字母
 * <p>
 * 10 分: 全都是小（大）写字母
 * <p>
 * 20 分: 大小写混合字母
 * <p>
 * 三、数字:
 * <p>
 * 0 分: 没有数字
 * <p>
 * 10 分: 1 个数字
 * <p>
 * 20 分: 大于1 个数字
 * <p>
 * 四、符号:
 * <p>
 * 0 分: 没有符号
 * <p>
 * 10 分: 1 个符号
 * <p>
 * 25 分: 大于1 个符号
 * <p>
 * 五、奖励:
 * <p>
 * 2 分: 字母和数字
 * <p>
 * 3 分: 字母、数字和符号
 * <p>
 * 5 分: 大小写字母、数字和符号
 * <p>
 * 最后的评分标准:
 * <p>
 * >= 90: 非常安全
 * <p>
 * >= 80: 安全（Secure）
 * <p>
 * >= 70: 非常强
 * <p>
 * >= 60: 强（Strong）
 * <p>
 * >= 50: 一般（Average）
 * <p>
 * >= 25: 弱（Weak）
 * <p>
 * >= 0:  非常弱
 * <p>
 * <p>
 * 对应输出为：
 * <p>
 * VERY_SECURE
 * <p>
 * SECURE,
 * <p>
 * VERY_STRONG,
 * <p>
 * STRONG,
 * <p>
 * AVERAGE,
 * <p>
 * WEAK,
 * <p>
 * VERY_WEAK,
 * <p>
 * <p>
 * 请根据输入的密码字符串，进行安全评定。
 * <p>
 * 注：
 * <p>
 * 字母：a-z, A-Z
 * <p>
 * 数字：-9
 * <p>
 * 符号包含如下： (ASCII码表可以在UltraEdit的菜单view->ASCII Table查看)
 * <p>
 * !"#$%&'()*+,-./     (ASCII码：x21~0x2F)
 * <p>
 * :;<=>?@             (ASCII<=><=><=><=><=>码：x3A~0x40)
 * <p>
 * [\]^_`              (ASCII码：x5B~0x60)
 * <p>
 * {|}~                (ASCII码：x7B~0x7E)
 * <p>
 * 接口描述：
 * <p>
 * <p>
 * Input Param
 * String pPasswordStr:    密码，以字符串方式存放。
 * <p>
 * Return Value
 * 根据规则评定的安全等级。
 **/
public class PasswordStrength {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.next();
//            System.out.println(solution1(s));
            System.out.println(solution2(s));
        }
    }

    private static String solution1(String s) {
        char[] arr = s.toCharArray();
        int lengthScore = 0;
        boolean hasLowercaseChar = false;
        boolean hasUppercaseChar = false;
        boolean hasOneNumber = false;
        boolean hasOneSymbol = false;
        final String SYMBOL = "!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~";

        Alphabet alphabet = Alphabet.NOALPHABET;
        Num num = Num.NO_NUM;
        Symbol symbol = Symbol.NO_SYMBOL;
        Other other = Other.LEVEL0;


        int len = arr.length;
        if (len <= 4) {
            lengthScore = 5;
        } else if (len <= 7) {
            lengthScore = 10;
        } else {
            lengthScore = 25;
        }

        for (int i = 0; i < len; i++) {
            if (arr[i] >= 'a' && arr[i] <= 'z') {
                hasLowercaseChar = true;
            }

            if (arr[i] >= 'A' && arr[i] <= 'Z') {
                hasUppercaseChar = true;
            }

            if (hasOneNumber && (arr[i] >= '0' && arr[i] <= '9')) {
                num = Num.MULTI_NUM;
            }

            if (!hasOneNumber && arr[i] >= '0' && arr[i] <= '9') {
                hasOneNumber = true;
                num = Num.ONE_NUM;
            }

            if (hasOneSymbol && (SYMBOL.contains(String.valueOf(arr[i])))) {
                symbol = Symbol.MULTI_SYMBOL;
            }

            if (!hasOneSymbol && SYMBOL.contains(String.valueOf(arr[i]))) {
                hasOneSymbol = true;
                symbol = Symbol.ONE_SYMBOL;
            }
        }

        if (hasLowercaseChar || hasUppercaseChar) {
            alphabet = Alphabet.ALPHABET_ONLY;
        }

        if (hasLowercaseChar && hasUppercaseChar) {
            alphabet = Alphabet.MIXED_ALPHABET;
        }

        if ((hasLowercaseChar || hasUppercaseChar) && hasOneNumber) {
            other = Other.LEVEL1;
        }

        if (other == Other.LEVEL1 && hasOneSymbol) {
            other = Other.LEVEL2;
        }

        if (other == Other.LEVEL2 && (hasLowercaseChar && hasUppercaseChar)) {
            other = Other.LEVEL3;
        }

        int totalScore = lengthScore + alphabet.getScore() + num.getScore() + symbol.getScore() + other.getScore();

        if (totalScore >= 90) {
            return "VERY_SECURE";
        } else if (totalScore >= 80) {
            return "SECURE";
        } else if (totalScore >= 70) {
            return "VERY_STRONG";
        } else if (totalScore >= 60) {
            return "STRONG";
        } else if (totalScore >= 50) {
            return "AVERAGE";
        } else if (totalScore >= 25) {
            return "WEAK";
        }
        return "VERY_WEAK";
    }

    public static String solution2(String s) {
        int sum = 0;
        sum += LengthAdd(s);
        sum += LetterAdd(s);
        sum += IntegerAdd(s);
        sum += SymbolAdd(s);
        sum += AwardAdd(s);
        if (sum >= 90) {
            return "VERY_SECURE";
        } else if (sum >= 80) {
            return " SECURE";
        } else if (sum >= 70) {
            return "VERY_STRONG";
        } else if (sum >= 60) {
            return "STRONG";
        } else if (sum >= 50) {
            return "AVERAGE";
        } else if (sum >= 25) {
            return "WEAK";
        }
        return "VERY_WEAK";
    }

    public static int LengthAdd(String s) {
        if (s.length() <= 4) {
            return 5;
        } else if (s.length() >= 5 && s.length() <= 7) {
            return 10;
        }
        return 25;
    }

    public static int LetterAdd(String s) {
        int UpperLetter = 0;
        int LowerLetter = 0;
        for (int i = 0; i < s.length(); i++) {
            String ch = String.valueOf(s.charAt(i));
            if (ch.matches("[A-Z]")) {
                UpperLetter++;
            } else if (ch.matches("[a-z]")) {
                LowerLetter++;
            }
        }
        if (UpperLetter != 0 && LowerLetter != 0) {
            return 20;
        } else if ((UpperLetter == 0 && LowerLetter != 0) || (UpperLetter != 0 && LowerLetter == 0)) {
            return 10;
        }
        return 0;
    }

    public static int IntegerAdd(String s) {
        int NumOfInteger = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                NumOfInteger++;
            }
        }
        if (NumOfInteger == 0) {
            return 0;
        } else if (NumOfInteger == 1) {
            return 10;
        }
        return 20;
    }

    public static int SymbolAdd(String s) {
        int NumOfSymbol = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if ((ch >= 0x21 && ch <= 0x2F) || (ch >= 0x3A && ch <= 0x40) || (ch >= 0x5B && ch <= 0x60) || (ch >= 0x7B && ch <= 0x7E)) {
                NumOfSymbol++;
            }
        }
        if (NumOfSymbol == 0) {
            return 0;
        } else if (NumOfSymbol == 1) {
            return 10;
        }
        return 25;
    }

    public static int AwardAdd(String s) {
        int LetterNum = LetterAdd(s);
        int IntegerNum = IntegerAdd(s);
        int SymbolNum = SymbolAdd(s);
        if (LetterNum != 0 && IntegerNum != 0 && SymbolNum == 0) {
            return 2;
        } else if (LetterNum == 10 && IntegerNum != 0 && SymbolNum != 0) {
            return 3;
        } else if (LetterNum == 20 && IntegerNum != 0 && SymbolNum != 0) {
            return 5;
        }
        return 0;
    }
}

enum Alphabet {
    // 无字母
    NOALPHABET(0),
    // 仅有大写/小写字母
    ALPHABET_ONLY(10),
    // 大小写字母混合
    MIXED_ALPHABET(20);

    private int score;

    public int getScore() {
        return this.score;
    }

    Alphabet(int score) {
        this.score = score;
    }
}

enum Num {
    // 无数字
    NO_NUM(0),
    // 一个数字
    ONE_NUM(10),
    // 多个数字
    MULTI_NUM(20);

    private int score;

    public int getScore() {
        return this.score;
    }

    Num(int score) {
        this.score = score;
    }
}

enum Symbol {
    // 无符号
    NO_SYMBOL(0),
    // 一个符号
    ONE_SYMBOL(10),
    // 多个符号
    MULTI_SYMBOL(25);

    private int score;

    public int getScore() {
        return this.score;
    }

    Symbol(int score) {
        this.score = score;
    }
}

enum Other {
    // 无
    LEVEL0(0),
    // 字母和数字
    LEVEL1(2),
    // 字母数字和符号
    LEVEL2(3),
    // 大小写字母数字和符号
    LEVEL3(5);

    private int score;

    public int getScore() {
        return this.score;
    }

    Other(int score) {
        this.score = score;
    }
}


