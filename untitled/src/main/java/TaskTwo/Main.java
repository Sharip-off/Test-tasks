package TaskTwo;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Graph graph = new Graph();

        graph.addNode(1, "gdansk");
        graph.addNode(2, "Bydgoszcz");
        graph.addNode(3, "torun");
        graph.addNode(4, "warszawa");

        graph.addEdge("gdansk", "Bydgoszcz", 1);
        graph.addEdge("gdansk", "torun", 3);
        graph.addEdge("Bydgoszcz", "warszawa", 4);
        graph.addEdge("Bydgoszcz", "torun", 1);
        graph.addEdge("torun", "warszawa", 1);


        System.out.println("The cheap way from Gdansk to Warszawa " + graph.calculateDistanceBetweenNode("gdansk", "warszawa"));
        System.out.println();
        System.out.println("The cheap way from Bydgoszcz to Warszawa " + graph.calculateDistanceBetweenNode("bydgoszcz", "warszawa"));
        System.out.println();
    }
}
