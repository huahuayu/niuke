package cn.liushiming.niuke.util;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

/**
 * @Description
 * @Author shiming
 * @Date 2020/7/8 8:57 PM
 * @Version 1.0
 **/
@SpringBootTest
public class UtilTest {
    @Test
    public void scannerTest() {
        // 模拟控制台输入数据
        String data = "line1\nabc de 12 fg hi 34 jk";
        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        Scanner scanner = new Scanner(System.in);
        System.setIn(stdin);
        // 第一行
        System.out.println("read a line: " + scanner.nextLine());
        // 第二行中的输入按空格分隔打印
        while (scanner.hasNext()) {
            // 识别int数字
            if (scanner.hasNextInt()) {
                System.out.println("int: " + scanner.nextInt());
            }
            System.out.println(scanner.next());
        }
        scanner.close();
    }

    @Test
    public void scannerByDelimiter() {

    }
}
