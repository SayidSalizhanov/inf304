package ru.itis.inf304.Exam.Triangle;

import java.util.Scanner;

public class SameDigitNums {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] numbers = new int[n][m];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                numbers[i][j] = scanner.nextInt();
            }
        }
        boolean flag = true;
        for (int j = 0; j < m; j++) {
            int counter = 0;
            for (int i = 0; i < n; i++) {
                if (numExamination(numbers[i][j])) counter++;
            }
            if (counter > 3) {
                flag = false;
                break;
            }
        }
        System.out.println(flag);
    }

    public static boolean numExamination(int x) {
        int numLength = (int) Math.floor(Math.log10(x)) + 1;
        int digit = x % 10;
        String num = "";
        for (int i = 0; i < numLength; i++) {
            if (x % 10 != digit) {
                break;
            }
            num += (char)(x % 10);
            x /= 10;
        }
        return (num.length() == numLength);
    }
}
