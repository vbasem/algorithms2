package main;

import main.domain.*;

import java.security.spec.RSAOtherPrimeInfo;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
  public static void main(String[] args) {
    //        PairSolverTest pairSolverTest = new PairSolverTest();
    //        pairSolverTest.testExisting();
    //        ArrayIntersectionTest ait = new ArrayIntersectionTest();
    //        ait.testIntersection();
    //        ait.testNoIntersection();
    //        DomainString str = new DomainString("abc");
    //        str.print();
    //        str.printReverse("");
    //        new ArrayMerger().testCorrect();
    //        new ArraySumSolver().test();
    //        new MaximumSubarraySolver().test();
    //        new MoveZerosSolver().test();
    //        new ContainsDuplicateSolver().test();
    //        new RotateArraySolver().test();


  }
}
//
// class PairSolverTest {
//    public void testExisting() {
//        int[] input = new int[]{1, 4, 8, 7};
//        PairSolver pairSolver = new PairSolver();
//        boolean answer = pairSolver.solveFor(input, 8);
//
//        if (!answer) {
//            System.out.println("RED, expected to have a true for8");
//        } else {
//            System.out.println("GREEN, testExisting passed");
//        }
//    }
// }
//
// class PairSolver {
//    public boolean solveFor(int[] input, int sum) {
//        Set<Integer> complements = new HashSet<Integer>();
//
//        for (int i : input) {
//            if (complements.contains(i)) {
//                return true;
//            }
//
//
//            complements.add(sum - i);
//        }
//
//        return false;
//    }
// }
//
// class ArrayIntersectionTest {
//    public void testNoIntersection() {
//        int[] setOne = new int[]{1,2,3};
//        int[] setTwo = new int[]{4,5,6};
//
//        ArrayIntersection objectUnderTest = new ArrayIntersection();
//        boolean result = objectUnderTest.intersectionExist(setOne, setTwo);
//
//        if (!result) {
//            System.out.println("GREEN");
//        } else {
//            System.out.println("RED");
//        }
//    }
//    public void testIntersection() {
//        int[] setOne = new int[]{1,2,3};
//        int[] setTwo = new int[]{2,5,6};
//
//        ArrayIntersection objectUnderTest = new ArrayIntersection();
//        boolean result = objectUnderTest.intersectionExist(setOne, setTwo);
//
//        if (!result) {
//            System.out.println("RED");
//        } else {
//            System.out.println("GREEN");
//        }
//    }
// }
//
//
//
// class ArrayIntersection {
//    public boolean intersectionExist(int[] setOne, int[] setTwo) {
//        Set<Integer> setTwoLookup = createLookupTable(setTwo);
//        for (int data: setOne) {
//            if (setTwoLookup.contains(data)) {
//                return true;
//            }
//        }
//
//        return false;
//
//    }
//
//
//    public Set<Integer> createLookupTable(int[] data) {
//        Set<Integer> lookup = new HashSet<>();
//        for (int item: data) {
//            lookup.add(item);
//        }
//        return lookup;
//    }
//
// }
//
//
//
// class Nemo {
//
//    public int findNemo(String[] fishes) {
//        long start = System.nanoTime();
//        for (int i = 0; i < fishes.length; i++) {
//            if (fishes[i] == "nemo") {
//                System.out.println("found nemo at " + i);
//                System.out.println("time execution " + (System.nanoTime() - start));
//
//                return i;
//            }
//        }
//
//
//        return Integer.MIN_VALUE;
//    }
// }
//
//
// class PairPrrinter {
//
//    public void print(int[] inputs) {
//        for (int i = 0; i < inputs.length; i++) {
//            for (int j = 0; j < inputs.length; j++) {
//                System.out.println("pairs [" + inputs[i] + "," + inputs[j] + "]");
//            }
//        }
//    }
//
// }
//
//
