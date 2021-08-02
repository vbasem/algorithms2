package main.domain;

import java.util.ArrayList;

public class Player {
    private final String name;
    private final String type;

    public Player(String name, String type) {
        this.name = name;
        this.type = type;
    }


    public void calculateHealth(){
        ArrayList<Integer> hps = new ArrayList<>();
        hps.forEach(hp -> System.out.println(hp+1));
    }
}

class Wizzard extends Player {

    public Wizzard(String name, String type) {
        super(name, type);
    }
}

interface Players {
    String name = "asd";
    String type = "blubl";
    String getType();
    default int getAttack() {
        return 0;
    }
}
