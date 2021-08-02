package leetcode;

import java.util.HashMap;
import java.util.Map;

public class RomanNumeral {

  public static void main(String[] args) {
      RomanNumeral roman = new RomanNumeral();
    System.out.println("roman.getIntFromRoman(\"CIV\") = " + roman.getIntFromRoman("MCDXMCIV"));
  }

    Map<String, Integer> special = new HashMap<>() {{
        put("IV", 4);
        put("IX", 9);
        put("XC", 40);
        put("XM", 90);
        put("CD", 400);
        put("CM", 900);
        put("I", 1);
        put("V", 5);
        put("X", 10);
        put("C", 100);
        put("D", 500);
        put("M", 1000);
    }};

    public int getIntFromRoman(String romanNumber)  {
        int sum = 0;
        for (int i = 0; i < romanNumber.length(); i++)  {
            if (i +1 < romanNumber.length())  {
                if (special.containsKey(new String(new char[]{romanNumber.charAt(i), romanNumber.charAt(i+1)}))) {
                    sum = sum + special.get(new String(new char[]{romanNumber.charAt(i), romanNumber.charAt(i+1)}));
                    i++;
                    continue;
                }
            }
            sum = sum + special.get(String.valueOf(romanNumber.charAt(i)));
        }
        return sum;
    }
}
