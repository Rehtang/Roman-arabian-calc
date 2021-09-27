package ru.Rehtang.enums;

import java.util.Arrays;
import java.util.function.IntBinaryOperator;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Operator {

  ADD("+", Integer::sum),
  SUB("-", (x, y) -> x - y),
  MUL("*", (x, y) -> x * y),
  DIV("/", (x, y) -> x / y)
  ;

  private final String operator;
  private final IntBinaryOperator binaryOperator;

  @Override
  public String toString() {
    return operator;
  }

  public static Operator getEnum(String value) {
    return Arrays.stream(Operator.values())
        .filter(lambda -> lambda.operator.equalsIgnoreCase(value))
        .findAny()
        .orElseThrow();
  }
}
