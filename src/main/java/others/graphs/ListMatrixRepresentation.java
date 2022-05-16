package others.graphs;

import java.util.LinkedList;

public class ListMatrixRepresentation {

    private int V; // no of vertices in the graph
    private int E; // no of edges in the graph
    LinkedList<Integer>[] adj;

    public ListMatrixRepresentation(int nodes) {
        this.V = nodes;
        this.E = 0;
        this.adj = new LinkedList[nodes];
        for (int i = 0; i < nodes; i++) {
            this.adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int u, int v) {
        this.adj[u].add(v);
        this.adj[v].add(u);
        E++;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(V + " vertices, " + E + " edges " + "\n");
        for(int v = 0; v < V; v++) {
            sb.append(v + ": ");
            for(int w : adj[v]) {
                sb.append(w + " ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        ListMatrixRepresentation lmr = new ListMatrixRepresentation(4);
        lmr.addEdge(0, 1);
        lmr.addEdge(1, 2);
        lmr.addEdge(2, 3);
        lmr.addEdge(3, 0);
        System.out.println(lmr);
    }
}
