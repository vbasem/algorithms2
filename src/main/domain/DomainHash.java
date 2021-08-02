package main.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class DomainHash {

    public static void main(String[] args){
        DomainHash domainHash = new DomainHash();
        domainHash.put("apple", 1);
        domainHash.put("bike", 2);
        domainHash.put("boat", 3);
        domainHash.put("tower", 4);
        domainHash.put("row", 5);
        domainHash.put("row1", 5);
        domainHash.put("row2", 5);
        domainHash.put("roasdw", 5);
        domainHash.put("rofgfdw", 5);
        domainHash.put("roggw", 5);
        domainHash.put("rogghhw", 5);
        domainHash.put("roffdfw", 5);
        domainHash.put("rogggw", 5);

        System.out.println(domainHash.get("apple"));
        System.out.println(domainHash.get("bike"));
        System.out.println(domainHash.get("boat"));
        System.out.println(domainHash.get("tower"));
        System.out.println(domainHash.get("row"));
        System.out.println(domainHash.get("asdasd"));
        System.out.println(domainHash.get("roasdasdfw"));
        System.out.println(domainHash.get("roasfafw"));
        System.out.println(domainHash.get("rfafffow"));
        System.out.println(domainHash.get("rofafffw"));
        System.out.println(Arrays.toString(domainHash.keySet()));
    }



    private DomainEntry[] data;
    private int size = 0;
    private double loadFactor = 0.75;

    public DomainHash() {

        this.data = new DomainEntry[11];

//        System.out.println("size is " + this.data.length);
    }

    protected boolean loadFactorExceeded() {
        return (double) this.size / this.data.length > this.loadFactor;
    }

    public String[] keySet() {
        String[] keys = new String[size];
        int keysIndex = 0;
        for (int i = 0; i < data.length; i++) {
            DomainEntry entry = data[i];
            while (entry != null)  {
                keys[keysIndex++] = entry.key;
                entry = entry.next;
            }
        }

        return keys;
    }

    public void put(String key, int value)  {
        if (loadFactorExceeded()) {
            doubleDataSize();
        }

        int hash = key.hashCode();
        int index = (hash & 2147483647) % this.data.length;
        DomainEntry lastEntry = null;
        for (DomainEntry entry = this.data[index]; entry != null; entry = entry.next) {
            if (entry.hash == hash)  {
                entry.value = value;
                size++;
                return;
            }
            lastEntry = entry;
        }
        DomainEntry entry = new DomainEntry(hash, index, key, value);

        if (lastEntry != null) {
            lastEntry.next = entry;
        } else {
            this.data[index]  = entry;
        }
        size++;
    }

    public int get(String key) {
        int hash = key.hashCode();
        int index = (hash & 2147483647) % this.data.length;
         DomainEntry  e= this.data[index];
        while (e != null) {
            if (e.hash == hash) {
                return e.value;
            }
            e = e.next;
        }

         return 0;
    }

    private void doubleDataSize() {
        synchronized (this.data) {
            DomainEntry[] newdata = new DomainEntry[this.data.length * 2];
            for (int i = 0; i < data.length; i++) {
                newdata[i] = data[i];
            }
            this.data = newdata;
        }
    }

}

class DomainEntry  {
    int hash;
    int index;
    String key;
    int value;
    DomainEntry next = null;

    public DomainEntry(int hash, int index, String key, int value) {
        this.hash = hash;
        this.index = index;
        this.key = key;
        this.value = value;
    }
}