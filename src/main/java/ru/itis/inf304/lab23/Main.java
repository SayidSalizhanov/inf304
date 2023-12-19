package ru.itis.inf304.lab23;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        try {
            TradeRequest trade = new TradeRequest(1, new BigDecimal("10.68"));
            System.out.printf("Trade registered with total price = %s for amount = %d%n",
                    trade.getTotal(), trade.getAmount());
        }
//        catch (InvalidAmountException e) {
//            System.out.println(e.getMessage());
//        }
//        catch (InvalidTotalException e) {
//            System.out.println(e.getMessage());
//        }
//        catch (InvalidTotalScaleException e) {
//            System.out.println(e.getMessage());
//        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
