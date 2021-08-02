package excelsheetcolumnnumber;

import java.util.HashMap;

public class ExcelSheetColumnNumber {

  public static void main(String[] args) {
      ExcelSheetColumnNumber sheet = new ExcelSheetColumnNumber();
    System.out.println("sheet.getColumnNumber(\"A\") = " + sheet.getColumnNumber("A"));
    System.out.println("sheet.getColumnNumber(\"AB\") = " + sheet.getColumnNumber("AB"));
    System.out.println("sheet.getColumnNumber(\"ZY\") = " + sheet.getColumnNumber("ZY"));
    System.out.println("sheet.getColumnNumber(\"AAA\") = " + sheet.getColumnNumber("AAA"));
    System.out.println("sheet.getColumnNumber(\"FXSHRXW\") = " + sheet.getColumnNumber("FXSHRXW"));
  }

    HashMap<Character, Integer> map = new HashMap<>() {{
        put('A',	1);
        put('B',	2);
        put('C',	3);
        put('D',	4);
        put('E',	5);
        put('F',	6);
        put('G',	7);
        put('H',	8);
        put('I',	9);
        put('J',	10);
        put('K',	11);
        put('L',	12);
        put('M',	13);
        put('N',	14);
        put('O',	15);
        put('P',	16);
        put('Q',	17);
        put('R',	18);
        put('S',	19);
        put('T',	20);
        put('U',	21);
        put('V',	22);
        put('W',	23);
        put('X',	24);
        put('Y',	25);
        put('Z',	26);
}};

    public int getColumnNumber(String column)  {


        return getColumnNumber(column.toCharArray(), column.length() -1, 0);


    }

    private int getColumnNumber(char[] column, int index, int multiplier) {
        if (index == -1) {
            return 0;
        }
        double pow = Math.pow(26, multiplier);
        return (int) pow * map.get(column[index]) + getColumnNumber(column, index - 1, multiplier +1);
    }
}
