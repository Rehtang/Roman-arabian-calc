package ru.Rehtang.enums;

import java.util.Arrays;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RomanNumeral {

  M(1000),
  CM(900),
  D(500),
  CD(400),
  C(100),
  XC(90),
  L(50),
  XL(40),
  X(10),
  IX(9),
  V(5),
  IV(4),
  I(1);

  private final int value;

  public static int romanToInteger(String roman) {
    int res = 0;
    for (int i = 0; i < roman.length(); i++) {
      int s1 = romanValueByChar(roman.charAt(i));
      if (i + 1 < roman.length()) {
        int s2 = romanValueByChar(roman.charAt(i + 1));

        if (s1 >= s2) {
          res = res + s1;
        } else {
          res = res + s2 - s1;
          i++;
        }
      } else {
        res = res + s1;
      }
    }
    return res;
  }

  public static String integerToRoman(int value) {
    StringBuilder roman = new StringBuilder();
    for (int i = 0; i < values().length; i++) {
      while (value >= values()[i].getValue()) {
        value -= values()[i].getValue();
        roman.append(values()[i]);
      }
    }
    return roman.toString();
  }

  static int romanValueByChar(char r) {
    return Arrays.stream(values())
        .filter(o -> o.toString().charAt(0) == r && o.toString().length() == 1)
        .findFirst()
        .orElseThrow()
        .getValue();
  }
}


