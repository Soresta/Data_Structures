import java.util.*;

class DisjktrasGraf {
    private final int V;
    private final List<List<Node>> adjList;

    DisjktrasGraf(int V) {
        this.V = V;
        adjList = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    void addEdge(int source, int destination, int weight) {
        adjList.get(source).add(new Node(destination, weight));
    }

    void dijkstra(int source) {
        PriorityQueue<Node> minHeap = new PriorityQueue<>(Comparator.comparingInt(node -> node.weight));
        int[] distance = new int[V];
        Arrays.fill(distance, Integer.MAX_VALUE);

        minHeap.offer(new Node(source, 0));
        distance[source] = 0;

        while (!minHeap.isEmpty()) {
            Node currentNode = minHeap.poll();
            int currentVertex = currentNode.vertex;

            for (Node neighbor : adjList.get(currentVertex)) {
                int newDistance = distance[currentVertex] + neighbor.weight;

                if (newDistance < distance[neighbor.vertex]) {
                    distance[neighbor.vertex] = newDistance;
                    minHeap.offer(new Node(neighbor.vertex, newDistance));
                }
            }
        }

        // Print the distances from the source vertex
        System.out.println(source + ".Eleman başlangıç noktamız olduğu durumlarda diğer elemanlara en kısa yollar şu şekildedir :");
        for (int i = 0; i < V; i++) {
            System.out.println(i + ". elemana en kısa yol ağırlığı: " + distance[i]);
        }
    }

    static class Node {
        int vertex, weight;

        Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }
}

public class K18_DijkstraAlgorithm {
    public static void main(String[] args) {
        //Test işlemleri
        int V = 5; // 5 tane eleman(node) mevcut
        DisjktrasGraf graph = new DisjktrasGraf(V);

        // 6 tane yol var.
        graph.addEdge(0, 1, 2);
        graph.addEdge(0, 2, 4);
        graph.addEdge(1, 2, 1);
        graph.addEdge(1, 3, 7);
        graph.addEdge(2, 4, 3);
        graph.addEdge(3, 4, 1);

        int sourceVertex = 0;
        graph.dijkstra(sourceVertex);
    }
}

