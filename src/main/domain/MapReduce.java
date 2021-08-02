package main.domain;

import java.util.ArrayList;
import java.util.Set;
import java.util.stream.Collectors;

public class MapReduce {

    public static void main(String args[])  {
        ArrayList<Integer> integs = new ArrayList<>();
        integs.add(1);
        integs.add(4);
        integs.add(3);
        integs.add(2);
        Integer integer1 = integs.parallelStream().map(x -> x * 2).reduce((integer, integer2) -> integer + integer2).get();
        System.out.println(integer1);
    }
}
