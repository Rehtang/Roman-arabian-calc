package ru.Rehtang.service;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import ru.Rehtang.enums.Operator;
import ru.Rehtang.service.impl.ArabicCalculator;
import ru.Rehtang.service.impl.RomanCalculator;
import java.util.Scanner;


public interface Calculator {

  Set<String> OPERATORS = Arrays.stream(Operator.values())
      .map(Operator::getOperator)
      .collect(Collectors.toSet());
  Set<Character> ROMAN_CHARS = Set.of('I', 'V', 'X');

  String calculate();

  static Calculator getCalculator(String str) {
    int operatorChar = str.chars()
        .filter(o -> OPERATORS.contains(Character.toString(o)))
        .findFirst().orElseThrow();
    Operator operator = Operator.getEnum(Character.toString(operatorChar));

    var args = str.trim().split("[-+*/]");
    if (args.length != 2) {
      throw new RuntimeException("check calc args");
    }

    boolean allRoman = true;
    str = args[0] + args[1];
    for (Character ch : str.toCharArray()) {
      if (!ROMAN_CHARS.contains(ch)) {
        System.out.println(ch);
        allRoman = false;
        break;
      }
    }

    if (allRoman) {
      return new RomanCalculator(operator, args[0], args[1]);
    }

    int a = Integer.parseInt(args[0]);
    int b = Integer.parseInt(args[1]);
    if (a >= 1 && a <= 10 && b >= 1 && b <= 10) {
      return new ArabicCalculator(operator, a, b);
    } else {
      throw new RuntimeException("check calc args");
    }
  }
}
