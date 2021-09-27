package ru.Rehtang.service.impl;

import lombok.RequiredArgsConstructor;
import ru.Rehtang.enums.Operator;
import ru.Rehtang.enums.RomanNumeral;
import ru.Rehtang.service.Calculator;

@RequiredArgsConstructor
public class RomanCalculator implements Calculator {

  private final Operator operator;
  private final String a;
  private final String b;

  @Override
  public String calculate() {
    int result = operator.getBinaryOperator()
        .applyAsInt(RomanNumeral.romanToInteger(a), RomanNumeral.romanToInteger(b));
    if (result < 0) {
      throw new RuntimeException("result < 0");
    }
    return RomanNumeral.integerToRoman(result);
  }
}
