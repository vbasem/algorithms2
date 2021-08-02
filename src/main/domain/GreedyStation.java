package main.domain;

import java.util.*;

public class GreedyStation {

    public static void main(String[] args){
        HashMap<String, HashSet<String>> stations = new HashMap<>();

        stations.put("kone",    new HashSet<String>() {{add("id"); add("nv"); add("ut");}});
        stations.put("ktwo",    new HashSet<String>() {{add("wa"); add("id"); add("mt");}});
        stations.put("kthree",  new HashSet<String>() {{add("or"); add("nv"); add("ca");}});
        stations.put("kfour",   new HashSet<String>() {{add("nv"); add("ut");}});
        stations.put("kfive",  new HashSet<String>()  {{add("ca"); add("az");}});
        ArrayList<String> solve = new GreedyStation().solve(stations);
        solve.forEach(System.out::println);
        HashSet<String> a = new HashSet<>();
        HashSet<String> b = new HashSet<>();
    }
    public ArrayList<String> solve(HashMap<String, HashSet<String>> stations) {
        ArrayList<String> solution = new ArrayList<>();
        HashSet<String> visited = new HashSet<>();
        HashSet<String> states = new HashSet<>(){{
            add("id");
            add("wa");
            add("or");
            add("nv");
            add("ca");
            add("ut");
            add("az");
            add("mt");
        }};

        while (states.size() > 0 ) {
            String biggest = "";
            int biggestIntersection = 0;
            for (String station : stations.keySet()) {
                if (!visited.contains(station)) {
                    int contained = 0;
                    for (String i : stations.get(station)) {
                        if (states.contains(i)) {
                            contained++;
                        }
                    }
                    if (Objects.equals("", biggest)) {
                        biggest = station;
                        biggestIntersection = contained;
                    } else {

                        if (biggestIntersection < contained) {
                            biggest = station;
                            biggestIntersection = contained;
                        }
                    }
                }
            }
            solution.add(biggest);
            states.removeAll(stations.get(biggest));
            visited.add(biggest);
        }
        System.out.println(solution);
        return solution;
    }
}
