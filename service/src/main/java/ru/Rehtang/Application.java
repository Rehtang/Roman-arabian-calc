package ru.Rehtang;

import ru.Rehtang.service.Calculator;
import java.util.Scanner;


public class Application {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.println("enter expression without spaces:\n");
    String inner = in.nextLine();
    Calculator calculator = Calculator.getCalculator(inner);
    String result = calculator.calculate();
    System.out.println(result);
  }
}
