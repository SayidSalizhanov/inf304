package ru.itis.inf304.Exam.Parallelogram;

import java.util.Scanner;

public class StringArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        String[][] strArr = new String[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                strArr[i][j] = scanner.next();
            }
        }
        boolean flag = false;
        for (int j = 0; j < m; j++) {
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (stringExam(strArr[i][j])) count++;
            }
            if (count > 1) {
                flag = true;
                break;
            }
        }
        System.out.println(flag);
    }

    public static boolean stringExam(String str) {
        if (str.length() % 2 != 0) return false;
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(i + str.length() / 2)) return false;
        }
        return true;
    }
}
