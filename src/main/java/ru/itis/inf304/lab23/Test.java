package ru.itis.inf304.lab23;

import java.math.BigDecimal;

public class Test {
    public static void main(String[] args) {
        BigDecimal doub = new BigDecimal("0.6745747");
        System.out.println(doub.scale());
    }
}
