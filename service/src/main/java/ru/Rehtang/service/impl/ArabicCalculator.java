package ru.Rehtang.service.impl;

import lombok.RequiredArgsConstructor;
import ru.Rehtang.enums.Operator;
import ru.Rehtang.service.Calculator;

@RequiredArgsConstructor
public class ArabicCalculator implements Calculator {

  private final Operator operator;
  private final int a;
  private final int b;

  @Override
  public String calculate() {
    return "" + operator.getBinaryOperator().applyAsInt(a, b);
  }
}
