package main.domain;

import java.util.ArrayList;

public class DomainString {
    char[] data;
    int length;
    int size;
    public DomainString(int size) {
        this.size = size;
        this.length = 0;
        this.data = new char[size];
    }

    public DomainString(String data) {
        this(data.length());
        for (int i = 0; i < data.length(); i++) {
            this.data[i] = data.charAt(i);
        }
    }

    public void print() {
        System.out.println(this.data);
    }

    public void printReverse(String data) {
        ArrayList<Character> characters = new ArrayList<>();

        if (data == null) {
            return;
        }
        char[] reverse = new char[data.length()];
        for (int i = data.length() - 1; i >= 0; i--) {
            reverse[Math.abs(i - (data.length() -1))] = data.charAt(i);
        }

        for (int i = 0; i < data.length(); i++) {
            reverse[(data.length() -1) - i] = data.charAt(i);
        }

        System.out.println(reverse);
    }
}
