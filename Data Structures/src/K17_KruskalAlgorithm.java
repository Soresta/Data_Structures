import java.util.Arrays;
import java.util.Comparator;

class Edge {
    int src, dest, weight;

    Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }
}

public class K17_KruskalAlgorithm {
    private int V, E;
    private Edge[] edges;

    K17_KruskalAlgorithm(int v, int e) {
        V = v;
        E = e;
        edges = new Edge[E];
    }

    void addEdge(int index, int src, int dest, int weight) {
        edges[index] = new Edge(src, dest, weight);
    }

    int find(int[] parent, int i) {
        if (parent[i] == -1)
            return i;
        return find(parent, parent[i]);
    }

    void union(int[] parent, int x, int y) {
        int xSet = find(parent, x);
        int ySet = find(parent, y);
        parent[xSet] = ySet;
    }

    void kruskalMST() {
        Edge result[] = new Edge[V - 1];
        int index = 0;

        Arrays.sort(edges, Comparator.comparingInt(e -> e.weight));

        int[] parent = new int[V];
        Arrays.fill(parent, -1);

        for (int i = 0; i < E && index < V - 1; i++) {
            Edge nextEdge = edges[i];
            int x = find(parent, nextEdge.src);
            int y = find(parent, nextEdge.dest);

            if (x != y) {
                result[index++] = nextEdge;
                union(parent, x, y);
            }
        }

        System.out.println("Edges in the Minimum Spanning Tree:");
        for (int i = 0; i < V - 1; i++) {
            System.out.println(result[i].src + " - " + result[i].dest + "\t" + result[i].weight);
        }
    }

    public static void main(String[] args) {
        int V = 4; // Number of vertices
        int E = 5; // Number of edges
        K17_KruskalAlgorithm graph = new K17_KruskalAlgorithm(V, E);

        // Adding edges: (src, dest, weight)
        graph.addEdge(0, 0, 1, 10);
        graph.addEdge(1, 0, 2, 6);
        graph.addEdge(2, 0, 3, 5);
        graph.addEdge(3, 1, 3, 15);
        graph.addEdge(4, 2, 3, 4);

        graph.kruskalMST();
    }
}
