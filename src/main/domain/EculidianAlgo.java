package main.domain;

public class EculidianAlgo {

    public static void main(String[] args ) {
        int x =  3244;
        int y = 1624;
        int result = new EculidianAlgo().solve(x,  y);
        assert result == 4 : "dgc wasnt correct";
    }

    private int solve(int x, int y) {
        int modulo = x % y;
        if (modulo == 0) {
            return y;
        }
        return this.solve(y, modulo);
    }

}
