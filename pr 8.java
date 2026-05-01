import java.util.*;

class Edge implements Comparable<Edge> {
    int src, dest, weight;

    public int compareTo(Edge compareEdge) {
        return this.weight - compareEdge.weight;
    }
}

class Subset {
    int parent, rank;
}

public class KruskalAlgorithm {

    int V, E;
    Edge edges[];

    
    KruskalAlgorithm(int v, int e) {
        V = v;
        E = e;
        edges = new Edge[E];

        for (int i = 0; i < E; i++) {
            edges[i] = new Edge();
        }
    }

   
    int find(Subset subsets[], int i) {
        if (subsets[i].parent != i)
            subsets[i].parent = find(subsets, subsets[i].parent);

        return subsets[i].parent;
    }

   
    void union(Subset subsets[], int x, int y) {
        int xroot = find(subsets, x);
        int yroot = find(subsets, y);

        if (subsets[xroot].rank < subsets[yroot].rank)
            subsets[xroot].parent = yroot;
        else if (subsets[xroot].rank > subsets[yroot].rank)
            subsets[yroot].parent = xroot;
        else {
            subsets[yroot].parent = xroot;
            subsets[xroot].rank++;
        }
    }

    
    void kruskalMST() {

        Edge result[] = new Edge[V];
        int e = 0;
        int i = 0;

        for (i = 0; i < V; i++)
            result[i] = new Edge();

        
        Arrays.sort(edges);

        Subset subsets[] = new Subset[V];
        for (i = 0; i < V; i++) {
            subsets[i] = new Subset();
            subsets[i].parent = i;
            subsets[i].rank = 0;
        }

        i = 0;

        while (e < V - 1 && i < E) {

            Edge nextEdge = edges[i++];

            int x = find(subsets, nextEdge.src);
            int y = find(subsets, nextEdge.dest);

           
            if (x != y) {
                result[e++] = nextEdge;
                union(subsets, x, y);
            }
        }

       
        System.out.println("Edges in MST:");
        for (i = 0; i < e; i++) {
            System.out.println(result[i].src + " - " + result[i].dest + " : " + result[i].weight);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int V = sc.nextInt();

        System.out.print("Enter number of edges: ");
        int E = sc.nextInt();

        KruskalAlgorithm graph = new KruskalAlgorithm(V, E);

        System.out.println("Enter edges (source destination weight):");

        for (int i = 0; i < E; i++) {
            graph.edges[i].src = sc.nextInt();
            graph.edges[i].dest = sc.nextInt();
            graph.edges[i].weight = sc.nextInt();
        }

        long startTime = System.nanoTime();

        graph.kruskalMST();

        long endTime = System.nanoTime();

        System.out.println("Execution Time (ns): " + (endTime - startTime));

        sc.close();
    }
}