package main.top;

public class StringReverser  {

  public static void main(String[] args) {
      var data = new char[]{'h','e','l','l','o'};
      StringReverser reverser = new StringReverser();
      reverser.reverse(data);

      System.out.println(" = " + new String(data));
      reverser.reverse2(data);
      System.out.println(" = " + new String(data));


  }
    
    public void reverse(char[] text) {

        int i = 0;
        int k = text.length -1;

        while (i < k)  {
            char temp = text[i];
            text[i++] = text[k];
            text[k--] = temp;
        }

    }

    public void reverse2(char[] text) {

        int i = 0;
        int k = text.length -1;

        while (i < k)  {
            char temp = text[i];
            text[i++] = text[k];
            text[k--] = temp;
        }

    }

    public void doReverse(char[] text, int i, int j) {
      if (i >= j) {
          return;
      } else {

          char temp = text[i];
          text[i] = text[j];
          text[j] = temp;
          doReverse(text, i +1, j -1);
      }

    }


}
