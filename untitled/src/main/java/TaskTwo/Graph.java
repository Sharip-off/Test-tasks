package TaskTwo;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Graph {
    //Storage for all cities
    public Map<Integer, Node> nodes = new HashMap<>();
    //Storage for all connections with cost
    public int[][] edges = new int[10000][10000];


    //Method for creating new city
    public void addNode(Integer id, String name) {
        //Check on existing in the Map
        if (nodes.get(id) != null) {
            throw new IllegalArgumentException("Node with this ID already exists");
        }
        //Creat new city
        Node newNode = new Node(id);
        newNode.setName(name.toLowerCase());
        //Put it to the Map(storage)
        nodes.put(id, newNode);
    }

    //Create a connection between two cities by name
    public void addEdge(String from, String to, Integer weight) {
        //Get indexes by name
        Integer idFrom = getId(from);
        Integer idTo = getId(to);
        //Get city by index
        Node nodeFrom = nodes.get(idFrom);
        Node nodeTo = nodes.get(idTo);
        //Check on existing
        if (nodeFrom == null || nodeTo == null) {
            throw new IllegalArgumentException("Node with this id does not exist");
        }
        //Check on the loop
        if (nodeFrom == nodeTo) {
            throw new IllegalArgumentException("Loop edge");
        }
        //Add info about adjacent city for each one
        nodeFrom.getAdjacentNodes().add(nodeTo);
        nodeTo.getAdjacentNodes().add(nodeFrom);
        //Save the connection with cost
        edges[idFrom][idTo] = weight;
        edges[idTo][idFrom] = weight;

    }

    //breadth-first traversal of an array
    public void bfs(Node startNode) {
        //For started city set distance value 0
        startNode.setDistance(0);
        // Use a priority queue to always process the node with the smallest distance
        Queue<Node> nodeDeq = new PriorityQueue<>((a, b) -> Integer.compare(b.getDistance(), a.getDistance()));
        //Add to the queue start City
        nodeDeq.add(startNode);
        // Use a priority queue to always process the node with the smallest distance
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.getDistance(), b.getDistance()));
        pq.add(startNode);

        while (!pq.isEmpty()) {
            Node currentNode = pq.poll();
            // Process each adjacent node
            for (Node adjacentNode : currentNode.getAdjacentNodes()) {
                int newDist = currentNode.getDistance() + edges[currentNode.getIndex()][adjacentNode.getIndex()];
                if (newDist < adjacentNode.getDistance()) {
                    adjacentNode.setDistance(newDist);
                    pq.add(adjacentNode); // Add the node with updated distance to the queue
                }
            }
        }
    }

    //Calculate distance between cities
    public int calculateDistanceBetweenNode(String startCity, String endCity) {
        //Get indexes by name
        Integer idFrom = getId(startCity);
        Integer idTo = getId(endCity);
        //Get city by index
        Node nodeFrom = nodes.get(idFrom);
        Node nodeTo = nodes.get(idTo);
        //Before started we need to mark all cities like unvisited
        bfs(nodeFrom);
        Node node = nodes.get(idTo);
        if (node == null) {
            return -1;
        }
        // Get the distance to the target city
        return node.getDistance();
    }

    public Integer getId(String name) {
        String tempName = name.toLowerCase();
        for (int i = 1; i < nodes.values().size() + 1; i++) {
            if (nodes.get(i).getName().equals(tempName)) {
                return i;
            }
        }
        throw new IllegalArgumentException("City with this name does not exist");
    }

    public String showAllNodes() {
        StringBuilder result = new StringBuilder();
        for (Node node : nodes.values()) {
            result.append(node.getName()).append("\n");
        }
        return result.toString();
    }
}
