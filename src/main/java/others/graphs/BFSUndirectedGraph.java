package others.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class BFSUndirectedGraph {
    private int V;
    private int E;
    LinkedList<Integer>[] adjacent;

    public BFSUndirectedGraph(int nodes) {
        this.V = nodes;
        this.E = 0;
        this.adjacent = new LinkedList[nodes];
        for (int i = 0; i < nodes; i++) {
            this.adjacent[i] = new LinkedList<>();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(V + " vertices, " + E + " edges " + "\n");
        for(int v = 0; v < V; v++) {
            sb.append(v + ": ");
            for(int w : adjacent[v]) {
                sb.append(w + " ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public void addEdge(int u, int v) {
        this.adjacent[u].add(v);
        this.adjacent[v].add(u);
        E++;
    }

    public void bfs(int s) {
        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();
        visited[s] = true;
        queue.offer(s);
        while (!queue.isEmpty()) {
            int u = queue.poll();
            System.out.print(u + " ");
            for (int i : adjacent[u]) {
                if (!visited[i]) {
                    visited[i] = true;
                    queue.offer(i);
                }
            }
        }
    }

    public static void main(String[] args) {
        BFSUndirectedGraph bfs = new BFSUndirectedGraph(5);
        bfs.addEdge(0, 1);
        bfs.addEdge(1, 2);
        bfs.addEdge(2, 3);
        bfs.addEdge(3, 0);
        bfs.addEdge(2, 4);
        bfs.bfs(0);
    }

}
