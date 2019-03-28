package com.lh.utils;

import java.util.Scanner;

/**
 * 获取键盘值
 * 
 * @author 水越帆
 * @date 2018年11月20日 下午2:45:41
 */
public class InputUtils {

    private static Scanner scanner = new Scanner(System.in);

    // 获取int值
    public static int getInt(String msg) {

        System.out.println(msg);
        while (true) {
            try {
                return Integer.parseInt(scanner.next());
            } catch (NumberFormatException e) {
                System.out.println("输入错误,请重新输入:");
            }
        }

    }

    // 获取String

    public static String getStr(String string) {
        System.out.println(string);
        return scanner.next();
    }

}
