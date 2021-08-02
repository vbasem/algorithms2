package main.draw;

import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;

public class DrawTree {
        public static void main(String args[]) throws InterruptedException {
            Graph graph = new SingleGraph("Tutorial 1");
            graph.addNode("A" );
            graph.addNode("B" );
            graph.addNode("C" );
            graph.addEdge("AB", "A", "B");
            graph.addEdge("BC", "B", "C");
            graph.addEdge("CA", "C", "A");
            System.setProperty("org.graphstream.ui", "swing");
            graph.display(true);
            graph.addNode("D" );
            Thread.sleep(1000);
            graph.addNode("E" );
            Thread.sleep(1000);
            graph.addEdge("DE", "D", "E");
            Thread.sleep(1000);


        }
}
