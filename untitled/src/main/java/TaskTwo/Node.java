package TaskTwo;

import java.util.ArrayList;
import java.util.List;

public class Node {
    private Integer index;
    private String name;
    private List<Node> adjacentNodes=new ArrayList<>();
    private int distance=Integer.MAX_VALUE;

    public Node(Integer index) {
        this.index = index;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Node> getAdjacentNodes() {
        return adjacentNodes;
    }

    public void setAdjacentNodes(List<Node> adjacentNodes) {
        this.adjacentNodes = adjacentNodes;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "Node{" +
                "index=" + index +
                ", name='" + name + '\'' +
                ", adjacentNodes=" + adjacentNodes +
                ", distance=" + distance +
                '}';
    }
}
