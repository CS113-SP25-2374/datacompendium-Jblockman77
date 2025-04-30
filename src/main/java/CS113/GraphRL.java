package CS113;

import Interfaces.ListInterface;

public class GraphRL<E> {

    private class Edge {
        String fromNode;
        String toNode;
        int weight;

        public Edge(String form, String to, int weight) {
            fromNode = form;
            toNode = to;
            this.weight = weight;
        }

        public Edge(String form, String to) {
            fromNode = form;
            toNode = to;
        }
    }

    ListInterface<String> nodes = new ArrayListRL<>();
    ListInterface<Edge> edges = new ArrayListRL<>();

    public void add(String node) {
        nodes.add(node);
    }

    public void edge(String node1, String node2, boolean directed) {
        if (!nodes.contains((node1)) || !nodes.contains(node2)) {
            return;
        }
        Edge edge = new Edge(node1, node2);
        if (!edges.contains(edge)) {
            edges.add(edge);
        }
        if (!directed) {
            edge = new Edge(node2, node1);
            if (!edges.contains(edge)) {
                edges.add(edge);
            }
        }
    }

    public ListInterface<String> getNeighbors(String node) {
        ListInterface<String> neighbors = new ArrayListRL<>();
        for (int i = 0; i < edges.size(); i++) {
            if (edges.get(i).fromNode.equals(node)) {
                neighbors.add(edges.get(i).fromNode);
            }
        }
        return neighbors;
    }

    public void printGraph() {

        int n = nodes.size();
        String build = "";

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                String first = nodes.get(i);
                String second = nodes.get(j);
                ListInterface<String> neighbors = getNeighbors(first);
                if (neighbors.contains(second)) {
                    System.out.print("1");
                } else {
                    System.out.print("0");
                }
            }
            System.out.print("\n");
        }
    }
}